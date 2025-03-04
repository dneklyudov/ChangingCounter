package com.example.changingcounter

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import com.example.changingcounter.databinding.ActivityMainBinding

class SimpleState1Activity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        binding.incrementButton.setOnClickListener { increment() }
        binding.randomColorButton.setOnClickListener { setRandomColor() }
        binding.switchVisibilityButton.setOnClickListener { switchVisibility() }
    }

    private fun increment() {
        var counter = binding.counterTextView.text.toString().toInt()
        counter++
        binding.counterTextView.setText(counter.toString())
    }

    private fun setRandomColor() {
        val randomColor = Color.rgb(
            kotlin.random.Random.nextInt(256),
            kotlin.random.Random.nextInt(256),
            kotlin.random.Random.nextInt(256)
        )
        binding.counterTextView.setTextColor(randomColor)
    }

    private fun switchVisibility() = with(binding.counterTextView) {
        visibility = if (visibility == VISIBLE)
            INVISIBLE
        else
            VISIBLE
    }

}