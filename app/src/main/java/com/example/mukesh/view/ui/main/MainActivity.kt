package com.example.mukesh.view.ui.main

import android.content.res.Resources
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.plusAssign
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.example.mukesh.R
import com.example.mukesh.databinding.ActivityMainBinding
import com.example.mukesh.navigation.KeepStateNavigator

class MainActivity : AppCompatActivity() {
    private val TAG:String=MainActivity::class.java.simpleName
    private val ENTER_DURATION: Long=100
    private val EXIT_DURATION: Long=200
    private lateinit var binding: ActivityMainBinding
    //lateinit var simpleNavController: NavController
    private lateinit var sharedViewModel: MainSharedViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        sharedViewModel=ViewModelProviders.of(this).get(MainSharedViewModel::class.java)
        val navController = findNavController(R.id.nav_host_fragment)
        //simpleNavController=findNavController(R.id.nav_host_fragment)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home,
//                R.id.navigation_dashboard,
//                R.id.navigation_notifications
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)!! as NavHostFragment

        // setup custom navigator
        val navigator = KeepStateNavigator(this, navHostFragment.childFragmentManager, R.id.nav_host_fragment)
        navController.navigatorProvider += navigator

        // set navigation graph
        navController.setGraph(R.navigation.main_navigation)

//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            val dest: String = try {
//                resources.getResourceName(destination.id)
//            } catch (e: Resources.NotFoundException) {
//                Integer.toString(destination.id)
//            }
//
//            Toast.makeText(this@MainActivity, "Navigated to $dest",
//                Toast.LENGTH_SHORT).show()
//            Log.d("NavigationActivity", "Navigated to $dest")
//        }

        binding.navView.setupWithNavController(navController)

//        onBackPressedDispatcher.addCallback(this,true) {
//            finish()
//        }

        sharedViewModel.getShowBottomBarLiveData().observe(this, Observer { show->
            if (show!=null){
                if (show)
                    showBottomNavigation()
                else
                    hideBottomNavigation()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.universal_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==R.id.settings_dest){
            openSettingFragmentFromMenu()
            return true
        }
        else{
            return super.onOptionsItemSelected(item)
        }
    }

    private fun openSettingFragmentFromMenu(){
        Handler().postDelayed({
            findNavController(R.id.nav_host_fragment).navigate(R.id.settings_dest)
        },400)
    }

    private fun hideBottomNavigation() {
        // bottom_navigation is BottomNavigationView
        with(binding.navView) {
            if (visibility == View.VISIBLE && alpha == 1f) {
                animate()
                    .alpha(0f)
                    .translationY(binding.navView.measuredHeight.toFloat())
                    .withEndAction { visibility = View.GONE }
                    .duration = EXIT_DURATION
            }
            else{
                Log.e(TAG,"Possible Bug")
                binding.navView.visibility=View.GONE
            }
        }
    }

    private fun showBottomNavigation() {
        // bottom_navigation is BottomNavigationView
        with(binding.navView) {
            visibility = View.VISIBLE
            animate()
                .alpha(1f)
                .translationY(0f)
                .duration = ENTER_DURATION
        }
    }
}
