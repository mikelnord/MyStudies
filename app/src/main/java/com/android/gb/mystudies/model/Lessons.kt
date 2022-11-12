package com.android.gb.mystudies.model

import java.time.LocalDateTime

data class Lessons(
    val id:Int,
    val name: String,
    val dateStart: String,
    val dateEnd: String,
    val isOnline:Boolean
)

data class Exam(
    val dateStart: LocalDateTime
)