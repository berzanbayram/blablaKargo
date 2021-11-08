package com.example.cargo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import com.stripe.android.PaymentConfiguration



class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PaymentConfiguration.init(
            applicationContext,
            "pk_test_51Jq3kOKAWI3TN5ucs2nXpL3puu8tuI9n1gi0SUHZ1vpEU9f9xGEOOdlsHV8XwXSzp9Nsbg4GGNLra3B0cKe1NJmh00Vww3R8nn"
        )

    }


    fun girisYap(view: View) {
        val intent = Intent(this, GirisActivity::class.java)
        startActivity(intent)
    }


    fun kayitOl(view: View) {
        val intent = Intent(this, KayitActivity::class.java)
        startActivity(intent)

    }



}