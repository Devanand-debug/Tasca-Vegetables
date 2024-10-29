package com.devanand.tascavegetables.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devanand.tascavegetables.R
import com.devanand.tascavegetables.model.Vegetables

class VegetablesAdapter(private val vegetableItems : List<Vegetables>) : RecyclerView.Adapter<VegetablesAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val imgView: ImageView = itemView.findViewById(R.id.imgVeg)
        val tvVegNames: TextView = itemView.findViewById(R.id.tvVegName)
        val tvPrices: TextView = itemView.findViewById(R.id.tvPrice)
        val btnAddToCart: Button = itemView.findViewById(R.id.btnAddToCart)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VegetablesAdapter.MyViewHolder {

        val itemView =LayoutInflater.from(parent.context).inflate(R.layout.vegetable_item_view,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VegetablesAdapter.MyViewHolder, position: Int) {

        val vegetable = vegetableItems[position]

        holder.imgView.setImageResource(vegetable.imgResId)
        holder.tvVegNames.text = vegetable.vegName
        holder.tvPrices.text = vegetable.vegPrice
    }

    override fun getItemCount(): Int {
        return vegetableItems.size
    }

}