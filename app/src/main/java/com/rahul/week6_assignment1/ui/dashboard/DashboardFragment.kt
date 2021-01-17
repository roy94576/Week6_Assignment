package com.rahul.week6_assignment1.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.rahul.week6_assignment1.HomeActivity
import com.rahul.week6_assignment1.R
import com.rahul.week6_assignment1.model.Student

class DashboardFragment : Fragment() {
    private lateinit var dashboardViewModel: DashboardViewModel

    private lateinit var etFullname: TextInputEditText
    private lateinit var etAge: TextInputEditText
    private lateinit var radioGroupGender: RadioGroup
    private lateinit var rdoMale: RadioButton
    private lateinit var rdoFemale: RadioButton
    private lateinit var rdoOthers: RadioButton
    private lateinit var etAddress: TextInputEditText
    private lateinit var etProfileLink: TextInputEditText
    private lateinit var btnSave: Button

    private var lstUser = arrayListOf<Student>()
    private var gender: String = ""

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
//        val textView: TextView = root.findViewById(R.id.text_dashboard)

        etFullname = root.findViewById(R.id.etFullname)
        etAge = root.findViewById(R.id.etAge)
        radioGroupGender = root.findViewById(R.id.radioGroupGender)
        rdoMale = root.findViewById(R.id.rdoMale)
        rdoFemale = root.findViewById(R.id.rdoFemale)
        rdoOthers = root.findViewById(R.id.rdoOthers)
        etAddress = root.findViewById(R.id.etAddress)
        etProfileLink = root.findViewById(R.id.etProfileLink)
        btnSave = root.findViewById(R.id.btnSave)

        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it

            lstUser = (activity as HomeActivity).lstUser

            radioGroupGender.setOnCheckedChangeListener { radioGroup, i ->
                when (i) {
                    R.id.rdoMale -> {
                        gender = "Male"
                    }
                    R.id.rdoFemale -> {
                        gender = "Female"
                    }
                    R.id.rdoOthers -> {
                        gender = "Others"
                    }
                }
            }

            btnSave.setOnClickListener {
                val fullName = etFullname.text.toString()
                val age = etAge.text.toString().toInt()
                val gen = gender
                val address = etAddress.text.toString()
                val profileLink = etProfileLink.text.toString()

                val user = Student(fullName, age, gen, address, profileLink)
                lstUser.add(user)
                Toast.makeText(context, "added", Toast.LENGTH_SHORT).show()
            }
        })
        return root
    }
}

