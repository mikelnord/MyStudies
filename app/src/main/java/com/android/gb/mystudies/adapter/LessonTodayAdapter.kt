package com.android.gb.mystudies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.gb.mystudies.databinding.LessonCardViewBinding
import com.android.gb.mystudies.model.Lessons
import com.android.gb.mystudies.ui.LessonViewHolder

class LessonTodayAdapter :
    ListAdapter<Lessons, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return LessonViewHolder(LessonCardViewBinding.inflate(inflater, parent, false))
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LessonViewHolder -> {
                val lessonItem = getItem(position)
                holder.bind(lessonItem)
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Lessons>() {
    override fun areItemsTheSame(oldItem: Lessons, newItem: Lessons): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Lessons, newItem: Lessons): Boolean {
        return oldItem == newItem
    }
}
