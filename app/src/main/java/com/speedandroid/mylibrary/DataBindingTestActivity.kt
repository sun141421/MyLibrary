package com.speedandroid.mylibrary

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
//import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.speedandroid.mylibrary.databinding.ActivityDataBindingTestBinding

class DataBindingTestActivity : AppCompatActivity() {

//    private val vm by viewModels<DataBindingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        val databind = DataBindingUtil.setContentView<ActivityDataBindingTestBinding>(this, R.layout.activity_data_binding_test)
//        databind.vm = vm

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}