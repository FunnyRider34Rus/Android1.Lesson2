package com.example.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var num1: String = ""                           //@param вводимое число
    var num2: Double = 0.0                          //@param буффурное значение
    var isDot: Boolean = false                    //@param проверка нажатия точки
    var lastOperation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //восстанавливаем состояние
        //if (savedInstanceState != null) {
        //
        //}

        val button0 = findViewById<Button>(R.id.button_0)
        val button1 = findViewById<Button>(R.id.button_1)
        val button2 = findViewById<Button>(R.id.button_2)
        val button3 = findViewById<Button>(R.id.button_3)
        val button4 = findViewById<Button>(R.id.button_4)
        val button5 = findViewById<Button>(R.id.button_5)
        val button6 = findViewById<Button>(R.id.button_6)
        val button7 = findViewById<Button>(R.id.button_7)
        val button8 = findViewById<Button>(R.id.button_8)
        val button9 = findViewById<Button>(R.id.button_9)
        val buttonDot = findViewById<Button>(R.id.button_dot)

        val buttonPlus = findViewById<Button>(R.id.button_plus)
        val buttonMinus = findViewById<Button>(R.id.button_minus)
        val buttonMultiply = findViewById<Button>(R.id.button_multiply)
        val buttonDiv = findViewById<Button>(R.id.button_division)
        val buttonPlusMinus = findViewById<Button>(R.id.button_plus_minus)
        val buttonClear = findViewById<Button>(R.id.button_clear)
        val buttonEquals = findViewById<Button>(R.id.button_equals)

        val printResult = findViewById<TextView>(R.id.print_result)
        val printHistory = findViewById<TextView>(R.id.print_history)
        val printOperation = findViewById<TextView>(R.id.print_operation)

        button0.setOnClickListener {
            if (num1 != "0" && num1 != "") {
                num1 += "0"
                printResult.text = num1
            }
        }

        button1.setOnClickListener {
            num1 += "1"
            printResult.text = num1
        }

        button2.setOnClickListener {
            num1 += "2"
            printResult.text = num1
        }

        button3.setOnClickListener {
            num1 += "3"
            printResult.text = num1
        }

        button4.setOnClickListener {
            num1 += "4"
            printResult.text = num1
        }

        button5.setOnClickListener {
            num1 += "5"
            printResult.text = num1
        }

        button6.setOnClickListener {
            num1 += "6"
            printResult.text = num1
        }

        button7.setOnClickListener {
            num1 += "7"
            printResult.text = num1
        }

        button8.setOnClickListener {
            num1 += "8"
            printResult.text = num1
        }

        button9.setOnClickListener {
            num1 += "9"
            printResult.text = num1
        }

        buttonClear.setOnClickListener {
            num1 = ""
            num2 = 0.0
            isDot = false
            lastOperation = ""
            printHistory.text = ""
            printResult.text = "0"
            printOperation.text = ""
        }

        buttonDot.setOnClickListener {
            if (!isDot) {
                num1 += "."
                printResult.text = num1
                isDot = true
            }
        }

        buttonEquals.setOnClickListener {
            if (lastOperation != "" && num1 != ".") {
                Log.d("lastOperation", lastOperation)
                if (lastOperation == "+") num2 += num1.toDouble()
                if (lastOperation == "-") num2 -= num1.toDouble()
                if (lastOperation == "*") num2 *= num1.toDouble()
                if (lastOperation == "/") num2 /= num1.toDouble()
                num1 = ""
                isDot = false
                lastOperation = ""
                printHistory.text = num2.toString()
                printResult.text = "0"
            }
        }

        buttonPlus.setOnClickListener {
            if (num1 != "" && num1 != ".") {
                num2 = num1.toDouble()
                lastOperation = "+"
                isDot = false
                num1 = ""
                printHistory.text = num2.toString()
                printResult.text = "0"
                printOperation.text = lastOperation
            }
        }

        buttonMinus.setOnClickListener {
            if (num1 != "" && num1 != ".") {
                num2 = num1.toDouble()
                lastOperation = "-"
                isDot = false
                num1 = ""
                printHistory.text = num2.toString()
                printResult.text = "0"
                printOperation.text = lastOperation
            }
        }

        buttonMultiply.setOnClickListener {
            if (num1 != "" && num1 != ".") {
                num2 = num1.toDouble()
                lastOperation = "*"
                isDot = false
                num1 = ""
                printHistory.text = num2.toString()
                printResult.text = "0"
                printOperation.text = lastOperation
            }
        }

        buttonDiv.setOnClickListener {
            if (num1 != "" && num1 != ".") {
                num2 = num1.toDouble()
                lastOperation = "/"
                isDot = false
                num1 = ""
                printHistory.text = num2.toString()
                printResult.text = "0"
                printOperation.text = lastOperation
            }
        }

        buttonPlusMinus.setOnClickListener {
            if (num1 != "" && num1 != ".") {
                num1 = (num1.toDouble() * -1).toString()
                printResult.text = num1
            }
        }
    }

    //сохранияем переменные
    //override fun onSaveInstanceState(savedInstanceState: Bundle) {
    //    savedInstanceState.putInt()
    //    super.onSaveInstanceState(savedInstanceState)
    //}
}
