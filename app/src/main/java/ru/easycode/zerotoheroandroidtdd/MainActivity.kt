package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding
import ru.easycode.zerotoheroandroidtdd.databinding.ListItemBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            actionButton.setOnClickListener {
                val inputText = inputEditText.text
                addTextView(inputText.toString())
                inputEditText.text?.clear()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val textViewTextList = binding.contentLayout.children.map {
            (it as TextView).text.toString()
        }.toList()
        outState.putStringArrayList(KEY, ArrayList(textViewTextList))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val textViewList = savedInstanceState.getStringArrayList(KEY) ?: ArrayList()
        textViewList.forEach {
            addTextView(it.toString())
        }
    }

    companion object {
        private const val KEY = "textKey"
    }

    private fun addTextView(inputText: String) {
//        val textView = TextView(this@MainActivity).apply {
//            text = inputText
//        }
        val itemBinding = ListItemBinding.inflate(layoutInflater)
        val textView = itemBinding.root
        textView.text = inputText
        binding.contentLayout.addView(textView)
    }
}
