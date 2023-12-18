package com.example.ngopii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Activity_tiga : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiga)

        val bar = supportActionBar
        bar!!.title = "MENU Ngopii"
        bar.setDisplayHomeAsUpEnabled(true)

        val pesanan = findViewById<Spinner>(R.id.combo_pesanan)
        val nama = findViewById<TextView>(R.id.no_hp)
        val j_ice = findViewById<RadioButton>(R.id.r_ice)
        val j_hot = findViewById<RadioButton>(R.id.r_hot)
        var jenis = " "

        val group_jenis = findViewById<RadioGroup>(R.id.group_jenis)

        group_jenis.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.r_ice) {
                jenis = " Ice "
            } else if (checkedId == R.id.r_hot) {
                jenis = " Hot "
            } else {
                jenis = " Jenis tidak dipilih"
            }
        }

        val tombol_pesan = findViewById<Button>(R.id.tombol_pesan)
        val hasil_pesanan = findViewById<TextView>(R.id.hasil_pesanan)

        tombol_pesan.setOnClickListener {
            Toast.makeText( this, "Pesan", Toast.LENGTH_LONG).show();
            //merubah text ketika button di klik
            hasil_pesanan.text = " Nama : "+nama.text+"\n Pesanan : "+pesanan.selectedItem+"\n Jenis :"+jenis;
        }


    }
}