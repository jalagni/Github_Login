package learning.com.githhub.utils

import android.support.design.widget.Snackbar
import android.util.Base64
import android.view.View
import learning.com.githhub.appModel.UserModel
import timber.log.Timber
import java.util.ArrayList
import android.text.TextUtils
import android.app.Activity
import android.view.inputmethod.InputMethodManager


/**
 * Created by mohankumar on 9/8/18.
 */

object AppUtils{

    fun hideKeyBoard(activity:Activity){
        val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE)

        if(imm == null)
            return

        val iManager = imm as InputMethodManager

        //Find the currently focused view, so we can grab the correct window token from it.
        var view = activity.getCurrentFocus()
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(activity)
        }

        iManager.hideSoftInputFromWindow(view!!.getWindowToken(), 0)
    }

    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

//        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    // create Base64 encode string
    fun getBytes(strBase: String): String {
        return "Basic " + Base64.encodeToString(strBase.toByteArray(), Base64.NO_WRAP)
    }

    fun showMessage(view: View, sText: String) {
        Snackbar.make(view, sText, Snackbar.LENGTH_SHORT).show()
    }


    fun isValidString(sValue: String?): Boolean {
        return  !(sValue == null || sValue.trim().length == 0)
    }

    fun getList(lModel: UserModel?): ArrayList<Pair<String, String>> {

        val arrayList = ArrayList<Pair<String,String>>()

        if (lModel == null){
            return arrayList;
        }

        arrayList.add(getPairObj("User Id",lModel.id.toString()))
        arrayList.add(getPairObj("Login",lModel.login))
        arrayList.add(getPairObj("Created Date",lModel.created_at))
        arrayList.add(getPairObj("Modified Date",lModel.updated_at))
        arrayList.add(getPairObj("Gist_Url",lModel.gists_url))
        arrayList.add(getPairObj("Github Url",lModel.url))

        return arrayList
    }

    fun getPairObj(sIndex:String,sValue:String):Pair<String,String>{
        return Pair(sIndex,sValue)
    }

    fun isWebUrl(strUrl:String):Boolean{
        if (!AppUtils.isValidString(strUrl))
            return false

        return strUrl.startsWith("http:",true) ||
                strUrl.startsWith("https:")

    }

}