package com.test.viewtree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewTreeObserver
import androidx.databinding.DataBindingUtil
import com.test.viewtree.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val mainViewModel by lazy {
        MainViewModel().apply {
            setName("이름 : test123")
            setContract("전화 : 1123 954")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("jppark", "onCreate()")

        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
            .apply {
                lifecycleOwner = this@MainActivity
                mainViewModel = this@MainActivity.mainViewModel

                // Text만 변경되는 것은 호출이 안됨
                // 예) 버튼을 눌러 이름과 전화번호를 교체함
                // onResume 이 끝나고 실행된다.
                // view가 새로 나타낼 때(레이아웃이 변경될 때) 실행된다. 버튼 클릭 시 줄 수가 동일하면 호출되지 않는다.
                txtName.viewTreeObserver.addOnGlobalLayoutListener {
                    Log.d("jppark", "MainView Model -> OnGlobalLayoutListener - $txtName")
                    Log.d("jppark", "width : ${txtName.width}")
                    Log.d("jppark", "height : ${txtName.height}")
                }
            }.run {
                this@MainActivity.mainViewModel.testTextView = txtContract
            }
    }

    override fun onStart() {
        super.onStart()
        Log.d("jppark", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("jppark", "onResume()")
    }
}