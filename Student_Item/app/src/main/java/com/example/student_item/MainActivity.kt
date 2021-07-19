package com.example.student_item

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.student_item.databinding.ActivityMainBinding
import retrofit2.Converter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: StudentViewModel
    private lateinit var studentAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        studentAdapter = StudentAdapter(listOf())
        binding.recyclerview.adapter = studentAdapter

        viewModel = ViewModelProvider(this)[StudentViewModel::class.java]

        binding.recyclerview.apply {
            adapter = studentAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        viewModel.run {
            getItemData()
            studentLiveData.observe(this@MainActivity, { list ->
                studentAdapter.list = list
                studentAdapter.notifyDataSetChanged()
            })
        }
    }
}