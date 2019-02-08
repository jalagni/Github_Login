package com.githhub.network

import com.githhub.appModel.BaseModel
import com.githhub.appModel.UserModel
import com.githhub.utils.AppConst
import com.githhub.utils.AppUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Header
import javax.inject.Inject

/**
 * Created by mohankumar on 9/7/18.
 */

class HttpRequest(val hService:HttpService,
                  val hCallBack:HttpCallBack): Callback<BaseModel> {


    fun loginUserWithToken(username:String,token:String){
        val credentials = username + ":" + token;
        val sBase = AppUtils.getBytes(credentials);

        val call:Call<BaseModel> = hService.loginUserToken(HttpConst.LOGIN_TOKEN.ordinal,sBase) as Call<BaseModel>;
        processRequest(call);
    }


    fun loginUserWithPassword(username:String,password:String){
        val credentials = username + ":" + password;
        val sBase = AppUtils.getBytes(credentials);

        val call:Call<BaseModel> = hService.loginUserPassword(HttpConst.LOGIN_PASSWORD.ordinal,sBase) as Call<BaseModel>;
        processRequest(call);
    }


    private fun processRequest(call: Call<BaseModel>) {
        call.enqueue(this);
        hCallBack.loaderAction(true)
    }


    override fun onResponse(call: Call<BaseModel>?, response: Response<BaseModel>?) {
        val ordinal =  call!!.request().header(AppConst.HEADER_TAG)!!.toInt();
        val rType = HttpConst.values()[ordinal]

        hCallBack.onSuccess(rType,response?.body());
        hCallBack.loaderAction(false)
    }

    override fun onFailure(call: Call<BaseModel>?, t: Throwable?) {
        val ordinal =  call!!.request().header(AppConst.HEADER_TAG) as Int;
        val rType = HttpConst.values()[ordinal]

        hCallBack.onFailure(rType,t.toString());
        hCallBack.loaderAction(false)
    }

    open interface HttpCallBack{
        fun loaderAction(toShow:Boolean)
        fun onSuccess(rType:HttpConst,obj:Any?);
        fun onFailure(rType: HttpConst,obj:Any?);
    }


    interface HttpService {
        @GET("user")
        fun loginUserToken(@Header(AppConst.HEADER_TAG) header:Int, @Header("Authorization") token: String): Call<UserModel>

        @GET("user")
        fun loginUserPassword(@Header(AppConst.HEADER_TAG) header:Int,@Header("Authorization") token: String): Call<UserModel>
    }


}