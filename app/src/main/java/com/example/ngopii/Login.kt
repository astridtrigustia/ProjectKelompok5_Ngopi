package com.example.ngopii

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val bar = supportActionBar
        bar!!.title = "Ngopii"
        bar.setDisplayHomeAsUpEnabled(true)

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val button_login = findViewById<Button>(R.id.button_login)
        val to_regis = findViewById<TextView>(R.id.to_regis)

        button_login.setOnClickListener {
            val username = username.text.toString()
            val password = password.text.toString()
            val inten = Intent( this,Daftar_Menu::class.java)

            if (isValidCredentials(username, password)) {
                // Login berhasil, lakukan tindakan sesuai kebutuhan aplikasi
                startActivity(inten)
                Toast.makeText(this, "Anda berhasil login", Toast.LENGTH_SHORT).show()
                }
            else {
                // Login gagal, tampilkan pesan kesalahan
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
            }

        }

        to_regis.setOnClickListener {
            val inten = Intent(this, Register::class.java)
            startActivity(inten)
        }
    }

    private fun isValidCredentials(username: String, password: String): Boolean {
        // Lakukan verifikasi username dan password, contohnya:
        val validUsername = "ngopii"
        val validPassword = "123"

        return username == validUsername && password == validPassword
    }
}
