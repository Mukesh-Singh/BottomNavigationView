package com.example.mukesh.view.ui.dashboard.adapter

import android.view.View
import com.example.mukesh.databinding.RowDashboardBinding
import com.example.mukesh.databinding.RowUserBinding
import com.example.mukesh.model.Dashboard
import com.example.mukesh.model.User

/**
 * Created by Mukesh Singh on 12/11/2019
 */
interface DashboardItemClickListener {
    fun onItemClicked(binding: RowDashboardBinding, dashboard:Dashboard)
}