package com.example.cargo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.giris_activity.*


class GirisActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.giris_activity)

        auth = FirebaseAuth.getInstance()

    }


    fun geriDon( view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun killingControl(view: View) {
        auth.signInWithEmailAndPassword(email.text.toString(),sifre.text.toString()).addOnCompleteListener { task ->

            if (task.isSuccessful) {

                val email = auth.currentUser?.email.toString()
                Toast.makeText(this,"Giriş başarılı : ${email}",Toast.LENGTH_LONG).show()
                val intent = Intent(this, GonderimTipiActivity::class.java)
                startActivity(intent)
            }

        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }








}