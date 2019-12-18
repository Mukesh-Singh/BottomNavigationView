package com.example.mukesh.view.ui.settings

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavDestination
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.mukesh.R
import com.example.mukesh.navigation.KeepStateNavigator
import com.example.mukesh.view.ui.base.ToolbarBackButtonFragment
import com.example.mukesh.view.ui.main.MainSharedViewModel

/**
 * Created by Mukesh Singh on 12/16/2019
 */
class SettingFragment2 :ToolbarBackButtonFragment() {
    private val TAG:String=SettingFragment2::class.java.simpleName
   private lateinit var sharedViewModel: MainSharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG,"onCreate")
        setHasOptionsMenu(true)
        sharedViewModel= ViewModelProviders.of(requireActivity()).get(MainSharedViewModel::class.java)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e(TAG,"onCreateView")
        return inflater.inflate(R.layout.fragment_setting_2,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(TAG,"onViewCreated")
        setUpToolbar("Setting-Next")
        requireActivity().onBackPressedDispatcher.addCallback(this,true){
            navigateUp()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        Log.e(TAG,"onCreateOptionsMenu")
        menu.clear()
        sharedViewModel.showBottomBar(false)
    }

    override fun onDestroyOptionsMenu() {
        Log.e(TAG,"onDestroyOptionsMenu")
        super.onDestroyOptionsMenu()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                navigateUp()
                return true
            }
        }
        return false
    }

    private fun navigateUp(){
        findNavController().navigateUp()


    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG,"onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(TAG,"onDestroyView")
        sharedViewModel.showBottomBar(true)
    }

    override fun onDetach() {
        super.onDetach()
        Log.e(TAG,"onDetach")
    }




}