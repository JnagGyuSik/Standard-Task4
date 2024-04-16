package com.example.standard_task4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.standard_task4.databinding.ItemBinding
import java.text.DecimalFormat

class Adapter(val myItem: MutableList<Data>) : RecyclerView.Adapter<Adapter.Holder>(){

    interface ItemClick{
        fun onClick(view : View, position: Int)
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.Holder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Adapter.Holder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it,position)
        }
        holder.backGround.setBackgroundResource(R.drawable.radius)
        holder.backGround.setBackgroundResource(myItem[position].backGroundColor)
        holder.cardNumber.text = myItem[position].cardNumber

        holder.cardDate.text = myItem[position].cardDate

        val dec = DecimalFormat("#,###.00") //숫자 포맷 변경
        val priceFormat = myItem[position].cardBalance
        holder.cardBalance.text = "$" + dec.format(priceFormat)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return myItem.size
    }

    inner class Holder(binding: ItemBinding): RecyclerView.ViewHolder(binding.root){
        var backGround = binding.postImage
        var cardNumber = binding.cardNumber
        var cardDate = binding.cardDate
        var cardBalance = binding.cardBalance
    }
}