package com.example.changingcounter

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SimpleState4ViewModel : ViewModel() {
    val state: LiveData<State> get() = stateLiveData
    private val stateLiveData = MutableLiveData<State>()

    fun initState(state: State) {
        stateLiveData.value = state
    }

    fun increment() {
        val oldState = stateLiveData.value
//        stateLiveData.value = oldState?.copy(
//            counterValue = oldState.counterValue + 1
//        )
    }

    fun setRandomColor() {
        val oldState = stateLiveData.value
//        stateLiveData.value = oldState?.copy(
//            counterTextColor = Color.rgb(
//                kotlin.random.Random.nextInt(256),
//                kotlin.random.Random.nextInt(256),
//                kotlin.random.Random.nextInt(256)
//            )
//        )
    }

    fun switchVisibility() {
        val oldState = stateLiveData.value
//        stateLiveData.value = oldState?.copy(
//            counterIsVisible = !oldState.counterIsVisible
//        )
    }

    class State(
        val counterValue: Int,
        val counterTextColor: Int,
        val counterIsVisible: Boolean
    )
}