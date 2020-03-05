package com.yulmaso.k_notebook.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.yulmaso.k_notebook.R
import com.yulmaso.k_notebook.databinding.FragmentHomeBinding
import com.yulmaso.k_notebook.di.injectViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class HomeFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel : HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = injectViewModel(viewModelFactory)

        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater, R.layout.fragment_home, container, false)
        binding.lifecycleOwner = this

        //init rv
        val adapter = HomeListAdapter()
        binding.noteList.adapter = adapter
        viewModel.allNotes.observe(viewLifecycleOwner, Observer {
            adapter.setNotes(it)
        })

        //init fab
        binding.actionButton.setOnClickListener{
            val direction = HomeFragmentDirections.actionHomeDestToNoteFragment(-1)
            it.findNavController().navigate(direction)
        }

        return binding.root
    }

}