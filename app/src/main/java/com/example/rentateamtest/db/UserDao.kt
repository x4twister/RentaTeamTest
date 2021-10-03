package com.example.rentateamtest.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.rentateamtest.pojo.User
import io.reactivex.Flowable

@Dao
interface UserDao {

    @Query("SELECT * FROM user LIMIT :count OFFSET :pos")
    fun load(count: Long, pos: Long): Flowable<List<User>>

    @Query("SELECT * FROM user WHERE id = :id")
    fun loadById(id: Long): Flowable<User>

    @Insert(onConflict=REPLACE)
    fun save(user: User)
}
