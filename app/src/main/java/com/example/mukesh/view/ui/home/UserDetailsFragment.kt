package com.example.mukesh.view.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mukesh.databinding.FragmentUserDetailsBinding
import com.example.mukesh.view.ui.base.ToolbarBackButtonFragment
import com.example.mukesh.view.ui.home.model.SharedTransitionArg
import com.google.android.material.appbar.AppBarLayout

/**
 * Created by Mukesh Singh on 12/11/2019
 */
class UserDetailsFragment : ToolbarBackButtonFragment(), AppBarLayout.OnOffsetChangedListener {
    private val TAG:String =UserDetailsFragment::class.java.simpleName
    private lateinit var binding: FragmentUserDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        requireActivity().onBackPressedDispatcher.addCallback(this,true) {
            findNavController().navigateUp()
            Log.d("UserDetailsFragment","Backpressed")
        }
        binding.appBarLayout.addOnOffsetChangedListener(this)
        return binding.root
        //return inflater.inflate(R.layout.fragment_detail, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val safeArgs: UserDetailsFragmentArgs by navArgs()
        val sharedArg:SharedTransitionArg=safeArgs.transitionArgument
        binding.user=safeArgs.user
        binding.executePendingBindings()
        setUpToolbar(binding.name.text.toString(),true)
        binding.profilePic.transitionName=sharedArg.map.get("ProfileImage")
        binding.name.transitionName=sharedArg.map.get("Name")
        Glide.with(this).load(safeArgs.user.profile_pic).apply(RequestOptions.circleCropTransform()).into(binding.profilePic)
        Glide.with(this).load(safeArgs.user.banner).into(binding.headerImage)
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        val maxScroll = appBarLayout!!.totalScrollRange
        val percentage =
            Math.abs(verticalOffset) / maxScroll.toFloat()

        Log.i(TAG,"Scrolled percentage $percentage")
        var alpha=1-percentage
        binding.profilePicLayout.alpha=alpha
        binding.collapsingLayout.isTitleEnabled = percentage <0.7


    }


}