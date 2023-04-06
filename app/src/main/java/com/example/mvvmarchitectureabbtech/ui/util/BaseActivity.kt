package com.example.mvvmarchitectureabbtech.ui.util

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class BaseActivity :AppCompatActivity(){
}

interface LoggerAnalytic{
    fun registerLifeCycle(owner:LifecycleOwner)
}


class LoggerAnalyticImpl() :LoggerAnalytic,LifecycleEventObserver {
    override fun registerLifeCycle(owner: LifecycleOwner) {
        owner.lifecycle.addObserver(this)
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when(event){
            Lifecycle.Event.ON_START-> Log.d("LifeCycle","OnStart")
            Lifecycle.Event.ON_PAUSE-> Log.d("LifeCycle","OnPause")
            else-> Unit
        }
    }
}