package com.example.list.screens

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
import com.example.list.R
import com.example.list.data.Task
import com.example.list.data.TaskViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AddScreen : Fragment() {

    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var mTaskViewModel: TaskViewModel
    private lateinit var title: EditText
    private lateinit var description: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_task, container, false)

        mTaskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        title = view.findViewById(R.id.title)
        description = view.findViewById(R.id.description)

        floatingActionButton = view.findViewById(R.id.finally_add)
        floatingActionButton.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val titleText = title.text.toString()
        val descriptionText = description.text.toString()

        if (inputCheck(titleText, descriptionText)) {
            val task = Task(0, titleText, descriptionText, false)
            mTaskViewModel.addTask(task)
            Toast.makeText(requireContext(), "Is Done", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addTask_to_mainScreen)
        }
    }

    private fun inputCheck(title: String, description: String): Boolean {

        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(description))

    }

}