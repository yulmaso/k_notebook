package com.yulmaso.k_notebook.ui.htags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.yulmaso.k_notebook.R
import com.yulmaso.k_notebook.databinding.FragmentHtagsBinding
import com.yulmaso.k_notebook.di.injectViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class HtagsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel : HtagsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = injectViewModel(viewModelFactory)

        val binding = DataBindingUtil.inflate<FragmentHtagsBinding>(
            inflater, R.layout.fragment_htags, container, false
        )
        binding.lifecycleOwner = this

        return binding.root
    }

}