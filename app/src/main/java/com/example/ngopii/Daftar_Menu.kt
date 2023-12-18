package com.example.ngopii

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast

class Daftar_Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_menu)

        val bar = supportActionBar
        bar!!.title = "DAFTAR MENU Ngopii"
        bar.setDisplayHomeAsUpEnabled(true)

        var listView = findViewById<ListView>(R.id.listview)
        val cari_menu = findViewById<SearchView>(R.id.cari_menu)
        var list = mutableListOf<List_Menu>()

        list.add(List_Menu("Kopi Susu", "Rp 15.000", R.drawable.kopisusu, 4.0))
        list.add(List_Menu("Kopi Pandan", "Rp 20.000", R.drawable.kopipandan, 3.5))
        list.add(List_Menu("Kopi Milo", "Rp 18.000", R.drawable.kopimilo, 4.0))
        list.add(List_Menu("Hazelnut Latte", "Rp 20.000", R.drawable.hazelnut, 4.5))
        list.add(List_Menu("Caramel Latte", "Rp 20.000", R.drawable.caramel, 5.0))
        list.add(List_Menu("Vanila Latte", "Rp 20.000", R.drawable.vanila, 4.5))
        list.add(List_Menu("Latte", "Rp 18.000", R.drawable.latte, 5.0))
        list.add(List_Menu("Americano", "Rp 12.000", R.drawable.americano, 4.0))
        list.add(List_Menu("Mochacino", "Rp 20.000", R.drawable.mochacino, 4.0))
        list.add(List_Menu("Matcha", "Rp20.000", R.drawable.matcha, 4.5))

        listView.adapter = List_MenuAdapter(this, R.layout.activity_listview, list)

//        listView.setOnItemClickListener { adapterView, view, i, l ->
//            when (i) {
//                0 -> Toast.makeText(this, "Kamu memilih Kopi Susu", Toast.LENGTH_LONG).show()
//                1 -> Toast.makeText(this, "Kamu memilih Kopi Pandan", Toast.LENGTH_LONG).show()
//                2 -> Toast.makeText(this, "Kamu memilih Kopi Milo", Toast.LENGTH_LONG).show()
//                3 -> Toast.makeText(this, "Kamu memilih Hazelnut Latte", Toast.LENGTH_LONG).show()
//                4 -> Toast.makeText(this, "Kamu memilih Caramel Latte", Toast.LENGTH_LONG).show()
//                5 -> Toast.makeText(this, "Kamu memilih Vanila Latte", Toast.LENGTH_LONG).show()
//                6 -> Toast.makeText(this, "Kamu memilih Latte", Toast.LENGTH_LONG).show()
//                7 -> Toast.makeText(this, "Kamu memilih Americano", Toast.LENGTH_LONG).show()
//                8 -> Toast.makeText(this, "Kamu memilih Mochacino", Toast.LENGTH_LONG).show()
//                9 -> Toast.makeText(this, "Kamu memilih Matcha", Toast.LENGTH_LONG).show()
//            }
//        }

        listView.setOnItemClickListener { adapterView, view, i, l ->
            when (i) {
                0 -> {
                    val inten = Intent( this,KopiSusu::class.java)
                    startActivity(inten)
                    Toast.makeText(this, "Kamu memilih Kopi Susu", Toast.LENGTH_LONG).show()
                }
                1 -> {
                    val inten = Intent( this,KopiPandan::class.java)
                    startActivity(inten)
                    Toast.makeText(this, "Kamu memilih Kopi Pandan", Toast.LENGTH_LONG).show()
                }
                2 -> {
                    val inten = Intent( this,KopiMilo::class.java)
                    startActivity(inten)
                    Toast.makeText(this, "Kamu memilih Kopi Milo", Toast.LENGTH_LONG).show()
                }
                3 -> {
                    val inten = Intent( this,HazelnutLatte::class.java)
                    startActivity(inten)
                    Toast.makeText(this, "Kamu memilih Hazelnut Latte", Toast.LENGTH_LONG).show()
                }
                4 -> {
                    val inten = Intent( this,CaramelLatte::class.java)
                    startActivity(inten)
                    Toast.makeText(this, "Kamu memilih Caramel Latte", Toast.LENGTH_LONG).show()
                }
                5 -> {
                    val inten = Intent( this,VanilaLatte::class.java)
                    startActivity(inten)
                    Toast.makeText(this, "Kamu memilih Vanila Latte", Toast.LENGTH_LONG).show()
                }
                6 -> {
                    val inten = Intent( this,Latte::class.java)
                    startActivity(inten)
                    Toast.makeText(this, "Kamu memilih Latte", Toast.LENGTH_LONG).show()
                }
                7 -> {
                    val inten = Intent( this,Americano::class.java)
                    startActivity(inten)
                    Toast.makeText(this, "Kamu memilih Americano", Toast.LENGTH_LONG).show()
                }
                8 -> {
                    val inten = Intent( this,Mochacino::class.java)
                    startActivity(inten)
                    Toast.makeText(this, "Kamu memilih Mochacino", Toast.LENGTH_LONG).show()
                }
                9 -> {
                    val inten = Intent( this,Matcha::class.java)
                    startActivity(inten)
                    Toast.makeText(this, "Kamu memilih Matcha", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}