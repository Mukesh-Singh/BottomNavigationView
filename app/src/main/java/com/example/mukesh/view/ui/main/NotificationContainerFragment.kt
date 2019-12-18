package com.example.mukesh.view.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mukesh.R
import com.example.mukesh.databinding.FragmentContainerNotificationBinding

/**
 * Created by Mukesh Singh on 12/10/2019
 */
class NotificationContainerFragment : Fragment() {
    lateinit var binding:FragmentContainerNotificationBinding

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding=FragmentContainerNotificationBinding.inflate(inflater,container,false)
        binding.incToolbar.toolbar.title = getString(R.string.title_notifications)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.incToolbar.toolbar)
//        val host: NavHostFragment = childFragmentManager
//            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//
//        // Set up Action Bar
//        val navController = host.navController
//        NavigationUI.setupWithNavController(binding.incToolbar.toolbar, navController)

        return binding.root
    }
}