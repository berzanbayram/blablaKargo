package com.example.cargo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cargo.databinding.ActivityKargoFiyatBinding

class KargoFiyatActivity : AppCompatActivity() {
    lateinit var binding: ActivityKargoFiyatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        binding = ActivityKargoFiyatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fiyatHesapla.setOnClickListener{
        if(binding.ad2.text.isNotEmpty()){
            var kg= binding.ad2.text.toString().toInt()
            var ucretSonucu : Double= (kg*4).toDouble()
            binding.sonuc.text=ucretSonucu.toString()+" "+"Lira Kargo Ücretinizdir"
            binding.sonuc.setTextColor(getColor(R.color.red))
        }
            else{
                binding.sonuc.text="Bir Ağırlık Giriniz"
                binding.sonuc.setTextColor(getColor(R.color.red))
        }

        }

    }


    fun donusgeriAlicibilgileri( view: View) {
        val intent = Intent(this, AliciBilgileriActivity::class.java)
        startActivity(intent)
    }

    fun devamEtBasarili( view: View) {
        val intent = Intent(this, odemeActivity::class.java)
        startActivity(intent)
    }




}