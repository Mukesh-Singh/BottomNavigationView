package com.example.mukesh.view.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Mukesh Singh on 12/17/2019
 */
class MainSharedViewModel(app:Application):AndroidViewModel(app) {
    private var showBottomBar:MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    private var dashboardTestSharedString:MutableLiveData<String> = MutableLiveData()


    fun getDashboardTestSharedString():MutableLiveData<String>{
        return dashboardTestSharedString
    }

    fun getShowBottomBarLiveData():MutableLiveData<Boolean> {
        return showBottomBar
    }

    fun showBottomBar(show:Boolean){
        this.showBottomBar.postValue(show)
    }

    fun updateDashboardString(testString:String){
        if (dashboardTestSharedString.value==null){
            dashboardTestSharedString.value=""
        }
        dashboardTestSharedString.postValue(dashboardTestSharedString.value + "\n"+testString)
    }

}