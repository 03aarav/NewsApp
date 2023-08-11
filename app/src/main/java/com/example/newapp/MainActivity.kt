package com.example.newapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newapp.MyAdapter.Myadapter
import com.example.newapp.MyViewModel.MyViewModel1
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var myViewModel1: MyViewModel1
    lateinit var myadapter: Myadapter
    var selCategory: String = "general"
    var selCVountry: String = "in"
    var inc: Int = 2
    val loading = customDialog(this)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recylerview = findViewById<RecyclerView>(R.id.recyclerView)
        recylerview.layoutManager = LinearLayoutManager(this)

        val refreshbutton = findViewById<ImageView>(R.id.refresh)
        myViewModel1 = ViewModelProvider(this)[MyViewModel1::class.java]

        myViewModel1.RetofitData("in", "sports", 1)



        myViewModel1.NewsLiveData.observe(this) {
            //tv.text = it.toString()
            myadapter = Myadapter(this, it)
            recylerview.adapter = myadapter
        }


        var spinneroption_country = findViewById<Spinner>(R.id.country)
        var spinneroption_category = findViewById<Spinner>(R.id.category)

        var next: TextView = findViewById(R.id.nextTxtBtn)
        var prev: TextView = findViewById(R.id.prevBtn)


        val options = resources.getStringArray(R.array.predefined_options_category)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinneroption_category.adapter = adapter


        val options1 = resources.getStringArray(R.array.predefined_options_country)
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, options1)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinneroption_country.adapter = adapter1


        refreshbutton.setOnClickListener {
            selCategory = spinneroption_category.selectedItem.toString()
            selCVountry = spinneroption_country.selectedItem.toString()
            myViewModel1.RetofitData(selCVountry, selCategory, 1)

        }

        next.setOnClickListener {
         //   loading.dialogRunning()
            myViewModel1.RetofitData(selCVountry, selCategory, inc)
            inc += 1
          //  loading.dialogClose()
        }

        prev.setOnClickListener {
            inc -= 1
            myViewModel1.RetofitData(selCVountry, selCategory, inc)

        }
    }
}