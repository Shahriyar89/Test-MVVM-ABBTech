package com.example.mvvmarchitectureabbtech.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmarchitectureabbtech.data.model.NewsResponse
import com.example.mvvmarchitectureabbtech.data.model.User
import com.example.mvvmarchitectureabbtech.data.repository.local.LocalRepository
import com.example.mvvmarchitectureabbtech.data.repository.remote.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private var repository: LocalRepository) : ViewModel() {

    val newRepository = NewsRepository()

    val liveNewsData: MutableLiveData<NewsResponse> = MutableLiveData()

   // val scope = CoroutineScope(Dispatchers.IO)

    init {

    }

    //remote data
     suspend fun getNews() {
//        scope.launch {
            val response = newRepository.getNews()
            if (response.isSuccessful) {
                liveNewsData.postValue(response.body())
            }
//        }

    }


    //Local data
    var name: String? = ""
    var surName: String = "https://cdn-icons-png.flaticon.com/512/3135/3135715.png"


    fun addUserToDB(user: User) {
        repository.addUser(user)
    }

    fun getAllUserFromDB(): List<User> {
        Log.d("hereee", repository.getAllUsers().size.toString())
        return repository.getAllUsers()

    }

    fun getUserById() = repository.findUserById(2)


}