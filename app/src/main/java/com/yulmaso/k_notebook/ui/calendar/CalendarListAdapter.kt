package com.yulmaso.k_notebook.ui.calendar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.yulmaso.k_notebook.databinding.ItemNoteBinding
import com.yulmaso.k_notebook.storage.model.Note

class CalendarListAdapter: RecyclerView.Adapter<CalendarListAdapter.ViewHolder>() {

    private var notes: List<Note> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemNoteBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(createOnClickListener(notes[position].id), notes[position])
    }

    private fun createOnClickListener(id: Int): View.OnClickListener {
        return View.OnClickListener {
            val direction = CalendarFragmentDirections.actionCalendarDestToNoteFragment(id)
            it.findNavController().navigate(direction)
        }
    }

    fun setNotes(notes: List<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: ItemNoteBinding
    ): RecyclerView.ViewHolder(binding.root){

        fun bind(listener: View.OnClickListener, item: Note) = with(itemView){
            binding.apply {
                note = item
                onClickListener = listener
                executePendingBindings()
            }
        }

    }
}