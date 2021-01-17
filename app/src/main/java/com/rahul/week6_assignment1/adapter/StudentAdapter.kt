package com.rahul.week6_assignment1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rahul.week6_assignment1.R
import com.rahul.week6_assignment1.model.Student
import de.hdodenhof.circleimageview.CircleImageView

class StudentAdapter (
        val lstStudent: ArrayList<Student>,
        val context: Context
): RecyclerView.Adapter<StudentAdapter.UserViewHolder>() {
    class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val imgProfile: CircleImageView

        val tvName: TextView
        val tvAge: TextView
        val tvAddress: TextView
        val tvGender: TextView
        val btnDelete: ImageButton
        init{
            imgProfile = view.findViewById(R.id.imgProfile)
            tvName = view.findViewById(R.id.tvName)
            tvAge = view.findViewById(R.id.tvAge)
            tvAddress = view.findViewById(R.id.tvAddress)
            tvGender = view.findViewById(R.id.tvGender)
            btnDelete = view.findViewById(R.id.btnDelete)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_home2, parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = lstStudent[position]
        holder.tvName.text = user.fullName
        holder.tvAge.text = user.age.toString()
        holder.tvAddress.text = user.address
        holder.tvGender.text = user.gender

        Glide.with(context)
                .load(user.profileLink)
                .into(holder.imgProfile)

        holder.btnDelete.setOnClickListener {
            lstStudent.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, lstStudent.size)
        }
    }

    override fun getItemCount(): Int {
        return lstStudent.size
    }
}
