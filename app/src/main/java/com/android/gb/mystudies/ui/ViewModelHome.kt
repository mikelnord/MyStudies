package com.android.gb.mystudies.ui

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.gb.mystudies.data.MockRepository
import com.android.gb.mystudies.model.Lessons
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import javax.inject.Inject

@HiltViewModel
class ViewModelHome @Inject constructor(
    private val repository: MockRepository
) : ViewModel() {

    private val timeSeconds: Long
    val times: MutableLiveData<String> = MutableLiveData()
    private val _lessonsToDay = MutableLiveData<List<Lessons>>()
    val lessonsToDay: LiveData<List<Lessons>> = _lessonsToDay
    private val currentTime = LocalDateTime.now()
    private val currentTimeString =
        currentTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))

    init {
        val dateExam = repository.getNextExam(currentTimeString).dateStart
        timeSeconds = ChronoUnit.SECONDS.between(currentTime, dateExam)
        listUsers()
    }

    val countdown_timer = object : CountDownTimer(timeSeconds * 1000, 1000) {
        override fun onFinish() {

        }

        override fun onTick(p0: Long) {
            val input = p0 / 1000
            val numberOfDays = input / 86400
            val numberOfHours = (input % 86400) / 3600
            val numberOfMinutes = ((input % 86400) % 3600) / 60
            val numberOfSeconds = ((input % 86400) % 3600) % 60
            times.value = "$numberOfDays : $numberOfHours: $numberOfMinutes:$numberOfSeconds"
        }
    }

    private fun listUsers() {
        viewModelScope.launch {
            val listLessons = repository.getLessonTodate(currentTimeString)
            _lessonsToDay.postValue(listLessons)
        }
    }


}