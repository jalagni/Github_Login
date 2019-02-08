package com.githhub.base

import android.app.Application
import com.githhub.BuildConfig
import com.githhub.coreSupport.AppComponent
import com.githhub.coreSupport.AppNetwork
import com.githhub.coreSupport.DaggerAppComponent
import timber.log.Timber

/**
 * Created by mohankumar on 9/7/18.
 */
class MainApp: Application() {

    lateinit var aComponent:AppComponent;

    override fun onCreate() {
        super.onCreate()

        initApplication()
        initDevMode()
    }

    fun initApplication(){
        aComponent = DaggerAppComponent.builder()
                    .appNetwork(AppNetwork())
                    .build()

        aComponent.inject(this)
    }


    fun initDevMode(){
        if(!BuildConfig.DEBUG)
            return

        Timber.plant(Timber.DebugTree())
    }

    public fun getAppComponent():AppComponent{
        return aComponent
    }

}