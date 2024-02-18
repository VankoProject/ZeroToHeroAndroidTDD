package ru.easycode.zerotoheroandroidtdd.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.widget.addTextChangedListener
import ru.easycode.zerotoheroandroidtdd.core.BaseFragment
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.FragmentCreateBinding

class CreateFragment : BaseFragment<FragmentCreateBinding>() {

    private lateinit var viewModel: CreateViewModel

    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentCreateBinding {
        return FragmentCreateBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as ProvideViewModel).viewModel(CreateViewModel::class.java)

        requireActivity().onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                viewModel.comeback()
            }
        })

        with(binding) {
            inputEditText.addTextChangedListener {
                createButton.isEnabled = binding.inputEditText.text.toString().length >= 3
            }

            createButton.setOnClickListener {
                viewModel.add(binding.inputEditText.text.toString())
                hideKeyBoard()
            }
        }

    }
}