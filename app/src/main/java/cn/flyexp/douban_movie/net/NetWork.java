package cn.flyexp.douban_movie.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Won on 2017/3/14.
 */

public class NetWork {

    private static DouBanApi douBanApi;

    public static DouBanApi getDouBanApi() {
        if (douBanApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.douban.com/v2/movie/")
                    .addConverterFactory(GsonConverterFactory.create())//使用工厂模式创建Gson的解析器
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            douBanApi = retrofit.create(DouBanApi.class);
        }
        return douBanApi;
    }

}
