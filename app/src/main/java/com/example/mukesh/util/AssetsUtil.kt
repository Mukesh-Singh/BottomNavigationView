package com.example.mukesh.util

import android.content.Context
import android.util.Log
import java.io.IOException

/**
 * Created by Mukesh Singh on 12/11/2019
 */
class AssetsUtil {
    companion object{
        fun getAssetJsonData(context: Context?): String? {
            if (context==null)
                return ""
            val json: String
            try {
                val inputStream = context.getAssets().open("sample_data.json")
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.use { it.read(buffer) }
                json = String(buffer)
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return null
            }
            // print the data
            Log.i("data", json)
            return json
        }
    }

}