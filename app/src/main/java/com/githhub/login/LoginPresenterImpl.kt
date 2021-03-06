package com.githhub.login

import android.content.Context
import com.githhub.R
import com.githhub.appModel.UserModel
import com.githhub.base.BaseActivity
import com.githhub.base.MainApp
import com.githhub.network.HttpConst
import com.githhub.network.HttpRequest
import com.githhub.utils.AppUtils
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by mohankumar on 9/7/18.
 */

class LoginPresenterImpl(val context: Context?,val hPresent: LoginPresenter): HttpRequest.HttpCallBack {

    lateinit var  hRequest: HttpRequest;

    @Inject
    lateinit var hService: HttpRequest.HttpService;

    init {

        val mApp = context?.applicationContext as MainApp
        mApp.aComponent.inject(this);

        hRequest = HttpRequest(hService,this);
    }


    fun loginAction(strUser:String,strToken:String,strPass:String):Boolean{

        if (!AppUtils.isValidString(strUser)){
            hPresent.showDisplay(context!!.getString(R.string.enterUser))
            return false
        }


        if (!AppUtils.isValidEmail(strUser)){
            hPresent.showDisplay(context!!.getString(R.string.enterValidEmail))
            return false
        }

        val hasParam = AppUtils.isValidString(strToken) || AppUtils.isValidString(strPass)

        if(!hasParam){
            hPresent.showDisplay(context!!.getString(R.string.enterLoginDetail))
            return false
        }

        AppUtils.hideKeyBoard(context as BaseActivity)

        if (AppUtils.isValidString(strToken)){
            hRequest.loginUserWithToken(strUser,strToken)
            return true
        }

        hRequest.loginUserWithPassword(strUser,strPass)
        return true
    }



    override fun onSuccess(rType:HttpConst,obj: Any?) {
        if (obj == null || !(obj is UserModel)){
            hPresent.showDisplay("Error Response");
            return;
        }

        when(rType){
            HttpConst.LOGIN_TOKEN -> {
                Timber.e("Login With Token Success")
                hPresent.showContent(obj);
            }

            HttpConst.LOGIN_PASSWORD ->{
                Timber.e("Login With Password Success")
                hPresent.showContent(obj);
            }
        }

    }

    override fun loaderAction(toShow: Boolean) {
        hPresent.manageLoader(toShow)
    }


    override fun onFailure(rType: HttpConst,obj: Any?) {
        hPresent.showDisplay(obj.toString());
    }


     interface LoginPresenter{
        fun onAction( obj:Any);
        fun showContent(cModel: UserModel);
        fun showDisplay(sMsg:String)
        fun manageLoader(state:Boolean)
     }

}