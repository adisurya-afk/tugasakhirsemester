package com.tugasakhirsemester.madeadi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.tugasakhirsemester.madeadi.api.RetrofitClient
import com.tugasakhirsemester.madeadi.model.IndonesiaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ShowIndonesia()
    }

    private fun ShowIndonesia() {
        RetrofitClient.instance.getIndonesia()
            .enqueue(object : Callback<ArrayList<IndonesiaResponse>> {
                override fun onResponse(
                    call: Call<ArrayList<IndonesiaResponse>>,
                    response: Response<ArrayList<IndonesiaResponse>>
                ) {
                    val indonesia = response.body()?.get(0)
                    val positif = indonesia?.positif
                    val hospitalized = indonesia?.dirawat
                    val recover = indonesia?.sembuh
                    val death = indonesia?.meninggal

                    val cassPositive : TextView = findViewById(R.id.tvPositive)
                    cassPositive.text= positif
                    val cassRecover : TextView = findViewById(R.id.tvRecover)
                    cassRecover.text= recover
                    val cassHospitalized : TextView = findViewById(R.id.tvHospitalized)
                    cassHospitalized.text= hospitalized
                    val cassDeath : TextView = findViewById(R.id.tvDeath)
                    cassDeath.text= death

                }

                override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
    }
}