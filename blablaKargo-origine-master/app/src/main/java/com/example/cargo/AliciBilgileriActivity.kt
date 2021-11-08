package com.example.cargo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cargo.databinding.ActivityAliciBilgileriBinding
import com.google.firebase.database.FirebaseDatabase



class AliciBilgileriActivity : AppCompatActivity() {

    lateinit var binding: ActivityAliciBilgileriBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAliciBilgileriBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var database = FirebaseDatabase.getInstance().reference

        binding.btnAlGonder.setOnClickListener{
            var aliciAdSoyad= binding.aliciAdSoyad.text.toString()
            var telefon= binding.telefon.text.toString()
            var ilce= binding.ilce.text.toString()
            var mahalle= binding.mahalle.text.toString()
            var cadde= binding.cadde.text.toString()
            var sokak= binding.sokak.text.toString()

            database.child(telefon).setValue(aliciBilgileri(aliciAdSoyad,ilce,mahalle,cadde,sokak))



        }

    }



    fun donusgerigonderici(view: View) {
        val intent = Intent(this, KargoGonderActivity::class.java)
        startActivity(intent)
    }

    fun devamkg(view: View) {
        val intent = Intent(this, KargoFiyatActivity::class.java)
        startActivity(intent)
    }

}