package com.example.list.screens

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.list.R
import com.example.list.data.Task
import com.example.list.data.TaskViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class UpdateTask : Fragment() {

    private val args by navArgs<UpdateTaskArgs>()
    private lateinit var title: EditText
    private lateinit var description: EditText
    private lateinit var updateBtn: FloatingActionButton
    private lateinit var mTaskViewModel: TaskViewModel
    private lateinit var delete: FloatingActionButton


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update_task, container, false)
        title = view.findViewById(R.id.title_update)
        description = view.findViewById(R.id.description_update)
        updateBtn = view.findViewById(R.id.finally_update)
        delete = view.findViewById(R.id.delete)

        mTaskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        delete.setOnClickListener {
            deleteTask()
        }

        title.setText(args.currentTask.title)
        description.setText(args.currentTask.detection)
        updateBtn.setOnClickListener {
            updateTask()
        }

        return view
    }

    private fun updateTask(){
        val titleUpDate = title.text.toString()
        val descriptionUpDate = description.text.toString()

        if (inputCheck(titleUpDate, descriptionUpDate)){
            val updateTask = Task(args.currentTask.id, titleUpDate, descriptionUpDate, false)
            mTaskViewModel.updateTask(updateTask)
            findNavController().navigate(R.id.action_updateTask_to_mainScreen)
        }
    }

    private fun inputCheck(title: String, description: String): Boolean {

        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(description))

    }

    private fun deleteTask(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _,_  ->
            mTaskViewModel.deleteTask(args.currentTask)
            findNavController().navigate(R.id.action_updateTask_to_mainScreen)
        }
        builder.setNegativeButton("No") { _,_ -> }
        builder.setTitle("Delete ${args.currentTask.title}?")
        builder.setMessage("Are you sure you want to delete ${args.currentTask.title}?")
        builder.show()

    }

}