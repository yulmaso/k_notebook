package com.yulmaso.k_notebook.ui.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.yulmaso.k_notebook.R
import com.yulmaso.k_notebook.databinding.FragmentHomeBinding
import com.yulmaso.k_notebook.databinding.FragmentNoteBinding
import com.yulmaso.k_notebook.di.injectViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class NoteFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: NoteViewModel

    private val args: NoteFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = injectViewModel(viewModelFactory)
        viewModel.setNote(args.idNote)

        val binding = DataBindingUtil.inflate<FragmentNoteBinding>(
            inflater, R.layout.fragment_note, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}