package sky.skyapp.http;

import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @创建人 sky
 * @创建时间 16/8/26 上午11:42
 * @类描述
 */
public interface ITestHttp {

	@POST("") Object login(@Body Object o);
}
