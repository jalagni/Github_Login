package com.githhub.network

import com.githhub.utils.AppConst
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 * Created by mohankumar on 2/8/19.
 */

class RequestInterceptor : Interceptor {


    override fun intercept(chain: Interceptor.Chain?): Response {

        var request = chain!!.request()

        // Read the activity name request header.
        val activityName = request.header(AppConst.HEADER_TAG)

        // Remove it so we don’t send it over the network.
        request = request.newBuilder()
                .removeHeader("Activity-Name")
                .build()

        return chain.proceed(request)
    }

}