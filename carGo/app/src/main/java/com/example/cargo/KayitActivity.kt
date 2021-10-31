package com.example.cargo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.giris_activity.*

class KayitActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kayit)

        auth = FirebaseAuth.getInstance()

    }

    fun geriDon( view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


    fun kayitOl(view: View) {
        val email1 = email.text.toString()
        val sifre1 = sifre.text.toString()

        auth.createUserWithEmailAndPassword(email1, sifre1).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val intent = Intent(this, GirisActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_LONG).show()
        }

    }
}