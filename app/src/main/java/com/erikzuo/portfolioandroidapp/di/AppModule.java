package com.erikzuo.portfolioandroidapp.di;

import android.app.Application;
import android.content.Context;


import com.erikzuo.portfolioandroidapp.data.AppDataManager;
import com.erikzuo.portfolioandroidapp.data.DataManager;
import com.erikzuo.portfolioandroidapp.utils.rx.AppSchedulerProvider;
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by YifanZuo on 3/2/18.
 */


@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }
//
//    @Provides
//    @DatabaseInfo
//    String provideDatabaseName() {
//        return AppConstants.DB_NAME;
//    }
//
//    @Provides
//    @ApiInfo
//    String provideApiKey() {
//        return BuildConfig.API_KEY;
//    }
//
//    @Provides
//    @PreferenceInfo
//    String providePreferenceName() {
//        return AppConstants.PREF_NAME;
//    }
//
    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }
//
//    @Provides
//    @Singleton
//    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
//        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
//                .build();
//    }
//
//    @Provides
//    @Singleton
//    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
//        return appDbHelper;
//    }
//
//    @Provides
//    @Singleton
//    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
//        return appPreferencesHelper;
//    }
//
//    @Provides
//    @Singleton
//    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
//        return appApiHelper;
//    }
//
//    @Provides
//    @Singleton
//    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
//                                                           PreferencesHelper preferencesHelper) {
//        return new ApiHeader.ProtectedApiHeader(
//                apiKey,
//                preferencesHelper.getCurrentUserId(),
//                preferencesHelper.getAccessToken());
//    }
//
//    @Provides
//    @Singleton
//    CalligraphyConfig provideCalligraphyDefaultConfig() {
//        return new CalligraphyConfig.Builder()
//                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
//                .setFontAttrId(R.attr.fontPath)
//                .build();
//    }
}
