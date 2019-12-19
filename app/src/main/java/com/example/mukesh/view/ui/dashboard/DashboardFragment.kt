package com.example.mukesh.view.ui.dashboard

import android.os.Bundle
import android.view.*
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mukesh.R
import com.example.mukesh.data.DashboardDataProvider
import com.example.mukesh.databinding.FragmentDashboardBinding
import com.example.mukesh.databinding.RowDashboardBinding
import com.example.mukesh.databinding.RowUserBinding
import com.example.mukesh.model.Dashboard
import com.example.mukesh.model.User
import com.example.mukesh.util.Util
import com.example.mukesh.view.ui.dashboard.adapter.DashboardAdapter
import com.example.mukesh.view.ui.dashboard.adapter.DashboardItemClickListener
import com.example.mukesh.view.ui.home.adapter.UserAdapter
import com.example.mukesh.view.ui.home.adapter.UserListItemClickListener
import com.example.mukesh.view.ui.main.MainSharedViewModel
import java.util.ArrayList

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var binding:FragmentDashboardBinding
    private lateinit var mainSharedViewModel:MainSharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        mainSharedViewModel=ViewModelProviders.of(requireActivity()).get(MainSharedViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (::binding.isInitialized)
            return binding.root

        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        binding=FragmentDashboardBinding.inflate(inflater,container,false)
        val dashboardAdapter = DashboardAdapter()
        dashboardAdapter.clickListener = object : DashboardItemClickListener {
            override fun onItemClicked(binding: RowDashboardBinding, dashboard: Dashboard) {
                navigateToDetails(binding, dashboard)
            }
        }
        val layoutManager = GridLayoutManager(context, 2)
        binding.list.layoutManager = layoutManager
        binding.list.adapter = dashboardAdapter
        dashboardAdapter.updateList(DashboardDataProvider.getDashBoardData(requireContext()))
        mainSharedViewModel.getDashboardTestSharedString().observe(this, Observer { sring ->
            binding.textView.text=sring
        })

        return binding.root
    }

    private fun navigateToDetails(binding: RowDashboardBinding, dashboard: Dashboard) {
        var direction=DashboardFragmentDirections.actionDashboardToDashboardItemDetails(dashboard.title)
        findNavController().navigate(direction)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.dashboard_menu,menu)
    }
}