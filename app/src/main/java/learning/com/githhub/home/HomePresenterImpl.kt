package learning.com.githhub.home

import android.content.Context
import learning.com.githhub.appModel.UserModel
import learning.com.githhub.network.HttpConst
import learning.com.githhub.network.HttpRequest

/**
 * Created by mohankumar on 9/7/18.
 */

class HomePresenterImpl(val context:Context?,val hPresent: HomePresenter):HttpRequest.HttpCallBack{

    override fun onSuccess(rType:HttpConst,obj: Any?) {

    }

    override fun onFailure(rType: HttpConst,obj: Any?) {
        hPresent.showDisplay(obj.toString());
    }

    override fun loaderAction(toShow: Boolean) {

    }

     interface HomePresenter{
        fun onAction( obj:Any);
        fun showContent(cModel: UserModel);
        fun showDisplay(sMsg:String);
     }

}