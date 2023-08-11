package com.example.newapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import java.lang.System.load

class NewsActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news2)

        val titlt=findViewById<TextView>(R.id.heading)
        var  imageView=findViewById<ImageView>(R.id.image)
        val desciption=findViewById<TextView>(R.id.description)
        val explore=findViewById<TextView>(R.id.explore)

         var title = intent.getStringExtra("item_title")
         var imageurl=intent.getStringExtra("image")
        var des=intent.getStringExtra("content")
        val url=intent.getStringExtra("url")


        Glide.with(this)
            .load(imageurl)
            .into(imageView)

        titlt.text=title
        desciption.text=des

        explore.text=url

        explore.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)

        }



    }
}