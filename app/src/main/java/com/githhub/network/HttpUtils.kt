package com.githhub.network

import com.githhub.BuildConfig
import com.githhub.utils.AppConst
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by mohankumar on 9/8/18.
 */
//
//object HttpUtils{
//    fun getRetrofit(): Retrofit {
//        val logging = HttpLoggingInterceptor()
//        logging.level = HttpLoggingInterceptor.Level.BODY
//
//        val httpBuilder = OkHttpClient.Builder()
//        val rInterceptor = RequestInterceptor();
//        httpBuilder.addInterceptor(rInterceptor)
//
//        if (BuildConfig.DEBUG) {
//            httpBuilder.addInterceptor(logging)
//        }
//
//
//        return Retrofit.Builder()
//                .baseUrl(AppConst.BASE_URL)
//                .client(httpBuilder.build())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//
//    }
//
//
//}
