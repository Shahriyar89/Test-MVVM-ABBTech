package com.example.mvvmarchitectureabbtech.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.NewsResponse
import com.example.data.model.User
import com.example.data.repository.local.LocalRepository
import com.example.data.repository.remote.NewsRepository
import com.example.domein.usecases.news.NewsRepositoryUseCase
import com.example.domein.usecases.room.AddUserUseCase
import com.example.domein.usecases.room.FindUserByIdUseCase
import com.example.domein.usecases.room.GetAllUsersUseCase
import com.example.mvvmarchitectureabbtech.network.NewsResponseUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    var newRepository: NewsRepository,
    val newsRepositoryUseCase: NewsRepositoryUseCase,
    var addUserUseCase: AddUserUseCase,
    var getAllUsersUseCase: GetAllUsersUseCase,
    var findUserByIdUseCase: FindUserByIdUseCase
) : ViewModel() {

    val liveNewsData: MutableLiveData<NewsResponse> = MutableLiveData()

    private val _uiState =
        MutableStateFlow<NewsResponseUiState>(NewsResponseUiState.Loading("loading"))

    // The UI collects from this StateFlow to get its state updates
    val uiState: StateFlow<NewsResponseUiState> = _uiState

    val scope = CoroutineScope(Dispatchers.IO)

    init {
        newsRepositoryUseCase.getNews()
    }

    //remote data livedata
    suspend fun getNews() {
//        scope.launch {
        val response = newRepository.getNews()
        if (response.isSuccessful) {
            liveNewsData.postValue(response.body())
        }
//        }


    }


    //collect flow
    fun getBreakNewsWithFlow() {
        viewModelScope.launch(Dispatchers.IO) {
            newRepository.getBreakNews().collect { data ->

                if (data != null) {
                    _uiState.value = NewsResponseUiState.Success(data)
                } else
                    _uiState.value = NewsResponseUiState.Error(Error())
            }
        }
    }


    //Local data
    var name: String? = ""
    var surName: String = "https://cdn-icons-png.flaticon.com/512/3135/3135715.png"


    fun addUserToDB(user: User) {
        addUserUseCase.addUser(user)
    }

    fun getAllUserFromDB(): List<User> {
        Log.d("hereee", getAllUsersUseCase.getAllUsers().size.toString())
        return getAllUsersUseCase.getAllUsers()

    }

    fun getUserById() = findUserByIdUseCase.getUserById(2)


}