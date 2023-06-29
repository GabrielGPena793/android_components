package com.example.components

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import com.example.components.databinding.ActivityTimePickerBinding
import java.util.Calendar

class TimePickerActivity : AppCompatActivity(), View.OnClickListener,
    TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    private lateinit var binding: ActivityTimePickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTimePickerBinding.inflate(layoutInflater)

        binding.buttonTimepicker.setOnClickListener(this)
        binding.buttonDatepicker.setOnClickListener(this)

        setContentView(binding.root)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.button_timepicker ->  {
                TimePickerDialog(this, this, 22, 30, true).show()
            }

            R.id.button_datepicker -> {
                val date = Calendar.getInstance()
                val day = date.get(Calendar.DAY_OF_MONTH)
                val month = date.get(Calendar.MONTH)
                val year = date.get(Calendar.YEAR)

                DatePickerDialog(this, this, year, month, day).show()
            }
        }
    }

    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        binding.textTimepicker.text = "$hourOfDay : $minute"
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, dayOfMonth: Int) {
        binding.textDatepicker.text = "$dayOfMonth/${month + 1}/$year"
    }
}