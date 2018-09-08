package learning.com.githhub

import android.text.TextUtils
import learning.com.githhub.login.LoginPresenterImpl
import learning.com.githhub.utils.AppUtils
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.equalTo
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class GithubUnitTest {

    @Test
    fun webUrlValidation(){
       val state =  AppUtils.isWebUrl("htt://www.google.com ")
        assertThat(false, `is`(state))
    }

    @Test
    fun stringValidation(){
        val state =  AppUtils.isValidString(" ")
        assertThat(false, `is`(state))
    }



}
