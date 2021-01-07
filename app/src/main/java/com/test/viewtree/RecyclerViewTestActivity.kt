package com.test.viewtree

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.test.viewtree.databinding.ActivityRecyclerviewTestBinding

class RecyclerViewTestActivity: AppCompatActivity(R.layout.activity_recyclerview_test) {

    lateinit var recyclerviewTestBinding: ActivityRecyclerviewTestBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        recyclerviewTestBinding = DataBindingUtil.setContentView<ActivityRecyclerviewTestBinding>(this, R.layout.activity_recyclerview_test)
    }

}