package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel

interface ViewModelFactory : ProvideViewModel, ClearViewModel {

    class Base(
        private val provideViewModel: ProvideViewModel,
    ) : ViewModelFactory {

        private val map = mutableMapOf<Class<out ViewModel>, ViewModel>()

        override fun <T : ViewModel> viewModel(viewModelclass: Class<T>): T {
            return if (map.containsKey(viewModelclass))
                map[viewModelclass] as T
            else {
                val viewModel = provideViewModel.viewModel(viewModelclass)
                map[viewModelclass] = viewModel
                viewModel
            }
        }

        override fun clear(viewModelClass: Class<out ViewModel>) {
            map.remove(viewModelClass)
        }

    }
}