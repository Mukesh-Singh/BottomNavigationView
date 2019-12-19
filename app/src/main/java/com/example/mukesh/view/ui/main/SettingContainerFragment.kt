package com.example.mukesh.view.ui.main

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.mukesh.R
import com.example.mukesh.databinding.FragmentContainerDashboardBinding
import com.example.mukesh.databinding.FragmentContainerSettingBinding
import com.example.mukesh.navigation.KeepStateNavigator
import com.example.mukesh.view.ui.settings.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Created by Mukesh Singh on 12/10/2019
 */
class SettingContainerFragment : Fragment() {
    lateinit var binding:FragmentContainerSettingBinding
    private val TAG:String= SettingFragment::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding=FragmentContainerSettingBinding.inflate(inflater,container,false)
//        binding.incToolbar.toolbar.title = getString(R.string.settings)
//        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.incToolbar.toolbar)
        val host: NavHostFragment = childFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        // Set up Action Bar
        val navController = host.navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
                        val dest: String = try {
                resources.getResourceName(destination.id)
            } catch (e: Resources.NotFoundException) {
                Integer.toString(destination.id)
            }

            Log.e("NavigationActivity", "Navigated to $dest")
        }
        //NavigationUI.setupWithNavController(binding.incToolbar.toolbar, navController)

        requireActivity().onBackPressedDispatcher.addCallback(this,true){
           Log.e("SettingContainer", "Onbackpressed")
            navigateUp()
        }

        return binding.root
    }

    private fun navigateUp(){
        val nagi= findNavController().navigatorProvider.getNavigator<KeepStateNavigator>("keep_state_fragment")  as KeepStateNavigator
        if (nagi.currentDestinationClassName==nagi.lastDestinationClassName){
            requireActivity().findViewById<BottomNavigationView>(R.id.nav_view).setSelectedItemId(R.id.navigation_home)
            return
        }
        requireActivity().findViewById<BottomNavigationView>(R.id.nav_view).setSelectedItemId(getLastDestinationMenuId(nagi.lastDestinationClassName))
        //findNavController().navigate(nagi.lastDestination?.id!!)


    }

    private fun getLastDestinationMenuId(destinationClassName: String?):Int{
        if (destinationClassName==null)
            return R.id.navigation_home
        return when (destinationClassName){
            HomeContainerFragment::class.java.name->
                R.id.navigation_home
            DashboardContainerFragment::class.java.name->
                R.id.navigation_dashboard
            NotificationContainerFragment::class.java.name->
                R.id.navigation_notifications
            else->
                R.id.navigation_home
        }
    }

}