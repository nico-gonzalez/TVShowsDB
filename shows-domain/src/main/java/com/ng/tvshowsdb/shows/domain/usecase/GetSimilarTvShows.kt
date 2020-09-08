package com.ng.tvshowsdb.shows.domain.usecase

import com.ng.tvshowsdb.core.domain.common.Result
import com.ng.tvshowsdb.core.domain.common.SchedulerProvider
import com.ng.tvshowsdb.core.domain.common.SingleUseCase
import com.ng.tvshowsdb.shows.domain.model.TvShows
import com.ng.tvshowsdb.shows.domain.repository.TvShowRepository
import com.ng.tvshowsdb.shows.domain.usecase.GetSimilarTvShows.Params
import io.reactivex.Single
import javax.inject.Inject

class GetSimilarTvShows @Inject constructor(
    schedulers: SchedulerProvider,
    private val tvShowRepository: TvShowRepository
) : SingleUseCase<Params, TvShows>(schedulers) {

    override fun execute(params: Params): Single<Result<TvShows>> =
        tvShowRepository.getSimilarTvShows(params.showId, params.page)
            .map { Result.success(it) }
            .onErrorReturn { Result.error(it) }

    data class Params(val showId: Long, val page: Int)
}