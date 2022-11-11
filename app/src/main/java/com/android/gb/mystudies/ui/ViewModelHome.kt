package com.android.gb.mystudies.ui

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.gb.mystudies.data.MockRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import javax.inject.Inject

@HiltViewModel
class ViewModelHome @Inject constructor(
    repository: MockRepository
) : ViewModel() {

    private val timeSeconds: Long
    val times:MutableLiveData<String> = MutableLiveData()

    init {
        val currentTime = LocalDateTime.now()
        val dateExam =
            repository.getNextExam(currentTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).dateStart
        timeSeconds = ChronoUnit.SECONDS.between(currentTime, dateExam)
    }

    val countdown_timer = object : CountDownTimer(timeSeconds*1000, 1000) {
        override fun onFinish() {

        }

        override fun onTick(p0: Long) {
            val input=p0/1000
            val numberOfDays = input / 86400;
            val numberOfHours = (input % 86400 ) / 3600 ;
            val numberOfMinutes = ((input % 86400 ) % 3600 ) / 60
            val numberOfSeconds = ((input % 86400 ) % 3600 ) % 60
            times.value ="$numberOfDays : $numberOfHours: $numberOfMinutes:$numberOfSeconds"
        }
    }

}