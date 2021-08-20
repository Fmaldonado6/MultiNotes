package com.fmaldonado.multinotesxml.activities.main

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.fmaldonado.multinotesxml.R
import com.fmaldonado.multinotesxml.activities.add.AddActivity
import com.fmaldonado.multinotesxml.adapter.NotesAdapter
import com.fmaldonado.multinotesxml.databinding.ActivityMainBinding
import com.fmaldonado.multinotesxml.models.Note

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    private lateinit var notesAdapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        viewModel.notes.observe(this, {
            setupRecycler(it)
            binding.notesLength = it.size
        })

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setupRecycler(list: List<Note>) {
        if (!::notesAdapter.isInitialized) {
            notesAdapter = NotesAdapter(list)
            binding.recyclerView.adapter = notesAdapter
        } else
            notesAdapter.notifyDataSetChanged()
    }
}