package com.ks.coffeeshop.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ks.coffeeshop.Activity.DetailActivity
import com.ks.coffeeshop.Domain.ItemsModel
import com.ks.coffeeshop.databinding.ViewholderPopularBinding

class PopularAdapter(val items: MutableList<ItemsModel>): RecyclerView.Adapter<PopularAdapter.ViewHolder>() {

    lateinit var context: Context
    class ViewHolder(val binding: ViewholderPopularBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding = ViewholderPopularBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.titleTxt.text = items[position].title
        holder.binding.priceTxt.text = "$"+items[position].price.toString()
        holder.binding.subtitleTxt.text = items[position].extra
        Glide.with(context)
            .load(items[position].picUrl[0])
            .into(holder.binding.pic)
        holder.itemView.setOnClickListener{
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("object", items[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = items.size

}