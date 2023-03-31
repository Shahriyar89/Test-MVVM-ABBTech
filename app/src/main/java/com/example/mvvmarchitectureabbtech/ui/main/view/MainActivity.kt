package com.example.mvvmarchitectureabbtech.ui.main.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmarchitectureabbtech.data.model.User
import com.example.mvvmarchitectureabbtech.databinding.ActivityMainBinding
import com.example.mvvmarchitectureabbtech.ui.main.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: UserViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //call view model methods
//        viewModel.repository = LocalRepository(this)

        viewModel.addUserToDB(User(1, "John", "Jackson"))
        viewModel.addUserToDB(User(2, "Mark", "Twen"))
        viewModel.addUserToDB(User(3, "Marks", "Twssen"))
        val list = viewModel.getAllUserFromDB()
        Toast.makeText(this, "$list", Toast.LENGTH_SHORT).show()
    }


}