package ru.easycode.zerotoheroandroidtdd

import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ElementTextViewBinding

class MyViewHolder(private val binding: ElementTextViewBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bind(data: CharSequence) {
            binding.elementTextView.text = data
        }
    }
