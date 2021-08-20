package com.fmaldonado.multinotesxml.activities.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.core.widget.doOnTextChanged
import com.fmaldonado.multinotesxml.R
import com.fmaldonado.multinotesxml.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding
    private val viewModel: AddActivityViewModel by viewModels()
    private var title = ""
    private var description = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.noteTitle.editText?.doOnTextChanged { text, _, _, _ ->
            title = text.toString()
            binding.addButton.isEnabled = title.isNotEmpty() && description.isNotEmpty()
        }

        binding.noteDescription.editText?.doOnTextChanged { text, _, _, _ ->
            description = text.toString()
            binding.addButton.isEnabled = title.isNotEmpty() && description.isNotEmpty()
        }

        binding.addButton.setOnClickListener {
            viewModel.addNote(title, description)
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}