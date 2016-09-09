package sky.skyapp.view;

import java.io.IOException;

import jc.sky.SKYHelper;
import jc.sky.core.Impl;
import jc.sky.core.SKYBiz;
import jc.sky.core.SKYIBiz;
import jc.sky.modules.log.L;
import jc.sky.modules.methodProxy.Background;
import jc.sky.modules.threadpool.BackgroundType;
import retrofit2.Call;
import sky.skyapp.http.ITestHttp;
import sky.skyapp.http.model.Model;

/**
 * @创建人 sky
 * @创建时间 16/8/22 下午3:40
 * @类描述 一句话描述你的业务
 */
@Impl(LoginBiz.class)
interface ILoginBiz extends SKYIBiz {

	/**
	 * 登陆
	 * 
	 * @param s
	 *            账号
	 * @param s1
	 *            密码
	 */
	@Background(BackgroundType.HTTP) void login(String s, String s1);

	/**
	 * 更新登陆页面按钮
	 */
	void updateBtn();

}

class LoginBiz extends SKYBiz<ILoginActivity> implements ILoginBiz {

	@Override public void login(String s, String s1) {
		L.i("我是执行的:" + s + ":" + s1);
		ui().loading(true);

		L.i("地址"+SKYHelper.httpAdapter().baseUrl().url());

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		ui().changeLoginBtnName("登陆成功啦~~~");
		ui().loading(false);

		// 跳转
		ListActivity.intent();
	}

	@Override public void updateBtn() {
		ui().changeLoginBtnName("List更新了~~");
	}
}