package com.android.gb.mystudies.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.gb.mystudies.ui.ClassesFragment
import com.android.gb.mystudies.ui.HomeFragment

const val HOME_PAGE_INDEX = 0
const val CLASSES_PAGE_INDEX = 1

class PageAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        HOME_PAGE_INDEX to { HomeFragment() },
        CLASSES_PAGE_INDEX to { ClassesFragment() },
    )

    override fun getItemCount() = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}