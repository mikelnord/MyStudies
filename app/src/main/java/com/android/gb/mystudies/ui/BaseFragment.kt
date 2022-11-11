package com.android.gb.mystudies.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.android.gb.mystudies.R
import com.android.gb.mystudies.adapter.CLASSES_PAGE_INDEX
import com.android.gb.mystudies.adapter.HOME_PAGE_INDEX
import com.android.gb.mystudies.adapter.PageAdapter
import com.android.gb.mystudies.databinding.FragmentBaseBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class BaseFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private var _binding: FragmentBaseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBaseBinding.inflate(inflater, container, false)
        val tabLayout = binding.tabs
        viewPager = binding.viewPager

        viewPager.adapter = PageAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(getTabIcon(position))
            if (position == HOME_PAGE_INDEX) {
                tab.text = getTabTitle(position)
            }
        }.attach()
        binding.tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    HOME_PAGE_INDEX -> tab.text = getString(R.string.home_title)
                    CLASSES_PAGE_INDEX -> tab.text = getString(R.string.classes_title)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.text = ""
            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        return binding.root
    }

    private fun getTabIcon(position: Int): Int {
        return when (position) {
            HOME_PAGE_INDEX -> R.drawable.ic_home_selector
            CLASSES_PAGE_INDEX -> R.drawable.ic_classes_selector
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            HOME_PAGE_INDEX -> getString(R.string.home_title)
            CLASSES_PAGE_INDEX -> getString(R.string.classes_title)
            else -> null
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}