package com.example.mvvmarchitectureabbtech.di

import android.content.Context
import androidx.room.Room
import com.example.room.ConnectRoomDatabase
import com.example.room.ConnectRoomDatabase.Companion.DATABASE_NAME
import com.example.mvvmarchitectureabbtech.network.Constants
import com.example.network.Services
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): ConnectRoomDatabase {
        return Room
            .databaseBuilder(appContext, ConnectRoomDatabase::class.java, DATABASE_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(db: ConnectRoomDatabase) = db.userDao()



//    @Provides
//    @Singleton
//    fun getUnsafeOkHttpClient(): OkHttpClient {
//        val interceptor = HeaderInterceptor()
//        val builder = OkHttpClient.Builder()
//        builder.addInterceptor(interceptor)
//            .connectTimeout(30, TimeUnit.SECONDS)
//            .readTimeout(30, TimeUnit.SECONDS)
//            .followRedirects(true)
//            .followSslRedirects(true)
//            .addInterceptor { chain ->
//                val newRequest = chain.request().newBuilder()
//                    .addHeader("Authorization", UUID.randomUUID().toString())
//                    .build()
//                chain.proceed(newRequest)
//            }
//    }
    @Provides
    @Singleton
    fun getRetrofitInstance(): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()



    @Provides
    fun getNewsServices(): Services {
        return getRetrofitInstance().create(Services::class.java)
    }



}