package com.speedandroid.mylibrary

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun doDpTest(v: View) {
        startActivity(Intent(this, DpTestActivity::class.java))
    }

    fun doBindingTest(v: View) {
        startActivity(Intent(this, DataBindingTestActivity::class.java))
    }

    fun doNetworkTest(view: View) {
        startActivity(Intent(this, NetWorkTestActivity::class.java))
    }
}