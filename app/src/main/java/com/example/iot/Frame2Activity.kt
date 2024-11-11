package com.example.iot

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Frame2Activity : AppCompatActivity() {

    private lateinit var tvDataCuaca: TextView
    private lateinit var btnLoadSuhu: Button
    private lateinit var btnBackToFrame1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame2)

        tvDataCuaca = findViewById(R.id.tvDataCuaca)
        btnLoadSuhu = findViewById(R.id.btnLoadSuhu)
        btnBackToFrame1 = findViewById(R.id.btnBackToFrame1)  // Inisialisasi tombol Back

        // Saat tombol Load Suhu ditekan, panggil API untuk mendapatkan data
        btnLoadSuhu.setOnClickListener {
            fetchData()
        }

        // Saat tombol Back ditekan, kembali ke Frame1Activity
        btnBackToFrame1.setOnClickListener {
            val intent = Intent(this@Frame2Activity, MainActivity::class.java)
            startActivity(intent)
            finish()  // Mengakhiri Frame2Activity agar tidak kembali ke sini saat tombol back ditekan
        }
    }

    private fun fetchData() {
        val apiInterface = ApiClient.getRetrofitInstance().create(ApiInterface::class.java)
        val call: Call<List<DataCuaca>> = apiInterface.getDataCuaca()

        call.enqueue(object : Callback<List<DataCuaca>> {
            override fun onResponse(call: Call<List<DataCuaca>>, response: Response<List<DataCuaca>>) {
                if (response.isSuccessful && response.body() != null) {
                    val data = response.body()!![0]
                    val displayData = "Suhu: ${data.suhu}\nHumid: ${data.humid}\nLux: ${data.lux}\nTimestamp: ${data.ts}"
                    tvDataCuaca.text = displayData
                } else {
                    Toast.makeText(this@Frame2Activity, "Gagal mengambil data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<DataCuaca>>, t: Throwable) {
                Toast.makeText(this@Frame2Activity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
