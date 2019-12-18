package com.example.mukesh.view.ui.base

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.mukesh.R

/**
 * Created by Mukesh Singh on 12/12/2019
 */
open class ToolbarFragment : Fragment() {
    private var toolbar: Toolbar? = null
//    fun setUpToolbar() {
//        toolbar = view?.findViewById<Toolbar>(R.id.toolbar)
//        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
//    }

    fun setUpToolbar(title: String) {
        toolbar = view?.findViewById<Toolbar>(R.id.toolbar)
        if (toolbar != null) {
            toolbar!!.title = title

        }
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)

    }
}