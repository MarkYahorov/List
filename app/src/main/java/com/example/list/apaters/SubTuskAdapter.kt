package com.example.list.apaters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.list.R
import com.example.list.UpdateSubTaskDirections
import com.example.list.data.SubTusk
import com.example.list.data.Task
import com.example.list.screens.MainScreenDirections

class SubTuskAdapter: RecyclerView.Adapter<SubTuskAdapter.ViewHolder>() {

    private var subTaskList = emptyList<SubTusk>()

    class ViewHolder(item: View): RecyclerView.ViewHolder(item) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sub_task_item, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentSubTusk = subTaskList[position]
        holder.itemView.findViewById<TextView>(R.id.sub_task_text).text = currentSubTusk.subTitle

        holder.itemView.findViewById<View>(R.id.sub_task_text).setOnClickListener {
            //val action = UpdateSubTaskDirections.a(currentSubTusk)

            //holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int = subTaskList.size

    fun setSubTaskData(subTusk:List<SubTusk>){
        this.subTaskList = subTusk
        notifyDataSetChanged()
    }
}