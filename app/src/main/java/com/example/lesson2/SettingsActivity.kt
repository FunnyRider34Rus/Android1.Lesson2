package com.example.lesson2

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.switchmaterial.SwitchMaterial

class SettingsActivity : AppCompatActivity() {

    private companion object {
        const val THEME_MODE: String = "themeMode"
        var themeMode: Boolean = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val switchMode:SwitchMaterial = findViewById(R.id.my_switch)

        if (savedInstanceState != null) {
            when (Configuration.UI_MODE_NIGHT_MASK) {
                Configuration.UI_MODE_NIGHT_NO -> {
                    themeMode = false
                    switchMode.isChecked = themeMode
                }
                Configuration.UI_MODE_NIGHT_YES -> {
                    themeMode = true
                    switchMode.isChecked = themeMode
                }
            }
        }

        switchMode.setOnCheckedChangeListener { buttonView, isChecked: Boolean ->
            themeMode = isChecked
            lateinit var data:Intent
            data.putExtra(THEME_MODE, themeMode)
            setResult(Activity.RESULT_OK, data)
        }
    }

    /*override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putBoolean(THEME_MODE, themeMode)
        super.onSaveInstanceState(savedInstanceState)
    }*/

}
