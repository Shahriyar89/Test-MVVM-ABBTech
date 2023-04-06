package com.example.domein.usecases.room

import com.example.data.repository.local.LocalRepository
import javax.inject.Inject

class FindUserByIdUseCase @Inject constructor(private val localRepo: LocalRepository) {
    fun getUserById(id: Int) = localRepo.findUserById(id)
}