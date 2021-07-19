package com.example.student_item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.student_item.databinding.StudentsItemBinding


class StudentAdapter(var list: List <Item_Data>):RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
        class ViewHolder(var binding: StudentsItemBinding): RecyclerView.ViewHolder(binding.root){

                fun bind(student:Item_Data){
                        binding.apply {
                                textView.text = student.id.toString()
                                textView2.text = student.name
                                textView3.text = student.price.toString()
                        }

                }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                val binding = StudentsItemBinding.inflate(LayoutInflater.from(parent.context))
                return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                holder.bind(list[position])
        }

        override fun getItemCount(): Int {
                return list.size
        }
}