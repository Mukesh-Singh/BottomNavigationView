package com.example.mukesh.data

import com.example.mukesh.model.Dashboard

/**
 * Created by Mukesh Singh on 12/13/2019
 */
class DashboardDataProvider {
    companion object {
        fun getDashBoardData(): ArrayList<Dashboard> {
            val list = ArrayList<Dashboard>()
            list.add(Dashboard(1, 10, "Pending"))
            list.add(Dashboard(2, 50, "Submitted"))
            list.add(Dashboard(3, 18, "Accepted"))
            list.add(Dashboard(4, 22, "Rejected"))
            return list
        }
    }
}