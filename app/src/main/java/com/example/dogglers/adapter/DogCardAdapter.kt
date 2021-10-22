/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.data.DataSource

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    // TODO: Initialize the data using the List found in data/DataSource

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View): RecyclerView.ViewHolder(view) {
        // TODO: Declare and initialize all of the list item UI components
        val imageView1:ImageView = view.findViewById(R.id.kukkur_photo)
        val nameOfDog:TextView = view.findViewById(R.id.nameofKukkur)
        val ageOfDog:TextView = view.findViewById(R.id.ageofkukkur)
        val hobbyOfDog:TextView = view.findViewById(R.id.hobbyofkukkur)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder
    {
        val viewForViewHolder:View
        // TODO: Use a conditional to determine the layout type and set it accordingly.
        //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
        //  the vertical/horizontal list item should be used.
        if(viewType == Layout.GRID)
        {
            viewForViewHolder = LayoutInflater.from(parent.context)
                .inflate(R.layout.grid_list_item,parent,false)
        }
        else
        {
            viewForViewHolder = LayoutInflater.from(parent.context)
                .inflate(R.layout.vertical_horizontal_list_item,parent,false)
        }
        // TODO Inflate the layout

        // TODO: Null should not be passed into the view holder. This should be updated to reflect
        //  the inflated layout.
        return DogCardViewHolder(viewForViewHolder)
    }

    override fun getItemCount(): Int = DataSource.dogs.size// TODO: return the size of the data set instead of 0

    override fun onBindViewHolder(holder: DogCardAdapter.DogCardViewHolder, position: Int)
    {
        // TODO: Get the data at the current position
        val item = DataSource.dogs[position]
        // TODO: Set the image resource for the current dog
        holder.imageView1.setImageResource(item.imageResourceId)
        // TODO: Set the text for the current dog's name
        holder.nameOfDog.setText(item.name)
        holder.ageOfDog.setText(item.age)
        holder.hobbyOfDog.setText(item.hobbies)
        // TODO: Set the text for the current dog's age
        val resources = context?.resources
        // TODO: Set the text for the current dog's hobbies by passing the hobbies to the
        //  R.string.dog_hobbies string constant.
        //  Passing an argument to the string resource looks like:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)
    }
}
