package com.speedandroid.mylibrary

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.postDelayed
import androidx.core.view.updateLayoutParams
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.speedandroid.mylibrary.databinding.ActivityDpTestBinding
import com.speedandroid.speedcodelibrary.ext.dp
import com.speedandroid.speedcodelibrary.ext.sp
import com.speedandroid.speedcodelibrary.glidetarget.CompoundDrawableTarget
import com.speedandroid.speedcodelibrary.glidetarget.into
import com.speedandroid.speedcodelibrary.glidetarget.intoBg

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
        Glide.with(this).load("https://placehold.jp/350x350.png").into(viewBinding.tvTest, CompoundDrawableTarget.LEFT, 12.dp, 12.dp)

        Glide.with(this).load("https://placehold.jp/350x150.png").fitCenter().intoBg(viewBinding.flTest)

        val bean = Gson().fromJson(Test_JSON, Int2BooleanBean::class.java)
        Log.d("test", "bean isFree: ${bean.isFree}")

        val toJsonStr = Gson().toJson(bean)

        Log.d("test", "bean to json: $toJsonStr")

        viewBinding.tvTest.setOnClickListener { v ->
            v.isClickable = false
            v.postDelayed(1000) { v.isClickable = true }
            Log.d("test", "onClick V")
        }

    }
}