package com.example.mvvmarchitectureabbtech.local

import androidx.room.*
import com.example.mvvmarchitectureabbtech.data.model.User


@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query(
        "SELECT * FROM user WHERE first_name LIKE :first"
    )
    fun findByName(first: String): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)

    @Update
    fun updateUser(user: User)

    @Query("SELECT * FROM user WHERE uid=:id")
    fun findById(id:Int):User
}