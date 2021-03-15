package com.ng.tvshowsdb.shows.data.datasource.remote

import com.ng.tvshowsdb.shows.data.datasource.remote.model.ApiTvShow
import com.ng.tvshowsdb.shows.data.datasource.remote.model.ApiTvShows
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ShowsService {

    @GET("tv/popular")
    fun getMostPopularTvShows(@Query("page") page: Int): Single<ApiTvShows>

    @GET("tv/{tv_id}/similar")
    fun getSimilarTvShows(
        @Path("tv_id") id: Long,
        @Query("page") page: Int = 1,
    ): Single<ApiTvShows>

    @GET("tv/top_rated")
    fun getTopRatedTvShows(@Query("page") page: Int): Single<ApiTvShows>

    @GET("tv/latest")
    fun getLatest(): Single<ApiTvShow>
}
