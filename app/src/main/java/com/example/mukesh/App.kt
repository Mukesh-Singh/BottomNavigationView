package com.example.mukesh

import android.app.Application
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate

/**
 * Created by Mukesh Singh on 12/18/2019
 */
class App:Application() {

    override fun onCreate() {
        super.onCreate()
        val mode=AppCompatDelegate.getDefaultNightMode()
        Log.i("App","Current mode-: $mode")
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

    }
}