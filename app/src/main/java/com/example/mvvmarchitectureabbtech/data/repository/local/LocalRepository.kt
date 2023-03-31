package com.example.mvvmarchitectureabbtech.data.repository.local

import android.content.Context
import com.example.mvvmarchitectureabbtech.data.model.User
import com.example.mvvmarchitectureabbtech.local.ConnectRoomDatabase
import com.example.mvvmarchitectureabbtech.local.UserDao
import javax.inject.Inject

class LocalRepository @Inject constructor(private var db: UserDao) {

    fun getAllUsers(): List<User> {
        return db.getAll()
    }

    fun findUserByName(name: String): List<User> {
        return db.findByName(name)
    }

    fun addUser(user: User) {
        db.insertAll(user)
    }

    fun deleteUser(user: User) {
        db.delete(user)
    }

    fun updateUser(user: User) {
        db.updateUser(user)
    }

    fun findUserById(id: Int): User {
        return db.findById(id)
    }
}