package com.githhub.coreSupport;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mohankumar on 2/8/19.
 */

@Module
public class AppContext {

    private Context context;

    public AppContext(Context context){
        this.context = context ;
    }

    @Provides
    public  Context getAppContext(){
        return context;
    }

}
