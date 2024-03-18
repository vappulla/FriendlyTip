package com.example.myapplication

import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    //private lateinit var binding: ActivityMainBinding
    private lateinit var baseAmount: EditText


   private lateinit var textView: TextView
    private lateinit var tipText: TextView
    private lateinit var seekBar: SeekBar
    private lateinit var amountTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main);
        baseAmount = findViewById(R.id.inputDecimal)

        val calButton = findViewById<Button>(R.id.CalculateButton)

        tipText = findViewById(R.id.AmountTip)
        amountTotal = findViewById(R.id.totalPayment)
        textView = findViewById(R.id.textViewtipPercentage)
        seekBar = findViewById(R.id.seekBarTip)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            //binding.seekBarTip.setOnSeekBarChangeListener(OnSeekBarChangeListener)
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textView.text = "$progress %"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        calButton.setOnClickListener {
            calculateTotal()
        }


    }
    private fun calculateTotal() {
        val baseAmount = baseAmount.text.toString().toDoubleOrNull()
        val tipBaseAmount = seekBar.progress

        if (baseAmount != null) {
            val tipAmount = baseAmount * (tipBaseAmount.toDouble() / 100)
            val totalAmount = baseAmount + tipAmount



            tipText.text = "$tipAmount"
            amountTotal.text = "$totalAmount"
        } else {
            tipText.text = "N/A"
            amountTotal.text = "N/A"
        }
    }

}