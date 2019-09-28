package com.abrahamlay.kotlinboilerplate.localdb

import androidx.room.*
import com.abrahamlay.domain.entities.MovieModel

/**
 * Created by abraham.lay01 on 7/26/2019.
 */
@Dao
interface MovieDao {
    @Query("SELECT * FROM MovieModel")
    fun getAll(): List<MovieModel>

    @Query("SELECT * FROM MovieModel WHERE id = :id LIMIT 1")
    fun getMovie(id: Int): MovieModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertAll(listData: List<MovieModel>)

    @Query("DELETE FROM MovieModel")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(data: MovieModel)

    @Delete
    fun delete(data: MovieModel)
}