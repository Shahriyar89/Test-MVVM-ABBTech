package com.example.data.repository.local

import com.example.data.model.User

interface LocalRepository {
    fun getAllUsers(): List<User>
    fun findUserByName(name: String): List<User>
    fun addUser(user: User)
    fun deleteUser(user: User)
    fun updateUser(user: User)
    fun findUserById(id: Int): User
}