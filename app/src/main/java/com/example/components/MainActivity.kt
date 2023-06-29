package com.example.components

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import android.widget.SeekBar
import android.widget.Toast
import com.example.components.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemSelectedListener,
    SeekBar.OnSeekBarChangeListener,  CompoundButton.OnCheckedChangeListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        // events
        binding.buttonToast.setOnClickListener(this)
        binding.buttonSnack.setOnClickListener(this)

        binding.buttonGetSpinner.setOnClickListener(this)
        binding.buttonSetSpinner.setOnClickListener(this)
        binding.spinnerDinamico.onItemSelectedListener = this

        binding.seekbarProgress.setOnSeekBarChangeListener(this)
        binding.seekbarProgress.progress = 1

        binding.switchExample.setOnCheckedChangeListener(this)
        binding.checkboxExample.setOnCheckedChangeListener(this)
        binding.radioYes.setOnCheckedChangeListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_toast -> {
                val toast = Toast.makeText(this, "Toast", Toast.LENGTH_SHORT)
                toast.show()
            }

            R.id.button_snack -> {
                createSnack()
            }

            R.id.button_Set_spinner -> {
                loadSpinnerDynamic()
            }

            R.id.button_get_spinner -> {
                val value = binding.spinnerDinamico.selectedItem
                val index = binding.spinnerDinamico.selectedItemId
                val positionIndex = binding.spinnerDinamico.selectedItemPosition
            }
        }
    }


    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        when (buttonView.id) {
            R.id.switch_example -> {
                val message = "Switch: $isChecked"
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }

            R.id.checkbox_example -> {
                val message = "Checkbox: $isChecked"
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }

            R.id.radio_yes -> {
                val message = "Radio: $isChecked"
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        Toast.makeText(this, "$position - $id", Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(this, "Nothing", Toast.LENGTH_SHORT).show()
    }

    //seekbar events
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        binding.textSeekValue.text = "$progress - $fromUser"
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        Toast.makeText(this, "Start move", Toast.LENGTH_SHORT).show()
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        Toast.makeText(this, "End move", Toast.LENGTH_SHORT).show()
    }


    private fun createSnack() {
        // Intanciando a Snackbar
        val snack = Snackbar.make(binding.linearMain, "Snack", Snackbar.LENGTH_SHORT)

        // estilizando
        snack.setTextColor(Color.CYAN)
        snack.setBackgroundTint(Color.DKGRAY)

        // adicionando butão de ação
        snack.setAction("Desfazer", View.OnClickListener {
            Snackbar.make(binding.linearMain, "Snack de ação", Snackbar.LENGTH_SHORT).show()
        })

        // estilizando o texto do botão
        snack.setActionTextColor(Color.RED)
        snack.show()
    }

    private fun loadSpinnerDynamic() {
        val list = listOf("alter", "anilha", "barra", "paralela")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list)
        binding.spinnerDinamico.adapter = adapter
    }
}