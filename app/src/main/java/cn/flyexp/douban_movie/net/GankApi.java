package cn.flyexp.douban_movie.net;

import cn.flyexp.douban_movie.model.GiftModel;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface GankApi {

    @GET("data/福利/{number}/{page}")
    Observable<GiftModel> getGifts(@Path("number") int number, @Path("page") int page);

}
