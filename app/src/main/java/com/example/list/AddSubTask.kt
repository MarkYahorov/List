package com.example.list

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.list.data.SubTusk
import com.example.list.data.Task
import com.example.list.data.TaskViewModel
import com.example.list.screens.UpdateTaskArgs
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AddSubTask : Fragment() {

    private val args by navArgs<UpdateTaskArgs>()
    private lateinit var title: EditText
    private lateinit var saveSubTusk: FloatingActionButton
    private lateinit var mTaskViewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_add_sub_task, container, false)

        mTaskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        title = view.findViewById(R.id.sub_task_enter)
        saveSubTusk = view.findViewById(R.id.save_sub_task)
        saveSubTusk.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val titleSubTaskText = title.text.toString()


        if (inputCheck(titleSubTaskText)) {
            val subTask = SubTusk(0, titleSubTaskText, args.currentTask.id)
            mTaskViewModel.addSubTask(subTask)
            Toast.makeText(requireContext(),"Is Done", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addSubTask_to_updateTask)
        }
    }

    private fun inputCheck(title: String): Boolean {

        return !(TextUtils.isEmpty(title))

    }

}