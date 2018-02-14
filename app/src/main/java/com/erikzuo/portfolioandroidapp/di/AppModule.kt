package com.erikzuo.portfolioandroidapp.di

import android.app.Application
import android.content.Context

import com.erikzuo.portfolioandroidapp.data.AppDataManager
import com.erikzuo.portfolioandroidapp.data.DataManager
import com.erikzuo.portfolioandroidapp.data.remote.GithubService
import com.erikzuo.portfolioandroidapp.utils.rx.AppSchedulerProvider
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider
import com.google.firebase.database.FirebaseDatabase

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by YifanZuo on 3/2/18.
 */


@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    fun provideGithubService(): GithubService {
        return Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(GithubService::class.java!!)
    }

    @Provides
    @Singleton
    fun provideFirebaseDatabase(): FirebaseDatabase {
        return FirebaseDatabase.getInstance()
    }
}
