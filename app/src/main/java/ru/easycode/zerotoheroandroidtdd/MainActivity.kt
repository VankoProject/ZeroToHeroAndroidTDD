package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel = (application as App).viewModel

        val adapter = MyAdapter()
        binding.recyclerView.adapter = adapter

        binding.actionButton.setOnClickListener {
            val text = binding.inputEditText.text.toString()
            viewModel.add(text = text)
            binding.inputEditText.setText("")
        }

        viewModel.liveData().observe(this) {
            adapter.update(it)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.save(BundleWrapper.Base(outState))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        viewModel.restore(BundleWrapper.Base(savedInstanceState))
    }
}