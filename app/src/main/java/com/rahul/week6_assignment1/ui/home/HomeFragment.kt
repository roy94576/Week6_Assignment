package com.rahul.week6_assignment1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.rahul.week6_assignment1.HomeActivity
import com.rahul.week6_assignment1.R
import com.rahul.week6_assignment1.adapter.StudentAdapter
import com.rahul.week6_assignment1.model.Student

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var lstStudent = arrayListOf<Student>()
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = root.findViewById(R.id.recyclerViewUser)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            lstStudent = (activity as HomeActivity).lstUser
            val context = root.context
            val adapter = StudentAdapter(lstStudent, context)
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = adapter
        })
        return root
    }
}