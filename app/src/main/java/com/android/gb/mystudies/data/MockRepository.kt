package com.android.gb.mystudies.data

import com.android.gb.mystudies.model.Exam
import com.android.gb.mystudies.model.Lessons
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MockRepository @Inject constructor() {

    val listLessonsToDate= listOf<Lessons>(Lessons(1,"History","2022-11-12 08:00","2022-11-12 08:45",true),
        Lessons(2,"Physics","2022-11-12 09:00","2022-11-12 09:45",false),
        Lessons(3,"Mathematics","2022-11-12 09:55","2022-11-12 10:40",true),
        Lessons(4,"Biology","2022-11-12 10:50","2022-11-12 10:35",true))

    fun getNextExam(date: String): Exam {
        val dateExam="2022-11-15 16:00:00"
        val dateFormatInput = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        return Exam(LocalDateTime.parse(dateExam,dateFormatInput))
    }

    fun getLessonTodate(date:String):List<Lessons>{
        return listLessonsToDate
    }

}