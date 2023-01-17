package com.example.lab5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var  slider: SeekBar
    private lateinit var  value: TextView
    private lateinit var  button: Button
    private lateinit var clock: TextView
    private lateinit var clockValue: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        slider = findViewById(R.id.seekbar)
        value = findViewById(R.id.volume)
        button = findViewById(R.id.res_button)
        clock = findViewById(R.id.clock)
        clockValue = findViewById(R.id.clockValue)

        slider.max = 100 // Default is 100
        slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                value.text = slider.progress.toString()+"%"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                value.text = slider.progress.toString()+"%"
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                value.text = slider.progress.toString()+"%"
            }
        })

        button.setOnClickListener {
            val num: Int? = clockValue.text.toString().toIntOrNull()
            val slider = slider.progress.toString()

            if (clockValue.text.toString() == "") {
                Toast.makeText(applicationContext, R.string.message, Toast.LENGTH_LONG).show()
            } else {
                if (num == null) {
                    Toast.makeText(applicationContext, R.string.message2, Toast.LENGTH_LONG).show()
                } else {
                    if ((slider.toInt()) !== 0)
                    {
                        val sumnoj = num * 2000 - ((slider.toInt()) * 0.01 * num * 2000 );
                        Toast.makeText(applicationContext, sumnoj.toString(), Toast.LENGTH_LONG).show()
                    } else {
                        val sumnoj = num * 2000
                        Toast.makeText(applicationContext, sumnoj.toString(), Toast.LENGTH_LONG).show()
                    }
                }

            }
        }
    }

}
