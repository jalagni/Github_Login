package learning.com.githhub.activity

/**
 * Created by mohankumar on 9/7/18.
 */
class MainPresenterImpl(mPresent: MainPresenter){
    val mImpl: MainPresenter = mPresent;


    interface MainPresenter {
        fun displayMessage()
    }
}