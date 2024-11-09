package com.speedandroid.mylibrary

import android.os.Bundle
import android.util.TypedValue
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.databinding.DataBindingUtil
import com.speedandroid.mylibrary.databinding.ActivityDpTestBinding
import com.speedandroid.speedcodelibrary.ext.dp
import com.speedandroid.speedcodelibrary.ext.sp

class DpTestActivity : AppCompatActivity() {
    private val viewBinding by lazy { ActivityDpTestBinding.bind(findViewById(R.id.main)) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dp_test)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        doTest()
    }

    private fun doTest() {
        viewBinding.tvTest.setTextSize(TypedValue.COMPLEX_UNIT_PX, 18.sp.toFloat())

        viewBinding.tvTest.updateLayoutParams {
            height = 50.dp
            width = 120.dp
        }
    }
}