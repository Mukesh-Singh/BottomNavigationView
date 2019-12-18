package com.example.mukesh.view.ui.base

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mukesh.R

/**
 * Created by Mukesh Singh on 12/12/2019
 */
open class ToolbarBackButtonFragment :Fragment() {
    private var toolbar: Toolbar? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    fun setUpToolbar(){
        toolbar=view?.findViewById<Toolbar>(R.id.toolbar)
            (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
            (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(
                true
            )
        requireActivity().onBackPressedDispatcher.addCallback(this,true) {
            findNavController().navigateUp()
            Log.d("BackButtonFragment","Backpressed")
        }
    }

    fun setUpToolbar(title:String){
        toolbar=view?.findViewById<Toolbar>(R.id.toolbar)
        if (toolbar!=null)
            toolbar!!.title=title
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(
            true
        )
    }

    fun setUpToolbar(title:String,defaultHandlerBackCallBack: Boolean){
        toolbar=view?.findViewById<Toolbar>(R.id.toolbar)
        if (toolbar!=null)
            toolbar!!.title=title
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(
            true
        )
        if (defaultHandlerBackCallBack) {
            requireActivity().onBackPressedDispatcher.addCallback(this, true) {
                findNavController().navigateUp()
                Log.d("BackButtonFragment", "Backpressed")
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> findNavController().navigateUp()
        }
        return super.onOptionsItemSelected(item)
    }
}