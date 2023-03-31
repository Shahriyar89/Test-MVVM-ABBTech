package com.example.mvvmarchitectureabbtech.data.model

import androidx.room.Entity

@Entity(tableName = "customers")
data class Customer (
    val name:String
    )