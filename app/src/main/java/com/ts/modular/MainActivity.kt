package com.ts.modular

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.ts.base.ModuleMediator

class MainActivity : AppCompatActivity() {

    private val btnMessage: AppCompatButton by lazy { findViewById(R.id.btn_message) }
    private val btnSetting: AppCompatButton by lazy { findViewById(R.id.btn_setting) }
    private val btnVideo: AppCompatButton by lazy { findViewById(R.id.btn_video) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMessage.setOnClickListener {
            startActivity(ModuleMediator.CLASS_NAME_MESSAGE)
        }

        btnSetting.setOnClickListener {
            startActivity(ModuleMediator.CLASS_NAME_SETTING)
        }

        btnVideo.setOnClickListener {
            startActivity(ModuleMediator.CLASS_NAME_VIDEO)
        }
    }

    private fun startActivity(className: String, bundle: Bundle? = null) {
        try {
            var classForName = Class.forName(className)
            var intent = Intent(this@MainActivity, classForName)
            bundle?.let {
                intent.putExtras(it)
            }
            startActivity(intent)
        } catch (e: ClassNotFoundException) {
            Toast.makeText(this@MainActivity, e.message + "没有找到", Toast.LENGTH_SHORT).show()
        }
    }
}