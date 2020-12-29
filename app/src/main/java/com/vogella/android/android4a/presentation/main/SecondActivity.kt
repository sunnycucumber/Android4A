package com.vogella.android.android4a.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.vogella.android.android4a.ExampleAdapter
import com.vogella.android.android4a.Exampleitem
import com.vogella.android.android4a.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


    val exampleList = generateDummyList(500)

    recycler_view.adapter = ExampleAdapter(exampleList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
}
    private fun generateDummyList(size: Int): List<Exampleitem> {
        val list = ArrayList<Exampleitem>()

        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_accessible
                1 -> R.drawable.ic_baseline
                else -> R.drawable.ic_wc
            }
            val item=Exampleitem(drawable, "Title $i", "blabla")
            list += item
        }
        return list
    }


}