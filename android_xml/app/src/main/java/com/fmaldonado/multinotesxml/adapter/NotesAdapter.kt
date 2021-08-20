package com.fmaldonado.multinotesxml.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fmaldonado.multinotesxml.databinding.NoteItemBinding
import com.fmaldonado.multinotesxml.models.Note

class NotesAdapter(private val notes: List<Note>) :
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    class NoteViewHolder(val binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        Log.d("NOTE", note.title)
        holder.binding.noteTitle.text = note.title
    }

    override fun getItemCount() = notes.size

}