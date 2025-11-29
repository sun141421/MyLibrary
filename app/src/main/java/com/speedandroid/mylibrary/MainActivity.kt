package com.speedandroid.mylibrary

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.speedandroid.speedcodelibrary.widget.SkipCallCheckBox

class MainActivity : AppCompatActivity() {
    private var mcb: SkipCallCheckBox?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mcb = findViewById(R.id.mcb1)
        mcb?.setOnCheckedChangeListener { _, _ ->
            Log.d("test", "setOnCheckedChangeListener")
        }
    }

    fun doDpTest(v: View) {
        startActivity(Intent(this, DpTestActivity::class.java))
        mcb?.setCheckedSkipCall(true)
    }

    fun doBindingTest(v: View) {
        startActivity(Intent(this, DataBindingTestActivity::class.java))
    }

    fun doNetworkTest(view: View) {
        startActivity(Intent(this, NetWorkTestActivity::class.java))
    }
}