package com.example.mvvmarchitectureabbtech.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mvvmarchitectureabbtech.data.model.Customer
import com.example.mvvmarchitectureabbtech.data.model.User


@Database(entities = [User::class] , version = 1)
abstract class ConnectRoomDatabase:RoomDatabase() {
    abstract fun userDao(): UserDao
    companion object {
//        private var INSTANCE: ConnectRoomDatabase? = null
//        val migration1_2: Migration = object : Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL("Alter Table customers Add Column phone Text Default ''")
//            }
//        }
//
//        fun getInstance(context: Context): ConnectRoomDatabase? {
//            if (INSTANCE == null) {
//                synchronized(ConnectRoomDatabase::class) {
//                    INSTANCE = Room.databaseBuilder(
//                        context.applicationContext,
//                        ConnectRoomDatabase::class.java,
//                        DATABASE_NAME
//                    ).allowMainThreadQueries()
////                        .addMigrations(migration1_2)
//                        .build()
//                }
//            }
//            return INSTANCE
//        }
//
//        fun destroyInstance() {
//            INSTANCE = null
//        }

        const val DATABASE_NAME="UserInfo.db"
    }
}