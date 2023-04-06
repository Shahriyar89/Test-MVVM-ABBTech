package com.example.domein.usecases.room

import com.example.data.repository.local.LocalRepository
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(var localRepo:LocalRepository) {
    fun getAllUsers() =localRepo.getAllUsers()
}