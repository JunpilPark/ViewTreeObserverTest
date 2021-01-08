package com.test.viewtree

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel {
    private val _name = MutableLiveData<String>()
    private val _contract = MutableLiveData<String>()

    val name: LiveData<String> = _name
    val contract: LiveData<String> = _contract

    fun setName(name: String) {
        _name.value = name
    }

    fun setContract(contract: String) {
        _contract.value = contract
    }

    var count = 0
    fun onClickChangeTexts() {
        if(count == 0) {
            _name.value = "test"
            _contract.value = "test"
            count++
            return
        }

        if(count == 1) {
            _name.value = "test 12222323213123123123123123123123123123123123123123123123123123123123123"
            _contract.value = "test"
            count++
            return
        }

        if(count == 2) {
            if(::testTextView.isInitialized) {
                Log.d("jppark", "텍스트 뷰를 invalidate 시켰습니다.")
                testTextView.invalidate()
            }
            count = 0
            return
        }
    }

    lateinit var testTextView: TextView
    fun setTextView(textView: TextView) {
        testTextView = textView
    }

    fun onClickOpenOtherActivity(context: Context) {
        val i = Intent(context, RecyclerViewTestActivity::class.java)
        context.startActivity(i)
    }
}