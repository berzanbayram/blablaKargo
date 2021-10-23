package com.example.blablacargo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main_giris_yapildi.*
import kotlinx.android.synthetic.main.activity_main_kayit.*

class MainGirisYapildi : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_giris_yapildi)

        auth = FirebaseAuth.getInstance()

    }

    fun geriDon( view: View) {

        val ilkGirisyap = findViewById<View>(R.id.imageView)
        ilkGirisyap.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
    fun girisYap(view: View) {
        auth.signInWithEmailAndPassword(girisKullanici.text.toString(),girisParola.text.toString()).addOnCompleteListener { task ->

            if (task.isSuccessful) {

                val girisKullanicisi = auth.currentUser?.email.toString()
                Toast.makeText(this,"Hosgeldin: ${girisKullanicisi}",Toast.LENGTH_LONG).show()
                val intent = Intent(this, kargogonder::class.java)
                startActivity(intent)
                finish()
            }

        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_LONG).show()

        }
    }



}