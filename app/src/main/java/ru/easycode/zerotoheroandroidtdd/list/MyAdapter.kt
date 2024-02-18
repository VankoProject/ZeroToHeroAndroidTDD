package ru.easycode.zerotoheroandroidtdd.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.easycode.zerotoheroandroidtdd.databinding.ItemLayoutBinding

class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {

    private val list = ArrayList<CharSequence>()

    fun update(newList: List<CharSequence>) {
        val differ = DiffUtilCallBack(list, newList)
        val result = DiffUtil.calculateDiff(differ)
        list.clear()
        list.addAll(newList)
        result.dispatchUpdatesTo(this)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }
}

class MyViewHolder(private val binding: ItemLayoutBinding) : ViewHolder(binding.root) {
    fun bind(data: CharSequence) {
        binding.elementTextView.text = data.toString()
    }
}

private class DiffUtilCallBack(
    private val oldList: List<CharSequence>,
    private val newList: List<CharSequence>
): DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (oldList[oldItemPosition] == newList[newItemPosition])
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (oldList[oldItemPosition] == newList[newItemPosition])
    }

}