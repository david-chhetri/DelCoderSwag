package com.foo.coderswagn.Controller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.foo.coderswagn.Adapters.CategoryRecycleAdapter
import com.foo.coderswagn.R
import com.foo.coderswagn.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //lateinit var adapter : CategoryRecycleAdapter

    lateinit var adapter: CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories)
        categoryListView1.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        categoryListView1.layoutManager = layoutManager
        categoryListView1.setHasFixedSize(true)


    }
}
