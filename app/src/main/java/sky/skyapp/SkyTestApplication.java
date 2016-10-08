package sky.skyapp;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;

import java.lang.reflect.Method;

import jc.sky.ISKYBind;
import jc.sky.SKYHelper;
import jc.sky.core.plugin.DisplayStartInterceptor;
import jc.sky.modules.SKYModulesManage;
import jc.sky.modules.log.L;
import jc.sky.modules.methodProxy.SKYMethods;
import jc.sky.view.common.SKYIViewCommon;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sky.skyapp.helper.MyProHelper;
import sky.skyapp.helper.MyProModulesManage;
import sky.skyapp.helper.modules.FakeCrashManage;
import sky.skyapp.view.interceptor.MyProStartInterceptor;

/**
 * @创建人 sky
 * @创建时间 16/8/22 下午3:43
 * @类描述
 */
public class SkyTestApplication extends Application implements ISKYBind, SKYIViewCommon {

	/**
	 * 全局打印日志开关
	 * 
	 * @return
	 */
	@Override public boolean isLogOpen() {
		boolean bool = false;

		switch (BuildConfig.SKY) {
			case 0:// 测试环境
				bool = true;
				L.plant(new CrashReportingTree());
				break;
			case 1:// 线上环境
				bool = false;
				L.plant(new L.DebugTree());
				break;
		}
		return bool;
	}

	/** A tree which logs important information for crash reporting. */
	private static class CrashReportingTree extends L.Tree {
		@Override protected void log(int priority, String tag, String message, Throwable t) {
			if (priority == Log.VERBOSE || priority == Log.DEBUG) {
				return;
			}

			FakeCrashManage.log(priority, tag, message);

			if (t != null) {
				if (priority == Log.ERROR) {
					FakeCrashManage.logError(t);
				} else if (priority == Log.WARN) {
					FakeCrashManage.logWarning(t);
				}
			}
		}
	}

	/**
	 * 实例管理
	 * 
	 * @return
	 */
	@Override public SKYModulesManage getModulesManage() {
		return new MyProModulesManage();
	}

	/**
	 * 网络适配器
	 * 
	 * @param builder
	 * @return
	 */
	@Override public Retrofit getRestAdapter(Retrofit.Builder builder) {

		switch (BuildConfig.SKY) {
			case 0:// 测试环境
				builder.baseUrl("http://www.jincanhsen.com");
				break;
			case 1:// 线上环境
				builder.baseUrl("http://www.baidu.com");
				break;
		}

		builder.addConverterFactory(GsonConverterFactory.create());
		return builder.build();
	}

	/**
	 * 注解@Impl 所有接口方法拦截器
	 * 
	 * @param builder
	 * @return
	 */
	@Override public SKYMethods getMethodInterceptor(SKYMethods.Builder builder) {
		builder.setDisplayStartInterceptor(new MyProStartInterceptor());
		return builder.build();
	}

	@Override public void onCreate() {
		super.onCreate();
		MyProHelper.newBind().setSkyBind(this).Inject(this);
	}

	@Override public int layoutLoading() {
		return 0;
	}

	@Override public int layoutEmpty() {
		return 0;
	}

	@Override public int layoutBizError() {
		return 0;
	}

	@Override public int layoutHttpError() {
		return 0;
	}
}
