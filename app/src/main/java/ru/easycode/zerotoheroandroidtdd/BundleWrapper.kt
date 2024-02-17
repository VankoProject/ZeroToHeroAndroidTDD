package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle

interface BundleWrapper {

    interface Save {

        fun save(data: ArrayList<CharSequence>)
    }

    interface Restore {

        fun restore(): ArrayList<CharSequence>
    }

    interface Mutable : Save, Restore

    class Base(private val bundle: Bundle) : Mutable {
        override fun save(data: ArrayList<CharSequence>) {
            bundle.putCharSequenceArrayList(KEY, data)
        }

        override fun restore(): ArrayList<CharSequence> {
            return bundle.getCharSequenceArrayList(KEY) ?: ArrayList()
        }
    }

    companion object {
        private const val KEY = "dataKey"
    }
}