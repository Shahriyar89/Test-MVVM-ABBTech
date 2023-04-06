package com.example.data.model

import androidx.room.Entity

@Entity(tableName = "customers")
data class Customer (
    val name:String
    )