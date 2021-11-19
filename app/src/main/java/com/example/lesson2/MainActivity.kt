package com.example.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var num1 = ""
    var num2 = ""
    var operantion = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_0 = findViewById<Button>(R.id.button_0)
        val button_1 = findViewById<Button>(R.id.button_1)
        val button_2 = findViewById<Button>(R.id.button_2)
        val button_3 = findViewById<Button>(R.id.button_3)
        val button_4 = findViewById<Button>(R.id.button_4)
        val button_5 = findViewById<Button>(R.id.button_5)
        val button_6 = findViewById<Button>(R.id.button_6)
        val button_7 = findViewById<Button>(R.id.button_7)
        val button_8 = findViewById<Button>(R.id.button_8)
        val button_9 = findViewById<Button>(R.id.button_9)
        val button_dot = findViewById<Button>(R.id.button_dot)

        val printResult = findViewById<TextView>(R.id.print_result)
        val printHistory = findViewById<TextView>(R.id.print_history)

        button_0.setOnClickListener {
            if (num1 != "0") {
                num1 += "0"
                printResult.text = num1
            }
        }

        button_1.setOnClickListener {
            num1 += "1"
            printResult.text = num1
        }

        button_2.setOnClickListener {
            num1 += "2"
            printResult.text = num1
        }

        button_3.setOnClickListener {
            num1 += "3"
            printResult.text = num1
        }

        button_4.setOnClickListener {
            num1 += "4"
            printResult.text = num1
        }

        button_5.setOnClickListener {
            num1 += "5"
            printResult.text = num1
        }

        button_6.setOnClickListener {
            num1 += "6"
            printResult.text = num1
        }

        button_7.setOnClickListener {
            num1 += "7"
            printResult.text = num1
        }

        button_8.setOnClickListener {
            num1 += "8"
            printResult.text = num1
        }

        button_9.setOnClickListener {
            num1 += "9"
            printResult.text = num1
        }

        button_dot.setOnClickListener {
            num1 += "."
            printResult.text = num1
        }
    }
}
