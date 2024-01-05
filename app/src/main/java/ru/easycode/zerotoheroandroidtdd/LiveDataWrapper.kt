package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map

interface LiveDataWrapper {

    fun liveData(): LiveData<List<CharSequence>>
    fun add(newData: CharSequence)
    fun save(bundle: BundleWrapper.Save)
    fun update(list: List<CharSequence>)

    class Base(
        private val liveData: MutableLiveData<ArrayList<CharSequence>> = SingleLiveEvent()
    ) : LiveDataWrapper {
        override fun liveData(): LiveData<List<CharSequence>> = liveData.map { it.toList() }

        override fun add(newData: CharSequence) {
            val currentList = liveData.value ?: ArrayList()
            currentList.add(newData)
            update(currentList)
        }

        override fun save(bundle: BundleWrapper.Save) {
            bundle.save(liveData.value ?: ArrayList())
        }

        override fun update(list: List<CharSequence>) {
            liveData.value = ArrayList(list)
        }

    }
}