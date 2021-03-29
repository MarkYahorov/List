package com.example.list.screens

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.list.R
import com.example.list.apaters.TaskAdapter
import com.example.list.data.TaskViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainScreen : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var mTaskViewModel: TaskViewModel
    private lateinit var deleteAll: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_screen, container, false)

        recyclerView = view.findViewById(R.id.recycler_tasks)
        floatingActionButton = view.findViewById(R.id.add_task)
        deleteAll = view.findViewById(R.id.delete_all)

        val adapter = TaskAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.hasFixedSize()

        floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainScreen_to_addTask)
        }

        deleteAll.setOnClickListener {
            deleteAll()
        }

        mTaskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        mTaskViewModel.getAllData.observe(viewLifecycleOwner, Observer { task ->
            adapter.setData(task)
        })
        return view
    }

    private fun deleteAll() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mTaskViewModel.deleteAllTasks()
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete everything?")
        builder.setMessage("Are you sure you want to delete everything?")
        builder.show()
    }

}