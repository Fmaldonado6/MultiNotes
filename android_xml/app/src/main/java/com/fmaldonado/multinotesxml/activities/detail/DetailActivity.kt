package com.fmaldonado.multinotesxml.activities.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import com.fmaldonado.multinotesxml.R
import com.fmaldonado.multinotesxml.databinding.ActivityDetailBinding
import com.fmaldonado.multinotesxml.models.Note
import com.fmaldonado.multinotesxml.models.ParcelableKeys
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlin.properties.Delegates

class DetailActivity : AppCompatActivity() {
    private val viewModel: DetailActivityViewModel by viewModels()
    private lateinit var binding: ActivityDetailBinding
    private var index: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val note = intent.extras?.getParcelable<Note>(ParcelableKeys.Note.value)
        index = intent.extras?.getInt(ParcelableKeys.NoteIndex.value)
        if (note == null || index == null)
            finish()

        supportActionBar?.title = note!!.title
        binding.description.text = note.description
        binding.deleteButton.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Delete note?")
                .setMessage("Are you sure you would like to delete this note?")
                .setNegativeButton("Delete") { dialog, _ ->
                    viewModel.deleteNote(index!!)
                    dialog.dismiss()
                    finish()
                }.setPositiveButton("Cancel") { dialog, _ ->
                    dialog.dismiss()
                }.show()
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