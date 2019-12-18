package com.example.mukesh.view.ui.settings

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.activity.OnBackPressedCallback
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
import kotlinx.android.synthetic.main.fragmennt_setting.*

/**
 * Created by Mukesh Singh on 12/16/2019
 */
class SettingFragment :ToolbarBackButtonFragment() {
    private val TAG:String=SettingFragment::class.java.simpleName
    private lateinit var sharedViewModel: MainSharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate")
        setHasOptionsMenu(true)
        sharedViewModel= ViewModelProviders.of(requireActivity()).get(MainSharedViewModel::class.java)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG,"onCreateView")
        return inflater.inflate(R.layout.fragmennt_setting,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG,"onViewCreated")
        setUpToolbar(getString(R.string.settings))
        button.setOnClickListener {
            val des=SettingFragmentDirections.settingNext()
            findNavController().navigate(des)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        Log.d(TAG,"onCreateOptionsMenu")
        menu.clear()
        sharedViewModel.showBottomBar(false)
    }

    override fun onDestroyOptionsMenu() {
        Log.d(TAG,"onDestroyOptionsMenu")
        super.onDestroyOptionsMenu()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
               requireActivity().onBackPressed()
                return true
            }
        }
        return false
    }



    override fun onDestroy() {
        super.onDestroy()
        sharedViewModel.showBottomBar(true)
        Log.d(TAG,"onDestroy")
    }

    override fun onDestroyView() {
        sharedViewModel.showBottomBar(true)
        super.onDestroyView()
        Log.d(TAG,"onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG,"onDetach")
    }




}