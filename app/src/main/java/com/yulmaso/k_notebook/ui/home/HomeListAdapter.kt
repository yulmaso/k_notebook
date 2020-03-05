package com.yulmaso.k_notebook.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.yulmaso.k_notebook.databinding.ItemNoteBinding
import com.yulmaso.k_notebook.storage.model.Note

class HomeListAdapter : RecyclerView.Adapter<HomeListAdapter.NoteViewHolder>() {

    private var notes: List<Note> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(ItemNoteBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(createOnCLickListener(notes[position].id), notes[position])
    }

    fun setNotes(notes: List<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }

    private fun createOnCLickListener(id: Int): View.OnClickListener{
        return View.OnClickListener {
            val direction = HomeFragmentDirections.actionHomeDestToNoteFragment(id)
            it.findNavController().navigate(direction)
        }
    }

    class NoteViewHolder(
        private val binding: ItemNoteBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Note) = with(itemView) {
            binding.apply{
                note = item
                onClickListener = listener
                executePendingBindings()
            }
        }
    }
}