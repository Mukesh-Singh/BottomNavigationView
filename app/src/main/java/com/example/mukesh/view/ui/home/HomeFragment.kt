package com.example.mukesh.view.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mukesh.R
import com.example.mukesh.databinding.FragmentHomeBinding
import com.example.mukesh.databinding.RowUserBinding
import com.example.mukesh.model.User
import com.example.mukesh.util.Util
import com.example.mukesh.view.ui.ViewUtil
import com.example.mukesh.view.ui.base.ToolbarFragment
import com.example.mukesh.view.ui.home.adapter.UserAdapter
import com.example.mukesh.view.ui.home.adapter.UserListItemClickListener
import com.example.mukesh.view.ui.home.model.SharedTransitionArg
import java.util.*

class HomeFragment : ToolbarFragment() {
    private val TAG: String = HomeFragment::class.java.simpleName
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e(TAG, "onCreateView")
        if (::binding.isInitialized)
            return binding.root

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val userAdapter = UserAdapter()
        userAdapter.clickListener = object : UserListItemClickListener {
            override fun onItemClicked(binding: RowUserBinding, user: User) {
                navigateToDetails(binding, user)
            }
        }
        val layoutManager = GridLayoutManager(context, resources.getInteger(R.integer.spancount))
        binding.list.layoutManager = layoutManager
        binding.list.adapter = userAdapter
        val userList: ArrayList<com.example.mukesh.model.User> = Util.getUserList(context!!)
        val width=ViewUtil.getDeviceWidth(requireActivity())/resources.getInteger(R.integer.spancount)
        userAdapter.setDeviceWidth(width)
        userAdapter.updateList(userList)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.e(TAG, "onViewCreated $savedInstanceState")
        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }
        setUpToolbar(getString(R.string.title_home))


    }

    private fun navigateToDetails(binding: RowUserBinding, user: User) {
        //findNavController().navigate(action)
        val extras = FragmentNavigatorExtras(
            binding.profilePic to binding.profilePic.transitionName,
            binding.name to binding.name.transitionName
        )

        val map = HashMap<String, String>()
        map.put("ProfileImage", binding.profilePic.transitionName)
        map.put("Name", binding.name.transitionName)
        val transitionArg = SharedTransitionArg()
        transitionArg.map = map
        val action = HomeFragmentDirections.actionUserToUserDetailsFragment(user, transitionArg)
        findNavController().navigate(action, extras)
    }
}