package com.example.mukesh.view.ui.dashboard

import android.os.Bundle
import android.view.*
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.mukesh.R
import com.example.mukesh.databinding.FragmentDashboardItemDetilsBinding
import com.example.mukesh.view.ui.main.MainSharedViewModel

/**
 * Created by Mukesh Singh on 12/13/2019
 */
class DashboardItemDetails : Fragment() {
    private lateinit var binding: FragmentDashboardItemDetilsBinding
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
        binding = FragmentDashboardItemDetilsBinding.inflate(inflater, container, false)
        requireActivity().onBackPressedDispatcher.addCallback(this,true){
            findNavController().navigateUp()
        }

        binding.moreDetails.setOnClickListener(){
            findNavController().navigate(R.id.action_dashboardItemDetails_to_dashboardMoreDetails)
        }
        mainSharedViewModel.getDashboardTestSharedString().observe(this, Observer { sring ->
            binding.textView.text=sring
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.dashboard_details_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==R.id.action_call){
            mainSharedViewModel.updateDashboardString("Clicked - Call")
        }
        return super.onOptionsItemSelected(item)
    }
}