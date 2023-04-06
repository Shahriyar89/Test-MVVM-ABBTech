package com.example.domein.usecases.room

import com.example.data.model.User
import com.example.data.repository.local.LocalRepository
import javax.inject.Inject

class AddUserUseCase @Inject constructor(var localRepo:LocalRepository){
    fun addUser(user:User){
        localRepo.addUser(user)
    }
}