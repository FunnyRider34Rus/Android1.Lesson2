package com.example.lesson2

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.switchmaterial.SwitchMaterial
import kotlin.properties.Delegates

class SettingsActivity : AppCompatActivity() {

    private companion object {
        const val THEME_MODE: String = "themeMode"
        var themeMode:Boolean = false
        lateinit var data:Intent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        data.getBooleanExtra(THEME_MODE, themeMode)                                                 //получаем текущую тему

        val switchMode:SwitchMaterial = findViewById(R.id.my_switch)

        switchMode.isChecked = themeMode                                                            //устанавливаем свич в текущее положение

        switchMode.setOnCheckedChangeListener { buttonView, isChecked: Boolean ->
            themeMode = isChecked
            data.putExtra(THEME_MODE, themeMode)
            setResult(Activity.RESULT_OK, data)
        }
    }
}
