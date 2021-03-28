package com.example.list.apaters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.list.R
import com.example.list.data.Task
import com.example.list.screens.MainScreenDirections

class TaskAdapter: RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
    private var taskList = emptyList<Task>()

    class ViewHolder(item: View): RecyclerView.ViewHolder(item) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_item, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = taskList[position]
        holder.itemView.findViewById<TextView>(R.id.task_text).text = currentItem.title

        holder.itemView.findViewById<View>(R.id.the_task).setOnClickListener {
            val action = MainScreenDirections.actionMainScreenToUpdateTask(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int = taskList.size

    fun setData(task: List<Task>){
        this.taskList = task
        notifyDataSetChanged()
    }
}