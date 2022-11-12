package com.android.gb.mystudies.ui

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.android.gb.mystudies.databinding.LessonCardViewBinding
import com.android.gb.mystudies.model.Lessons
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class LessonViewHolder(private val binding: LessonCardViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(item: Lessons) {
        binding.lessonName.text = item.name
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val dateStart = LocalDateTime.parse(item.dateStart, formatter)
        val dateEnd = LocalDateTime.parse(item.dateEnd, formatter)
        binding.period.text = "${dateStart.format(DateTimeFormatter.ofPattern("HH:mm"))} - " +
                dateEnd.format(DateTimeFormatter.ofPattern("HH:mm"))
        if (item.isOnline){
            binding.imageButton.visibility=View.VISIBLE
        } else {
            binding.imageButton.visibility=View.GONE
        }

    }
}