package com.android.gb.mystudies.data

import com.android.gb.mystudies.model.Exam
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MockRepository @Inject constructor() {

    fun getNextExam(date: String): Exam {
        val dateExam="2022-11-15 16:00:00"
        val dateFormatInput = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        return Exam(LocalDateTime.parse(dateExam,dateFormatInput))
    }

}