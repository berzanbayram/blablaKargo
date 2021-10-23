package com.example.blablacargo

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.blablacargo.databinding.ActivityKargogondermeBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_kargogonderme.*
import java.lang.StringBuilder

//Korgo gönderim ve veri tabanı işlemleri
class kargogonderme : AppCompatActivity() {
    lateinit var binding: ActivityKargogondermeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityKargogondermeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var database = FirebaseDatabase.getInstance().reference

        binding.kargola.setOnClickListener {

            var agonAdres=binding.gonAdres.text.toString()
            var aaliciAdres=binding.aliciAdres.text.toString()
            var aucret=binding.ucret.text.toString().toInt()
            var ailetisim = binding.iletisim.text.toString()

            database.child(ailetisim.toString()).setValue(kisi(agonAdres, aaliciAdres, aucret))

        }
        var getdata = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var ilan = StringBuilder()
                for (i in snapshot.children){
                    var alici = i.child("aliciAdres").getValue()
                    var gonderici = i.child("gonAdres").getValue()
                    var ucret= i.child("ucret").getValue()

                    ilan.append("${i.key} $alici $gonderici $ucret \n")

                }
                    binding.ilanlar.setText(ilan)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
            database.addValueEventListener(getdata)
            database.addListenerForSingleValueEvent(getdata)

    }



    }
