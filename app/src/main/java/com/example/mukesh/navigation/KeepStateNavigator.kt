package com.example.mukesh.navigation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigator
import com.example.mukesh.R

@Navigator.Name("keep_state_fragment") // `keep_state_fragment` is used in navigation xml
class KeepStateNavigator(
    private val context: Context,
    private val manager: FragmentManager, // Should pass childFragmentManager.
    private val containerId: Int
) : FragmentNavigator(context, manager, containerId) {
    //var lastDestination:Destination?=null
    //var currentDestination:Destination?=null
    var lastDestinationClassName:String?=null
    var currentDestinationClassName:String?=null
    override fun navigate(
        destination: Destination,
        args: Bundle?,
        navOptions: NavOptions?,
        navigatorExtras: Navigator.Extras?
    ): NavDestination? {
//        if (lastDestination!=null){
//            lastDestination=currentDestination
//        }
//        else{
//            lastDestination=destination
//        }
//        currentDestination=destination

        if (lastDestinationClassName!=null){
            lastDestinationClassName=currentDestinationClassName
        }
        else{
            lastDestinationClassName=destination.className
        }
        currentDestinationClassName=destination.className

        val tag = destination.id.toString()
        val transaction = manager.beginTransaction()
        var initialNavigate = false
        val currentFragment = manager.primaryNavigationFragment
        if (currentFragment != null) {
            transaction.detach(currentFragment)
        } else {
            initialNavigate = true
        }

        var fragment = manager.findFragmentByTag(tag)
        if (fragment == null) {
            val className = destination.className
            fragment = manager.fragmentFactory.instantiate(context.classLoader, className)
            transaction.add(containerId, fragment, tag)
        } else {
            transaction.attach(fragment)
        }

        transaction.setPrimaryNavigationFragment(fragment)
        transaction.setReorderingAllowed(true)
        transaction.commitNow()

        return if (initialNavigate) {
            destination
        } else {
            null
        }
    }

    override fun onSaveState(): Bundle? {
        val bundle=Bundle()
        bundle.putString("last_destination",lastDestinationClassName)
        bundle.putString("current_destination",currentDestinationClassName)
        return bundle
    }

    override fun onRestoreState(savedState: Bundle?) {
        if (savedState!=null){
            lastDestinationClassName=savedState.getString("last_destination")
            currentDestinationClassName=savedState.getString("current_destination")
        }
        super.onRestoreState(savedState)
    }
}
