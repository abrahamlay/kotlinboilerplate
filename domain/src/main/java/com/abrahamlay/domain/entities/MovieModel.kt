package com.abrahamlay.domain.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverter
import java.io.Serializable


/**
 * Created by abraham.lay01 on 7/25/2019.
 */
@Entity
data class MovieModel(
    var voteCount: Int,
    @PrimaryKey
    var id: Int,
    var video: Boolean,
    var voteAverage: Double,
    var title: String?,
    var popularity: Double,
    var posterPath: String?,
    var originalLanguage: String?,
    var originalTitle: String?,
//    @TypeConverters(Converter::class)
//    var genreIds: List<Int>,
    var backdropPath: String?,
    var adult: Boolean,
    var overview: String?,
    var releaseDate: String?
) : Serializable {

    inner class Converter {

        @TypeConverter
        fun stringToList(data: String?): List<Int> {
            if (data == null) {
                return listOf()
            }

            return data.split(",").map { it.toInt() }
        }

        @TypeConverter
        fun listToString(list: List<Int>): String {
            return list.map { it }.joinToString(separator = ",")
        }
    }
}