package com.example.components

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import com.example.components.databinding.ActivityTimePickerBinding

class TimePickerActivity : AppCompatActivity(), View.OnClickListener,
    TimePickerDialog.OnTimeSetListener {

    private lateinit var binding: ActivityTimePickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTimePickerBinding.inflate(layoutInflater)

        binding.buttonTimepicker.setOnClickListener(this)

        setContentView(binding.root)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_timepicker) {
            TimePickerDialog(this, this, 22, 30, true).show()
        }
    }

    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        binding.textTimepicker.text = "$hourOfDay : $minute"
    }
}