package ru.easycode.zerotoheroandroidtdd.main

import androidx.fragment.app.FragmentManager
import ru.easycode.zerotoheroandroidtdd.core.BaseFragment

interface Screen {

    fun show(supportFragmentManager: FragmentManager, containerId: Int)

    abstract class Replace(private val fragmentClass: Class<out BaseFragment<*>>) : Screen {
        override fun show(supportFragmentManager: FragmentManager, containerId: Int) {
            supportFragmentManager.beginTransaction()
                .replace(containerId, fragmentClass.getDeclaredConstructor().newInstance())
                .commit()
        }
    }

    abstract class Add(private val fragmentClass: Class<out BaseFragment<*>>) : Screen {
        override fun show(supportFragmentManager: FragmentManager, containerId: Int) {
            supportFragmentManager.beginTransaction()
                .add(containerId, fragmentClass.getDeclaredConstructor().newInstance())
                .addToBackStack(fragmentClass.simpleName)
                .commit()
        }
    }

    object Pop : Screen {
        override fun show(supportFragmentManager: FragmentManager, containerId: Int) {
            supportFragmentManager.popBackStack()
        }
    }

}