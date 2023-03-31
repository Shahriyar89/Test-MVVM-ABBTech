package com.example.mvvmarchitectureabbtech.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
      @PrimaryKey(autoGenerate = true) val uid: Int,
      @ColumnInfo(name = "first_name") val name: String,
      @ColumnInfo(name="surname_name") val surname :String,
)
