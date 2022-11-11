package com.android.gb.mystudies.model

import java.time.LocalDateTime
import java.util.*

data class Lessons(
    val name: String,
    val dateStart: Date,
    val dateEnd: Date
)

data class Exam(
    val dateStart: LocalDateTime
)