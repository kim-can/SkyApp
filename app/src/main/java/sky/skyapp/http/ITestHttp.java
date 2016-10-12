package sky.skyapp.http;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import sky.skyapp.http.model.Contributor;
import sky.skyapp.http.model.Model;

/**
 * @创建人 sky
 * @创建时间 16/8/26 上午11:42
 * @类描述
 */
public interface ITestHttp {

	@POST("jincan") Call<Model> login(@Body Object o);

	@GET("/repos/{owner}/{repo}/contributors") Call<List<Contributor>> contributors(@Path("owner") String owner, @Path("repo") String repo);
}
