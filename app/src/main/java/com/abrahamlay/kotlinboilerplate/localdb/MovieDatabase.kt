package com.abrahamlay.kotlinboilerplate.localdb

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.abrahamlay.domain.entities.MovieModel
import java.util.*

/**
 * Created by abraham.lay01 on 7/26/2019.
 */

@Database(entities = [MovieModel::class], version = 3, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {

        private var movieDatabase: MovieDatabase? = null

        private fun getDatabase(context: Context): MovieDatabase {

            if (movieDatabase == null) {
                synchronized(MovieDatabase::class) {
                    movieDatabase = Room.databaseBuilder<MovieDatabase>(
                        context.applicationContext,
                        MovieDatabase::class.java,
                        "MovieDb-v1"
                    )
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return movieDatabase!!
        }


        fun upsertData(context: Context, movieModel: MovieModel) {
            getDatabase(context).movieDao().upsert(movieModel)
        }

        fun upsertAllData(context: Context, movieModels: List<MovieModel>) {
            getDatabase(context).movieDao().upsertAll(movieModels)
        }

        fun deleteData(context: Context, movieModel: MovieModel) {
            getDatabase(context).movieDao().delete(movieModel)
        }

        fun deleteAll(context: Context) {
            getDatabase(context).movieDao().deleteAll()
        }

        fun getAll(context: Context): List<MovieModel> {
            return getDatabase(context).movieDao().getAll()
        }

        fun getMovie(context: Context, id: Int): MovieModel? {
            return getDatabase(context).movieDao().getMovie(id)
        }

//        fun movieIsExist(context: Context, id: Int): Boolean {
//            return getMovie(context, id) != null
//        }

        fun convertToModel(offerModelList: List<MovieModel>): List<MovieModel> {
            val offerModelDataList = ArrayList<MovieModel>()
            for (offerModel in offerModelList) {
                offerModelDataList.add(
                    convertToModel(
                        offerModel
                    )
                )
            }
            return offerModelDataList
        }

        private fun convertToModel(offerModel: MovieModel): MovieModel {
            return MovieModel(
                offerModel.id,
                offerModel.id,
                offerModel.video,
                offerModel.voteAverage,
                offerModel.title,
                offerModel.popularity,
                offerModel.posterPath,
                offerModel.originalLanguage,
                offerModel.originalTitle,
//                offerModel.genreIds,
                offerModel.backdropPath,
                offerModel.adult,
                offerModel.overview,
                offerModel.releaseDate
            )
        }
    }
}