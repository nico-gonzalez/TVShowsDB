package com.ng.tvshowsdb.shows.data.di

import com.ng.tvshowsdb.core.data.di.NetworkModule
import com.ng.tvshowsdb.shows.data.datasource.remote.ShowsService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
internal class ShowsNetworkModule {

    @Singleton
    @Provides
    fun provideShowsService(retrofit: Retrofit): ShowsService =
        retrofit.create(ShowsService::class.java)
}
