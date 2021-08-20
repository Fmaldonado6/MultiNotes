package com.fmaldonado.multinotesxml.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fmaldonado.multinotesxml.activities.detail.DetailActivity
import com.fmaldonado.multinotesxml.databinding.NoteItemBinding
import com.fmaldonado.multinotesxml.models.Note
import com.fmaldonado.multinotesxml.models.ParcelableKeys

class NotesAdapter(private val notes: List<Note>) :
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    class NoteViewHolder(val binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.binding.noteTitle.text = note.title
        holder.binding.noteItem.setOnClickListener {
            val intent = Intent(holder.binding.root.context, DetailActivity::class.java)
            intent.putExtra(ParcelableKeys.Note.value, note)
            intent.putExtra(ParcelableKeys.NoteIndex.value, position)
            holder.binding.root.context.startActivity(intent)
        }
    }

    override fun getItemCount() = notes.size

}