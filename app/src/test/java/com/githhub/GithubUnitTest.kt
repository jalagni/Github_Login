package com.githhub

import com.githhub.utils.AppUtils
import org.hamcrest.Matchers.`is`
import org.junit.Test

import org.junit.Assert.*

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
