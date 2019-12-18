package com.example.mukesh.view.ui.dashboard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mukesh.R
import com.example.mukesh.databinding.RowDashboardBinding
import com.example.mukesh.model.Dashboard

/**
 * Created by Mukesh Singh on 12/11/2019
 */
class DashboardAdapter : RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {
    private var list: ArrayList<Dashboard> = ArrayList()
    var clickListener:DashboardItemClickListener? = null

    fun updateList(list: ArrayList<Dashboard>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding: RowDashboardBinding =
            DataBindingUtil.inflate(inflater, R.layout.row_dashboard, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(dashboard = list[position])
        holder.binding.executePendingBindings()
    }


    inner class ViewHolder(val binding: RowDashboardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(dashboard: Dashboard){
            binding.circleView.isSeekModeEnabled=false
           binding.circleView.setValueAnimated(dashboard.progressPercentage.toFloat(), 1000)
            when(dashboard.id){
                1->{
                    binding.circleView.setBarColor(itemView.context.resources.getColor(R.color.gray))
                    binding.circleView.setTextColor(itemView.context.resources.getColor(R.color.gray))
                }
                2->{
                    binding.circleView.setBarColor(itemView.context.resources.getColor(R.color.blue))
                    binding.circleView.setTextColor(itemView.context.resources.getColor(R.color.blue))
                }
                3->{
                    binding.circleView.setBarColor(itemView.context.resources.getColor(R.color.green))
                    binding.circleView.setTextColor(itemView.context.resources.getColor(R.color.green))
                }
                4->{
                    binding.circleView.setBarColor(itemView.context.resources.getColor(R.color.red))
                    binding.circleView.setTextColor(itemView.context.resources.getColor(R.color.red))
                }

            }
           binding.name.text=dashboard.title
            binding.circleView.setUnitVisible(false)
           binding.rowParent.setOnClickListener {
               clickListener?.onItemClicked(binding,dashboard)
           }
        }
    }
}