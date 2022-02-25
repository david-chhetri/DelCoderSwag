package com.foo.coderswagn.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.foo.coderswagn.Model.Category
import com.foo.coderswagn.R

/**
 * Created by David Chhetri on 25,February,2022
 */
class CategoryRecycleAdapter(context: Context, categories: List<Category>): RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {
    val categories = categories
    val context = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_list_item,parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindCategory(context,categories[position])
    }

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView){
        //get ref to views
        val categoryImage = itemView.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemView.findViewById<TextView>(R.id.categoryName)

        fun bindCategory(context: Context, category: Category){
            val resourceId = context.resources.getIdentifier(category.image,"drawable",context.packageName)
            categoryImage.setImageResource(resourceId)
            categoryName.text = category.title
        }

    }

}