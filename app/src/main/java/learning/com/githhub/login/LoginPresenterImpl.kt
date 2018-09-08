package learning.com.githhub.login

import android.app.Activity
import android.content.Context
import learning.com.githhub.R
import learning.com.githhub.appModel.UserModel
import learning.com.githhub.base.BaseActivity
import learning.com.githhub.network.HttpConst
import learning.com.githhub.network.HttpRequest
import learning.com.githhub.utils.AppUtils
import timber.log.Timber

/**
 * Created by mohankumar on 9/7/18.
 */

class LoginPresenterImpl(val context: Context?,val hPresent: LoginPresenter): HttpRequest.HttpCallBack {
    val  hRequest: HttpRequest = HttpRequest(this);


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