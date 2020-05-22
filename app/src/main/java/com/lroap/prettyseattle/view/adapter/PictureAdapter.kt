package com.lroap.prettyseattle.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.lroap.prettyseattle.R
import com.lroap.prettyseattle.model.Picture

class PictureAdapter(val pictureListener: PictureListener) : RecyclerView.Adapter<PictureAdapter.ViewHolder>() {

    private var listPicture= ArrayList<Picture>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.item_pictures, parent, false))

    override fun getItemCount() = listPicture.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val picture= listPicture[position]
        holder.tvItemPicturePlace.text = picture.place
        holder.tvItemPictureDescription.text = picture.description

        Glide.with(holder.itemView.context)
            .load(picture.image)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.ivPictureImage)

        holder.itemView.setOnClickListener {
            pictureListener.onPictureClicked(picture, position)
        }
    }

    fun updateData(data: List<Picture>) {
        listPicture.clear()
        listPicture.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvItemPicturePlace = itemView.findViewById<TextView>(R.id.tvItemPicturePlace)
        val tvItemPictureDescription = itemView.findViewById<TextView>(R.id.tvItemPictureDescription)
        val ivPictureImage = itemView.findViewById<ImageView>(R.id.ivItemPictureImage)
    }
}