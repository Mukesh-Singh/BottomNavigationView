package com.example.mukesh

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

/**
 * Created by Mukesh Singh on 12/18/2019
 */
class App:Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}