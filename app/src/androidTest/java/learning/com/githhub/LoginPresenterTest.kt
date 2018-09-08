package learning.com.githhub

import android.app.ProgressDialog
import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import learning.com.githhub.appModel.UserModel
import learning.com.githhub.base.BaseActivity
import learning.com.githhub.login.LoginPresenterImpl
import learning.com.githhub.network.HttpRequest
import org.hamcrest.Matchers
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito
import org.mockito.Mockito.mock

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class LoginPresenterTest {

    lateinit var context:Context
    lateinit var mCallBack:MockCallback
    lateinit var lImpl:LoginPresenterImpl

    @Before
    fun setup(){
        context = mock(BaseActivity::class.java)
        mCallBack = MockCallback()
        lImpl = LoginPresenterImpl(context,mCallBack)
    }

    @Test
    fun verifyUserLogin(){

        val user = "mohan.wing@hotmail.com"
        val token = "mohan"
        val pass = "mohan"

        val state = lImpl.loginAction(user,token,pass)
        assertThat(true, Matchers.`is`(state))

    }

}

class MockCallback:LoginPresenterImpl.LoginPresenter{
    override fun manageLoader(state: Boolean) {
    }

    override fun onAction(obj: Any) {
    }

    override fun showContent(cModel: UserModel) {
    }

    override fun showDisplay(sMsg: String) {
    }

}


