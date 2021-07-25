package com.example.checkmyvaccine

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest

class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter: VaccineAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView=findViewById<RecyclerView>(R.id.recycleview)
        val items=fetchdata()
        recyclerView.layoutManager=LinearLayoutManager(this)
        fetchdata()
         mAdapter = VaccineAdapter()
       recyclerView.adapter = mAdapter
    }











    private fun fetchdata()
    {

        val url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode=273001&date=25-07-2021"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            Response.Listener {
                val newsJsonArray = it.getJSONArray("sessions")
                val newsArray = ArrayList<Vaccine>()
                for(i in 0 until newsJsonArray.length()) {
                    val newsJsonObject = newsJsonArray.getJSONObject(i)
                    val news = Vaccine(
                        newsJsonObject.getString("name"),
                        newsJsonObject.getString("address"),
                        newsJsonObject.getString("from"),
                        newsJsonObject.getString("to"),
                        newsJsonObject.getString("fee_type"),
                        newsJsonObject.getString("available_capacity"),
                        newsJsonObject.getString("min_age_limit"),
                        newsJsonObject.getString("vaccine")
                    )
                    newsArray.add(news)
                }

                mAdapter.updateNews(newsArray)
            },
            Response.ErrorListener {

            }
        )
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)



    }

}