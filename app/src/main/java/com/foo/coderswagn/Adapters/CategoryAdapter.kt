package com.foo.coderswagn.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.foo.coderswagn.Model.Category
import com.foo.coderswagn.R

/**
 * Created by David Chhetri on 23,November,2021
 */
class CategoryAdapter(val context: Context, val categories: List<Category>): BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View

        val holder : ViewHolder

        if(convertView == null){
            //here we have extracted ImageView and TextView from the layout file
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            holder = ViewHolder()
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById(R.id.categoryName)
            println("I exist for the first time")
            categoryView.tag = holder

        }else{
             holder = convertView.tag as ViewHolder
            categoryView = convertView
            println("Go green recycle!")
        }




        //here we set the image and text that is extracted from the provided List to the
        //ImageView and TextView extracted earlier from layout
        val category = categories[position]
        //get resourceID from name of the image from category list
        val resourceId = context.resources.getIdentifier(category.image, "drawable",context.packageName)
        holder.categoryImage?.setImageResource(resourceId)

        holder.categoryName?.text = category.title

        return  categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return  categories.count()
    }


    private class ViewHolder{
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null

    }


}