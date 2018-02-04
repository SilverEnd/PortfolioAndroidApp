package com.erikzuo.portfolioandroidapp.di;

import android.app.Application;


import com.erikzuo.portfolioandroidapp.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by YifanZuo on 3/2/18.
 */

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilderModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

    void inject(App app);

}
