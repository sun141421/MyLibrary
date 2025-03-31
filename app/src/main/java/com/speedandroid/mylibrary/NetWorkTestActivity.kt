package com.speedandroid.mylibrary

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class NetWorkTestActivity : AppCompatActivity() {
    private val vm by viewModels<NetWorkTestViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_network_test)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        lifecycleScope.launch {
            vm.stateFlow.flowWithLifecycle(lifecycle).collect{
                findViewById<TextView>(R.id.tv).text = it.joinToString ("\n\n")
            }
        }
    }

    fun doTestGet(view: View) {
        vm.getContent()
    }

    fun doTestPost(view: View) {

    }


}