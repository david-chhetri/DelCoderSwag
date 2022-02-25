package com.foo.coderswagn.Controller

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.foo.coderswagn.Adapters.ProductsAdapter
import com.foo.coderswagn.R
import com.foo.coderswagn.Services.DataService
import com.foo.coderswagn.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {
    lateinit var productAdapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)

        productAdapter = ProductsAdapter(this, DataService.getProducts(categoryType))
        var spanCount = 2
        val orientation = resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            spanCount = 4
        }

        val screenSize = resources.configuration.screenWidthDp
        if (screenSize > 720){
            spanCount = 3
            if(orientation == Configuration.ORIENTATION_LANDSCAPE){
                spanCount = 6
            }
        }

        val layoutManager = GridLayoutManager(this, spanCount)
        productListView1.layoutManager = layoutManager
        productListView1.adapter = productAdapter

    }

}