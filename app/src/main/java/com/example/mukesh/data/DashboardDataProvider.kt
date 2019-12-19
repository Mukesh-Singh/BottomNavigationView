package com.example.mukesh.data

import android.content.Context
import com.example.mukesh.R
import com.example.mukesh.model.Dashboard

/**
 * Created by Mukesh Singh on 12/13/2019
 */
class DashboardDataProvider {
    companion object {
        fun getDashBoardData(context: Context): ArrayList<Dashboard> {
            val list = ArrayList<Dashboard>()
            list.add(Dashboard(1, 10, context.getString(R.string.pending)))
            list.add(Dashboard(2, 50, context.getString(R.string.submitted)))
            list.add(Dashboard(3, 18, context.getString(R.string.accepted)))
            list.add(Dashboard(4, 22, context.getString(R.string.rejected)))
            return list
        }
    }
}