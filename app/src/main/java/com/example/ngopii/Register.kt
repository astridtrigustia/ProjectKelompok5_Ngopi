package com.example.ngopii

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import org.json.JSONException
import org.json.JSONObject
import kotlin.jvm.Throws

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val bar = supportActionBar
        bar!!.title = "Register"
        bar.setDisplayHomeAsUpEnabled(true)

        val nama_lengkap = findViewById<EditText>(R.id.nama_lengkap)
        val username_regis = findViewById<EditText>(R.id.username_regis)
        val password_regis = findViewById<EditText>(R.id.password_regis)
        val no_hp = findViewById<EditText>(R.id.no_hp)
        val jk_laki = findViewById<RadioButton>(R.id.r_laki_laki)
        val jk_perempuan = findViewById<RadioButton>(R.id.r_perempuan)
        var jenis_kelamin = " "
        val group_jk = findViewById<RadioGroup>(R.id.group_jk)
        val alamat = findViewById<EditText>(R.id.alamat)

        group_jk.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.r_laki_laki) {
                jenis_kelamin = " Laki - Laki "
            } else if (checkedId == R.id.r_perempuan) {
                jenis_kelamin = " Perempuan "
            } else {
                jenis_kelamin = " Jenis Kelamin tidak dipilih"
            }
        }

        val button_register = findViewById<Button>(R.id.button_register)
        val hasil_register = findViewById<TextView>(R.id.hasil_register)

        button_register.setOnClickListener {
            Toast.makeText(this, "Anda berhasil registrasi", Toast.LENGTH_SHORT).show()

            val inten = Intent( this,Login::class.java)
            startActivity(inten)

            hasil_register.text = "Nama : " + nama_lengkap.text + "\n Username :" + username_regis.text + "\n No. Handphone : " + no_hp.text + "\n Jenis Kelamin : " + jenis_kelamin + "\n Alamat : " + alamat.text

            // proses untuk simpan ke database server
            val BASE_URL = "http://10.0.2.2/ngopii/index.php?op="
            val ACTION = BASE_URL + "pelanggan_create" +
                    "&namaPelanggan=${nama_lengkap.text}" +
                    "&username=${username_regis.text}" +
                    "&password=${password_regis.text}" +
                    "&no_hp=${no_hp.text}" +
                    "&jenis_kelamin=$jenis_kelamin" +
                    "&alamat=${alamat.text}"
            Log.e("Paramater : ", ACTION)

            val stringRequest = object : StringRequest(
                Request.Method.GET, ACTION,
                Response.Listener<String> { response ->
                    try {
                        val obj = JSONObject(response)
                        Log.i("hasil", obj.getString("message"))
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                },
                object : Response.ErrorListener {
                    override fun onErrorResponse(error: VolleyError?) {
                        TODO("Not yet implemented")
                        Log.e(
                            "hasil : ", error!!.message.toString()
                        )
                    }
                }) {
                @Throws(AuthFailureError::class)
                override fun getParams(): MutableMap<String, String> {
                    val params = HashMap<String, String>()

                    return params
                }
            }
            Sender.instance!!.addToRequestQueue(stringRequest)
        }
    }
}