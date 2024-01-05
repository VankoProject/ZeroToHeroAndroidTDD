package ru.easycode.zerotoheroandroidtdd

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ItemTextBinding

class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {

    private val listItems = ArrayList<CharSequence>()

    fun update(newList: List<CharSequence>) {
        val diffUtil = DiffUtilCallback(listItems, newList)
        val diff = DiffUtil.calculateDiff(diffUtil)
        listItems.clear()
        listItems.addAll(newList)
        diff.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemTextBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int = listItems.size
}

class MyViewHolder(private val binding: ItemTextBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: CharSequence) {
        binding.elementTextView.text = data
    }
}