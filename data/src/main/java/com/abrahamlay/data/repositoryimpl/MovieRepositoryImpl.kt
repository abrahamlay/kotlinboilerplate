package com.abrahamlay.data.repositoryimpl

import com.abrahamlay.data.apis.MovieAPI
import com.abrahamlay.domain.entities.MovieModel
import com.abrahamlay.domain.repositories.MovieRepository
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by abraham.lay01 on 7/25/2019.
 */

@Singleton
class MovieRepositoryImpl @Inject constructor(val api: MovieAPI): MovieRepository {
    override fun getMovies(apiKey: String): Flowable<List<MovieModel>> =
        api.getMovies(apiKey).map {
            it.results.map { movie ->
                MovieModel(
                    movie.voteCount,
                    movie.id,
                    movie.video,
                    movie.voteAverage,
                    movie.originalTitle,
                    movie.popularity,
                    movie.posterPath,
                    movie.originalLanguage,
                    movie.originalTitle,
                    movie.genreIds,
                    movie.backdropPath,
                    movie.adult,
                    movie.overview,
                    movie.releaseDate

                )
            }
        }
}