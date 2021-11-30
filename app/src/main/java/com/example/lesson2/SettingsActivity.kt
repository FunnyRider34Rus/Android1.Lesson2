package com.example.lesson2

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.switchmaterial.SwitchMaterial

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val switchMode:SwitchMaterial = findViewById(R.id.my_switch)
        var themeMode:Boolean

        switchMode.setOnCheckedChangeListener { buttonView, isChecked ->
            themeMode = isChecked
        }

        //определяем текущую тему
        when (Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_NO -> {
            }
            Configuration.UI_MODE_NIGHT_YES -> {
            }
        }
    }
}
