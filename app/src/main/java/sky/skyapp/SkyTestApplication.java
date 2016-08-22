package sky.skyapp;

import jc.sky.SKYApplication;
import jc.sky.modules.methodProxy.SKYMethods;
import retrofit2.Retrofit;

/**
 * @创建人 sky
 * @创建时间 16/8/22 下午3:43
 * @类描述
 */
public class SkyTestApplication extends SKYApplication {

	@Override public boolean isLogOpen() {
		return true;
	}

	@Override public Retrofit getRestAdapter(Retrofit.Builder builder) {
		return null;
	}

	@Override public SKYMethods getMethodInterceptor(SKYMethods.Builder builder) {
		return builder.build();
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
