package com.example.lapsfinal

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.lapsfinal.R

class MenuActivity : AppCompatActivity() {
    lateinit var ButtonUpload : Button
    lateinit var programmingLanguagesLV: ListView
    lateinit var listAdapter: ArrayAdapter<String>
    lateinit var programmingLanguagesList: ArrayList<String>;
    lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)



        ButtonUpload=findViewById(R.id.button_camera)

        ButtonUpload!!.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivityForResult(takePictureIntent,1)
        }


        programmingLanguagesLV = findViewById(R.id.idLVClothingtypes)
        searchView = findViewById(R.id.idSV)


        programmingLanguagesList = ArrayList()
        programmingLanguagesList.add("Pants")
        programmingLanguagesList.add("Sweaters")
        programmingLanguagesList.add("Coats")
        programmingLanguagesList.add("Traditional wear")
        programmingLanguagesList.add("Shirts")
        programmingLanguagesList.add("Cocktail dresses")
        programmingLanguagesList.add("Corsets")
        programmingLanguagesList.add("Others")


        listAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            programmingLanguagesList
        )


        programmingLanguagesLV.adapter = listAdapter


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                if (programmingLanguagesList.contains(query)) {

                    listAdapter.filter.filter(query)
                } else {

                    Toast.makeText(this@MenuActivity, "No Language found..", Toast.LENGTH_LONG)
                        .show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                listAdapter.filter.filter(newText)
                return false
            }
        } )

        val mList = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",)

        val mListView = findViewById<ListView>(R.id.list_view)
        val mTextView: ListView = findViewById<ListView>(R.id.idLVClothingtypes)
        val mAdapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, mList)

        mListView.adapter = mAdapter

        mListView.setOnScrollListener(object : AbsListView.OnScrollListener{
            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {

            }

            private var lastFirstVisibleItem = 0

            override fun onScroll(view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {

                lastFirstVisibleItem = firstVisibleItem
            }})}}



