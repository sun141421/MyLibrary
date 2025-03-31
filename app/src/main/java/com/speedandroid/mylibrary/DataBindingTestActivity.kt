package com.speedandroid.mylibrary

//import androidx.activity.viewModels
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.speedandroid.mylibrary.databinding.ActivityDataBindingTestBinding

class DataBindingTestActivity : AppCompatActivity() {

    private val vm by viewModels <DataBindingViewModel>()
    private val viewBinding by lazy { ActivityDataBindingTestBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(viewBinding.root)
//        val databind = DataBindingUtil.setContentView<ActivityDataBindingTestBinding>(this, R.layout.activity_data_binding_test)
//        databind.vm = vm

    }


}