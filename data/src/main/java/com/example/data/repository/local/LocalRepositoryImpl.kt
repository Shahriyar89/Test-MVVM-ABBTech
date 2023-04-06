package com.example.data.repository.local

import com.example.data.model.User
import com.example.room.UserDao
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(private var db: UserDao) : LocalRepository {

    override fun getAllUsers(): List<User> {
        return db.getAll()
    }

    override fun findUserByName(name: String): List<User> {
        return db.findByName(name)
    }

    override fun addUser(user: User) {
        db.insertAll(user)
    }

    override fun deleteUser(user: User) {
        db.delete(user)
    }

    override fun updateUser(user: User) {
        db.updateUser(user)
    }

    override fun findUserById(id: Int): User {
        return db.findById(id)
    }
}