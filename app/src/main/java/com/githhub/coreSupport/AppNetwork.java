package com.githhub.coreSupport;

import com.githhub.BuildConfig;
import com.githhub.network.HttpRequest;
import com.githhub.network.RequestInterceptor;
import com.githhub.utils.AppConst;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mohankumar on 2/8/19.
 */

@Module
public class AppNetwork {

    @Provides
    public HttpRequest.HttpService getApiService(Retrofit retrofit){
        return retrofit.create(HttpRequest.HttpService.class);
    }

    @Provides
    public Retrofit getRetrofit(OkHttpClient httpClient){
              return   new Retrofit.Builder()
                .baseUrl(AppConst.BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public OkHttpClient getHttpClient(RequestInterceptor rInterceptor){
        OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
        httpBuilder.addInterceptor(rInterceptor);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            httpBuilder.addInterceptor(logging);
        }

        return httpBuilder.build();

    }

    @Provides
    public RequestInterceptor getRequestIntercept(){
        return new RequestInterceptor();
    }


}
