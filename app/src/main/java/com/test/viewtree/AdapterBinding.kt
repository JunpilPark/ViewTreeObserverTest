package com.test.viewtree

import android.util.Log
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("app:nameProperty", "app:contractProperty")
fun setAdapterBind(view: TextView, name: String, contract: String) {
    Log.d("jppark", "setAdapterBind() 실행 -> $view")
    view.viewTreeObserver.addOnGlobalLayoutListener {
        Log.d("jppark", "setAdapterBind() ->  OnGlobalLayoutListener")
    }
    view.text = "$name, $contract"
}