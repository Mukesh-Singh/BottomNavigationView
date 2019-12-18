package com.example.mukesh.view.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.example.mukesh.R
import com.example.mukesh.databinding.RowUserBinding
import com.example.mukesh.model.User
import kotlinx.android.synthetic.main.row_user.view.*


/**
 * Created by Mukesh Singh on 12/11/2019
 */
class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    private var list: ArrayList<User> = ArrayList()
    private var rowWidth=0
    var clickListener:UserListItemClickListener? = null
    private val factory=DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()

    fun updateList(list: List<User>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding: RowUserBinding =
            DataBindingUtil.inflate(inflater, R.layout.row_user, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(user = list[position])
        holder.binding.executePendingBindings()
    }

    fun setDeviceWidth(deviceWidth: Int) {
        this.rowWidth=deviceWidth
    }


    inner class ViewHolder(val binding: RowUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(user: User){
            binding.data = user
            binding.profilePic.transitionName= "ProfilePic-$adapterPosition"
            binding.name.transitionName= "Name-$adapterPosition"
            Glide.with(itemView.context).load(user.profile_pic).transition(DrawableTransitionOptions.withCrossFade(factory)).apply(RequestOptions.circleCropTransform()).into(binding.profilePic)
           binding.rowParent.setOnClickListener {
               clickListener?.onItemClicked(binding,user)
           }
            if (rowWidth > 0){
                val view=binding.parent
                val layoutParams: GridLayoutManager.LayoutParams = view.layoutParams as GridLayoutManager.LayoutParams
                layoutParams.width = rowWidth
                view.layoutParams = layoutParams
            }
        }
    }
}