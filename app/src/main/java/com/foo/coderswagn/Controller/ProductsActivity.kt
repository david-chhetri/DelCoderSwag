package com.foo.coderswagn.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.foo.coderswagn.R
import com.foo.coderswagn.Utilities.EXTRA_CATEGORY

class ProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        println("dave ${categoryType}")

    }
}
