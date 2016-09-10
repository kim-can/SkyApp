package sky.skyapp.view;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import jc.sky.core.Impl;
import jc.sky.view.SKYActivity;
import jc.sky.view.SKYBuilder;
import sky.skyapp.R;
import sky.skyapp.helper.MyProHelper;

@Impl(LoginActivity.class)
interface ILoginActivity {

	/**
	 * 进度
	 * 
	 * @param ishow
	 *            true 开 false 关
	 */
	void loading(boolean ishow);

	/**
	 * 修改登陆按钮名称
	 * 
	 * @param name
	 */
	void changeLoginBtnName(String name);
}

public class LoginActivity extends SKYActivity<ILoginBiz> implements ILoginActivity {

	@BindView(R.id.email) public AutoCompleteTextView	mEmailView;			// 邮箱

	@BindView(R.id.password) public EditText			mPasswordView;		// 密码

	@BindView(R.id.login_progress) public View			mLoginFormView;		// 进度

	@BindView(R.id.email_sign_in_button) public Button	emailSignInButton;	// 进度

	@Override protected SKYBuilder build(SKYBuilder skyBuilder) {
		skyBuilder.layoutId(R.layout.activity_login);
		return skyBuilder;
	}

	@Override protected void initData(Bundle bundle) {}

	/**
	 * 登陆
	 */
	@OnClick(R.id.email_sign_in_button) public void onLogin() {
//		for (int i = 0; i < 3; i++) {
//			biz().login(mEmailView.getText().toString() + ":" + i, mPasswordView.getText().toString() + ":" + i);
//		}


		try {
			int CLIENT_VERSION_CODE = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
			String CLIENT_VERSION_NAME = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
			MyProHelper.toast().show("CLIENT_VERSION_CODE:"+CLIENT_VERSION_CODE+",CLIENT_VERSION_NAME"+CLIENT_VERSION_NAME);

		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		}


	}

	/**
	 * 显示渠道
	 */
	@OnClick(R.id.btn_show_channel) public void onShowChannel() {
		MyProHelper.toast().show(MyProHelper.channel().getChannel());
	}


	@Override public void loading(boolean ishow) {
		mLoginFormView.setVisibility(ishow ? View.VISIBLE : View.GONE);
	}

	@Override public void changeLoginBtnName(String name) {
		emailSignInButton.setText(name);
	}
}
