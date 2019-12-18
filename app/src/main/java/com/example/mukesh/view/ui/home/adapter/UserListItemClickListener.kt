package com.example.mukesh.view.ui.home.adapter

import android.view.View
import com.example.mukesh.databinding.RowUserBinding
import com.example.mukesh.model.User

/**
 * Created by Mukesh Singh on 12/11/2019
 */
interface UserListItemClickListener {
    fun onItemClicked(binding: RowUserBinding, user:User)
}