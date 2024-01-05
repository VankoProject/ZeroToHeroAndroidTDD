package ru.easycode.zerotoheroandroidtdd

class MainViewModel(
    private val listLiveDataWrapper: LiveDataWrapper
) {

    fun liveData() = listLiveDataWrapper.liveData()

    fun add(text: CharSequence) {
        listLiveDataWrapper.add(text)
    }

    fun save(bundle: BundleWrapper.Save) {
        listLiveDataWrapper.save(bundle)
    }

    fun restore(bundle: BundleWrapper.Restore) {
        val restoreList = bundle.restore()
        listLiveDataWrapper.update(restoreList)
    }

}