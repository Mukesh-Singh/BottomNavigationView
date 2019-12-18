package com.example.mukesh.util

import android.content.Context
import androidx.annotation.NonNull
import com.example.mukesh.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


/**
 * Created by Mukesh Singh on 12/11/2019
 */
class Util {
    companion object{
        fun getUserList(@NonNull context: Context):ArrayList<User>{
            //val data: String? =AssetsUtil.getAssetJsonData(context)
            var jsonString=AssetsUtil.getAssetJsonData(context)
            val token: TypeToken<List<User>> =
                object : TypeToken<List<User>>() {}
            val users: ArrayList<User> = Gson().fromJson(jsonString, token.type)
            return users
        }
    }
}