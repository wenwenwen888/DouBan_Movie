package cn.flyexp.douban_movie.net;

import cn.flyexp.douban_movie.model.MovieModel;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Won on 2017/3/14.
 */

public interface DouBanApi {

    @GET("top250")
    Observable<MovieModel> getTop250(@Query("start") int start, @Query("count") int count);

    @GET("search")
    Observable<MovieModel> searchKeyword(@Query("q") String q, @Query("start") int start, @Query("count") int count);

    @GET("search")
    Observable<MovieModel> searchTag(@Query("tag") String tag, @Query("start") int start, @Query("count") int count);

}
