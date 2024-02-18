package ru.easycode.zerotoheroandroidtdd.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.easycode.zerotoheroandroidtdd.core.BaseFragment
import ru.easycode.zerotoheroandroidtdd.core.BundleWrapper
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.FragmentListBinding

class ListFragment : BaseFragment<FragmentListBinding>() {

    private lateinit var viewModel: ListViewModel

    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentListBinding {
        return FragmentListBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as ProvideViewModel).viewModel(ListViewModel::class.java)

        savedInstanceState?.let {
            viewModel.restore(BundleWrapper.Base(it))
        }

        val adapter = MyAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.liveData().observe(viewLifecycleOwner) {
            adapter.update(it)
        }

        binding.addButton.setOnClickListener {
            viewModel.create()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.save(BundleWrapper.Base(outState))
    }

}