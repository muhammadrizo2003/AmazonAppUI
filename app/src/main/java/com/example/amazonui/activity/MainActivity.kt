package com.example.amazonui.activity

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.amazonui.R
import com.example.amazonui.adapter.FavoriteAdapter
import com.example.amazonui.model.Essential

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutFashion: LinearLayout
    private lateinit var linearLayoutPopular: LinearLayout
    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        context = this

        recyclerView = findViewById(R.id.recycler_view_essential)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager

        linearLayoutFashion = findViewById(R.id.ll_fashion)
        linearLayoutPopular = findViewById(R.id.ll_popular)

        refreshAdapter(prepareFavorites())

        //   setLinearHeight(linearLayoutFashion)
        //   setLinearHeight(linearLayoutPopular)
    }

    private fun setLinearHeight(layout: LinearLayout) {

        // get screen width programmatically
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val widthPixels = displayMetrics.widthPixels

//        // Change pixel to dp
//        val heightInDp: Int = heightPixels / resources.displayMetrics.density.toInt()

        // set layout width programmatically
        val params: ViewGroup.LayoutParams = layout.layoutParams
        params.height = widthPixels
        layout.layoutParams = params
    }

    private fun refreshAdapter(list: ArrayList<Essential>) {
        val adapter = FavoriteAdapter(context, list)
        recyclerView.adapter = adapter
    }

    private fun prepareFavorites(): ArrayList<Essential> {
        val list = ArrayList<Essential>()
        for (i in 1..5) {
            list.add(Essential("oculus", R.drawable.im_fashion_1))
            list.add(Essential("oculus", R.drawable.im_fashion_2))
            list.add(Essential("oculus", R.drawable.im_fashion_3))
            list.add(Essential("oculus", R.drawable.im_fashion_4))
            list.add(Essential("oculus", R.drawable.im_fashion_5))
        }
        list.shuffle()
        return list
    }
}


