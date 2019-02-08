package com.githhub.coreSupport;

import com.githhub.base.MainApp;
import com.githhub.login.LoginPresenterImpl;
import com.githhub.network.HttpRequest;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by mohankumar on 2/8/19.
 */

@Component(modules = {AppContext.class,AppNetwork.class})
public interface AppComponent {

    void inject(MainApp mApp);
    void inject(LoginPresenterImpl lImpl);

    Retrofit getRetrofit();

    HttpRequest.HttpService getHttpService();

}
