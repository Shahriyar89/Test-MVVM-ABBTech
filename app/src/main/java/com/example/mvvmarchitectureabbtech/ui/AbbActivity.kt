package com.example.mvvmarchitectureabbtech.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.mvvmarchitectureabbtech.R
import com.example.mvvmarchitectureabbtech.databinding.ActivityAbbBinding
import com.example.mvvmarchitectureabbtech.ui.util.LoggerAnalytic
import com.example.mvvmarchitectureabbtech.ui.util.LoggerAnalyticImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AbbActivity: AppCompatActivity(), LoggerAnalytic by LoggerAnalyticImpl() {
    private lateinit var binding: ActivityAbbBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAbbBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
        val navController = navHostFragment.navController


        registerLifeCycle(this)


    }

}