package sky.skyapp;

import android.app.Application;

import java.lang.reflect.Method;

import jc.sky.ISKYBind;
import jc.sky.core.plugin.DisplayStartInterceptor;
import jc.sky.modules.SKYModulesManage;
import jc.sky.modules.methodProxy.SKYMethods;
import jc.sky.view.common.SKYIViewCommon;
import retrofit2.Retrofit;
import sky.skyapp.helper.MyProHelper;
import sky.skyapp.helper.MyProModulesManage;
import sky.skyapp.view.interceptor.MyProStartInterceptor;

/**
 * @创建人 sky
 * @创建时间 16/8/22 下午3:43
 * @类描述
 */
public class SkyTestApplication extends Application implements ISKYBind,SKYIViewCommon {

	/**
	 * 全局打印日志开关
	 * 
	 * @return
	 */
	@Override public boolean isLogOpen() {
		return true;
	}

	/**
	 * 实例管理
	 * 
	 * @return
	 */
	@Override public SKYModulesManage getModulesManage() {
		return new MyProModulesManage(this);
	}

	/**
	 * 网络适配器
	 * 
	 * @param builder
	 * @return
	 */
	@Override public Retrofit getRestAdapter(Retrofit.Builder builder) {
		builder.baseUrl("http://www.baidu.com");
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
		MyProHelper.bind(this);
	}

	@Override
	public int layoutLoading() {
		return 0;
	}

	@Override
	public int layoutEmpty() {
		return 0;
	}

	@Override
	public int layoutBizError() {
		return 0;
	}

	@Override
	public int layoutHttpError() {
		return 0;
	}
}
