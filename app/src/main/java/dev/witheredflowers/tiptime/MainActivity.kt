package dev.witheredflowers.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.witheredflowers.tiptime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	
	// lateinit adalah perjanjian bahwa kode kita akan menginisialisasi variabel sebelum digunakan
	// kalau tidak atau lupa diinisialisasi maka aplikasi akan crash
	lateinit var binding: ActivityMainBinding
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		// setContentView(R.layout.activity_main)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
	}
}