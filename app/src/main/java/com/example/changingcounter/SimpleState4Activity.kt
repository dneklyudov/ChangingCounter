package com.example.changingcounter

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.example.changingcounter.databinding.ActivityMainBinding

class SimpleState4Activity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<SimpleState4ViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        binding.incrementButton.setOnClickListener { viewModel.increment() }
        binding.randomColorButton.setOnClickListener { viewModel.setRandomColor() }
        binding.switchVisibilityButton.setOnClickListener { viewModel.switchVisibility() }

        if (viewModel.state.value == null) {
            viewModel.initState(
                SimpleState4ViewModel.State(
                    counterValue = 0,
                    counterTextColor = ContextCompat.getColor(this, R.color.black),
                    counterIsVisible = true
                )
            )
        }

        viewModel.state.observe(this, Observer { renderState(it) } )
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putInt(KEY_COUNTER, counterValue)
//        outState.putInt(KEY_COLOR, counterTextColor)
//        outState.putBoolean(KEY_IS_VISIBLE, counterIsVisible)
//    }

    private fun renderState(state: SimpleState4ViewModel.State) = with(binding) {
        counterTextView.setText(state.counterValue.toString())
        counterTextView.setTextColor(state.counterTextColor)
        counterTextView.visibility = if (state.counterIsVisible) View.VISIBLE else View.INVISIBLE
    }

//    companion object {
//        @JvmStatic private val KEY_COUNTER = "COUNTER"
//        @JvmStatic private val KEY_COLOR = "COLOR"
//        @JvmStatic private val KEY_IS_VISIBLE = "IS_VISIBLE"
//    }
//
//    private fun increment() {
//        counterValue++
//        renderState()
//    }
//
//    private fun setRandomColor() {
//        counterTextColor = Color.rgb(
//            kotlin.random.Random.nextInt(256),
//            kotlin.random.Random.nextInt(256),
//            kotlin.random.Random.nextInt(256)
//        )
//        renderState()
//    }
//
//    private fun switchVisibility() = with(binding.counterTextView) {
//        counterIsVisible = !counterIsVisible
//        renderState()
//    }

}