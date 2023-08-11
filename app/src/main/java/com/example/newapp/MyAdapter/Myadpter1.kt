package com.example.newapp.MyAdapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newapp.Model.Article
import com.example.newapp.NewsActivity2
import com.example.newapp.R
import kotlin.properties.Delegates
//


class Myadapter(private val context: Context, private val Newslist: List<Article>?) : RecyclerView.Adapter<Myadapter.ItemViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.eachblock, parent, false)
            return ItemViewHolder(view)
        }

        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            val item = Newslist?.get(position)
           // holder.bind(item)
            holder.textview.text=item?.title
            var image=holder.imageView
            Glide.with(holder.imageView)
                .load(item?.urlToImage)
                .into(image)
            holder.heading=item?.title.toString()
            holder.description=item?.description.toString()
            holder.explore=item?.url.toString()



        }

        override fun getItemCount(): Int {
            return Newslist!!.size
        }

        inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
             var textview: TextView
             var imageView: ImageView
          lateinit var heading:String
          lateinit var description:String
          lateinit var explore:String
            //lateinit var image1:ImageView


            init {
                textview = itemView.findViewById(R.id.Textview)
                imageView = itemView.findViewById(R.id.imageview)



                textview.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        val clickedItem = Newslist?.get(position)

                        // Start the new activity with the necessary data
                        val context = itemView.context
                        val intent = Intent(context, NewsActivity2::class.java)
                        intent.putExtra("item_title", clickedItem?.title)
                        intent.putExtra("Decrption", clickedItem?.description)
                        intent.putExtra("image",clickedItem?.urlToImage)
                        intent.putExtra("content",clickedItem?.content)
                        intent.putExtra("url",clickedItem?.url)
                        context.startActivity(intent)
                    }
                }
            }
        }
    }


//init {
//    textview = itemView.findViewById(R.id.Textview)
//    imageView = itemView.findViewById(R.id.imageview)
//
//    // Set click listener for itemView (root view of each item)
//    itemView.setOnClickListener {
//        val position = adapterPosition
//        if (position != RecyclerView.NO_POSITION) {
//            val clickedItem = Newslist?.get(position)
//
//            // Start the new activity with the necessary data
//            val context = itemView.context
//            val intent = Intent(context, NewsActivity2::class.java)
//            intent.putExtra("item_title", clickedItem?.title)
//            intent.putExtra("Decrption", clickedItem?.description)
//            context.startActivity(intent)
//        }
//    }
//}
//}
//
//Now the onClick method is correctly placed inside the ItemViewHolder class and set as a click listener on the itemView. This should resolve the error, and clicking on an item in the RecyclerView should navigate to NewsActivity2 with the necessary data.


