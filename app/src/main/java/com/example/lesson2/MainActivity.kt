package com.example.lesson2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    private companion object {
        const val NUM1: String = "num1"
        const val NUM2: String = "num2"
        const val IS_DOT: String = "isDot"
        const val LAST_OPERATION: String = "lastOperation"
        const val THEME_MODE: String = "themeMode"
    }

    private var num1: String = ""                           //@param вводимое число
    private var num2: Double = 0.0                          //@param буффурное значение
    private var isDot: Boolean = false                      //@param проверка нажатия точки
    private var lastOperation: String = ""                  //@param вывод знака операции
    private var themeMode: Boolean = false                  //@param определение темы

    //получаем данные от 2ой активити
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            intent?.getBooleanExtra(THEME_MODE, themeMode)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (themeMode) setTheme(R.style.Theme_MaterialComponents_NoActionBar)                       //применяем тему
            else setTheme(R.style.Theme_MaterialComponents_Light_NoActionBar)
        setContentView(R.layout.activity_main)

        val button0: Button = findViewById(R.id.button_0)
        val button1: Button = findViewById(R.id.button_1)
        val button2: Button = findViewById(R.id.button_2)
        val button3: Button = findViewById(R.id.button_3)
        val button4: Button = findViewById(R.id.button_4)
        val button5: Button = findViewById(R.id.button_5)
        val button6: Button = findViewById(R.id.button_6)
        val button7: Button = findViewById(R.id.button_7)
        val button8: Button = findViewById(R.id.button_8)
        val button9: Button = findViewById(R.id.button_9)
        val buttonDot: Button = findViewById(R.id.button_dot)

        val buttonPlus: Button = findViewById(R.id.button_plus)
        val buttonMinus: Button = findViewById(R.id.button_minus)
        val buttonMultiply: Button = findViewById(R.id.button_multiply)
        val buttonDiv: Button = findViewById(R.id.button_division)
        val buttonPlusMinus: Button = findViewById(R.id.button_plus_minus)
        val buttonClear: Button = findViewById(R.id.button_clear)
        val buttonEquals: Button = findViewById(R.id.button_equals)

        val printResult: TextView = findViewById(R.id.print_result)
        val printHistory: TextView = findViewById(R.id.print_history)
        val printOperation: TextView = findViewById(R.id.print_operation)
        val settingsButton: ImageView = findViewById(R.id.settingsButton)

        //восстанавливаем состояние
        if (savedInstanceState != null) {                                                           //восстанавливаем состояние
            num1 = savedInstanceState.getString(NUM1).toString()                                    //при смене кофигурации
            num2 = savedInstanceState.getDouble(NUM2)
            isDot = savedInstanceState.getBoolean(IS_DOT)
            lastOperation = savedInstanceState.getString(LAST_OPERATION).toString()
            themeMode = savedInstanceState.getBoolean(THEME_MODE)
            printResult.text = num1
            printHistory.text = num2.toString()
            printOperation.text = lastOperation
            if (themeMode) setTheme(R.style.Theme_MaterialComponents_NoActionBar)
            else setTheme(R.style.Theme_MaterialComponents_Light_NoActionBar)
            recreate()
        }

        settingsButton.setOnClickListener {                                                  //вызов 2ой активити
            intent.putExtra(THEME_MODE, themeMode)
            startForResult.launch(Intent(this,  SettingsActivity::class.java))
        }

        button0.setOnClickListener {
            if (num1 != "0" && num1 != "") {
                num1 += "0"
            }
            printResult.text = num1
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
            if (lastOperation != "" && num1 != "." && num2 != 0.0) {
                when(lastOperation) {
                    "+" -> num2 += num1.toDouble()
                    "-" -> num2 -= num1.toDouble()
                    "*" -> num2 *= num1.toDouble()
                    "/" -> num2 /= num1.toDouble()
                }
                num1 = ""
                isDot = false
                lastOperation = ""
                printHistory.text = num2.toString()
                printResult.text = "0"
                printOperation.text = lastOperation
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
    override fun onSaveInstanceState(savedInstanceState: Bundle) {                                  //сохраняем переменные для восстановления состояния
        savedInstanceState.putString(NUM1, num1)
        savedInstanceState.putDouble(NUM2, num2)
        savedInstanceState.putBoolean(IS_DOT, isDot)
        savedInstanceState.putString(LAST_OPERATION, lastOperation)
        savedInstanceState.putBoolean(THEME_MODE, themeMode)
        super.onSaveInstanceState(savedInstanceState)
    }
}
