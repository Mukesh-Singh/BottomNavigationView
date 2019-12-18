package com.example.mukesh.view.ui.dashboard

import android.os.Bundle
import android.view.*
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.mukesh.R
import com.example.mukesh.view.ui.main.MainSharedViewModel

/**
 * Created by Mukesh Singh on 12/13/2019
 */
class DashboardMoreDetails:Fragment() {
    private lateinit var mainSharedViewModel: MainSharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        mainSharedViewModel= ViewModelProviders.of(requireActivity()).get(MainSharedViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_dashboard_more_details,container,false)
        requireActivity().onBackPressedDispatcher.addCallback(this,true){
            findNavController().navigateUp()
        }

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.dashboard_more_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==R.id.action_share){
            mainSharedViewModel.updateDashboardString("Clicked - Share")
        }
        return super.onOptionsItemSelected(item)
    }
}