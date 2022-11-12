package com.android.gb.mystudies.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.gb.mystudies.adapter.LessonTodayAdapter
import com.android.gb.mystudies.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ViewModelHome by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        setupUI()
        return binding.root
    }

    private fun setupUI() {
        val adapter = LessonTodayAdapter()
        binding.recyclerViewClasses.adapter = adapter
        binding.recyclerViewClasses.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        viewModel.countdown_timer.start()
        viewModel.times.observe(viewLifecycleOwner) {
            binding.textTimerEx.text = it
        }
        viewModel.lessonsToDay.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}