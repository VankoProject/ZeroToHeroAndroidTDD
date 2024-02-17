package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.easycode.zerotoheroandroidtdd.databinding.ElementItemBinding

class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {

    private val list = ArrayList<CharSequence>()

    @SuppressLint("NotifyDataSetChanged")
    fun show(text: CharSequence) {
        list.add(text)
        notifyDataSetChanged()
    }

    fun save(bundleWrapper: BundleWrapper.Save) {
        bundleWrapper.save(list)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun restore(bundleWrapper: BundleWrapper.Restore) {
        val newList = bundleWrapper.restore()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            ElementItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

}

class MyViewHolder(private val binding: ElementItemBinding) : ViewHolder(binding.root) {

    fun bind(text: CharSequence) {
        binding.elementTextView.text = text.toString()
    }
}
