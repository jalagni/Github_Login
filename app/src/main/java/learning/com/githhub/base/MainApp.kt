package learning.com.githhub.base

import android.app.Application
import learning.com.githhub.BuildConfig
import timber.log.Timber

/**
 * Created by mohankumar on 9/7/18.
 */
class MainApp: Application() {


    override fun onCreate() {
        super.onCreate()
        initDevMode()
    }


    fun initDevMode(){
        if(!BuildConfig.DEBUG)
            return

        Timber.plant(Timber.DebugTree())
    }

}