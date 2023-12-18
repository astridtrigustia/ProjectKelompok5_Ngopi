package com.example.ngopii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class Data_Pelanggan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_pelanggan)

        val bar = supportActionBar
        bar!!.title = "Data Pelanggan"
        bar.setDisplayHomeAsUpEnabled(true)
        
        getPelanggan()
    }
    fun getPelanggan(){
        val queue = Volley.newRequestQueue(this)
        val url: String ="http://10.0.2.2/ngopii/index.php?op=pelanggan_view"

        val stringReq = StringRequest(
            Request.Method.GET,url,
            Response.Listener <String>{
                    response ->

                val list : ArrayList<String> = ArrayList()
                val list_pelanggan = findViewById<ListView>(R.id.list_pelanggan)

                val strRespon = response.toString()
                val jsonObjc : JSONObject = JSONObject(strRespon)
                val jsonArray: JSONArray = jsonObjc.getJSONArray("pelanggan")
                var data_pelanggan : String = ""

                for (i in 0 until jsonArray.length()){
                    var jsonInner : JSONObject = jsonArray.getJSONObject(i)
                    data_pelanggan = " "+ jsonInner.get("nama_lengkap")+ "\n"+jsonInner.get("Username_regis")
                    list.add(data_pelanggan)
                }
                list_pelanggan.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)

            }, Response.ErrorListener {  })
        queue.add(stringReq)
    }
}