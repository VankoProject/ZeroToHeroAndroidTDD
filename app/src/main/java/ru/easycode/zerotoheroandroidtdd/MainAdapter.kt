package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ElementTextViewBinding


class MainAdapter : RecyclerView.Adapter<MyViewHolder>() {

    private val itemsList = ArrayList<CharSequence>()

    fun add(source: CharSequence) {
        itemsList.add(source)
        notifyItemInserted(itemsList.size - 1)
    }

    fun save(bundle: Bundle) {
        bundle.putCharSequenceArrayList(KEY, itemsList)
    }
    fun restore(bundle: Bundle) {
        itemsList.addAll(bundle.getCharSequenceArrayList(KEY)?: ArrayList())
        notifyItemRangeChanged(0, itemsList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ElementTextViewBinding.inflate(
            LayoutInflater.from(parent.context)
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = itemsList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    companion object {
        private const val KEY = "adapterKey"
    }

}