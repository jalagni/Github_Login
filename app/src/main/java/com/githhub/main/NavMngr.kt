package com.githhub.main

import com.githhub.R
import com.githhub.base.BaseActivity
import com.githhub.base.BaseFragment
import timber.log.Timber
import java.util.HashMap

/**
 * Created by mohankumar on 9/8/18.
 */

object NavMngr{

    private val hMap = HashMap<String,BaseActivity>()
    private val BASE_ACTIVITY = "default"

    fun registerActivity(bActivity: BaseActivity) {

        if (hMap.containsKey(BASE_ACTIVITY)) {
            Timber.e("Activity already registered")
        }

        hMap.put(BASE_ACTIVITY, bActivity)
    }

    private fun getBaseActivity(): BaseActivity {
        return hMap.get(BASE_ACTIVITY)!!
    }

    fun getFragmentOnTop():BaseFragment{
        val fManager = getBaseActivity().supportFragmentManager
        val bFragment = fManager.fragments[fManager.fragments.size-1];

        return bFragment as BaseFragment

    }

    fun isLastFragment():Boolean{
        val fCount = getBaseActivity().supportFragmentManager.fragments.size
        return  fCount == 1
    }

    fun popFragment(){
        val fManager = getBaseActivity().supportFragmentManager
        fManager.popBackStack()
    }

    fun pushFragment(fragment: BaseFragment) {
        val fTransact = getBaseActivity().supportFragmentManager.beginTransaction()
        fTransact.replace(R.id.iFrame, fragment)
        fTransact.addToBackStack(fragment.javaClass.toString())
        fTransact.commit()
    }

}