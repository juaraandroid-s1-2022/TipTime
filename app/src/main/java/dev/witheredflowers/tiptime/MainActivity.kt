package dev.witheredflowers.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.witheredflowers.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
	
	// lateinit adalah perjanjian bahwa kode kita akan menginisialisasi variabel sebelum digunakan
	// kalau tidak atau lupa diinisialisasi maka aplikasi akan crash
	lateinit var binding: ActivityMainBinding
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		// setContentView(R.layout.activity_main)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		
		// Set on click listener pada button
		binding.calculateButton.setOnClickListener {
			calculateTip()
		}
	}
	
	fun calculateTip() {
		// Mengambil value dari EditText
		val stringInTextField = binding.costOfService.text.toString()
		
		// Karena bisa saja text ini kosong, jadi harus mengganti fungsi
		// dari toDouble menjadi toDoubleOrNull
		val cost = stringInTextField.toDoubleOrNull()
		
		// Mengurus logika ketika mendapatkan cost adalah null
		if (cost == null) {
			// Set text dari tipResult jadi kosong
			binding.tipResult.text = ""
			
			// keluar dari fungsi (logika di bawah tidak akan dijalankan)
			return
		}
		
		// Mengambil value dari radio button yang terpilih
		val selectedId = binding.tipOptions.checkedRadioButtonId
		
		// Menghitung persentase tip
		val tipPercentage = when (selectedId) {
			R.id.option_twenty_percent -> 0.20
			R.id.option_eighteen_percent -> 0.18
			else -> 0.15
		}
		
		// Logika kalulasi tip
		var tip = tipPercentage * cost
		
		// Mengambil value dari toggle (switch) apakah ada pembulatan (true atau false)
		val roundUp = binding.roundUpSwitch.isChecked
		
		// apabila true (ada pembulatan)
		if (roundUp) {
			// logika pembulatan
			tip = kotlin.math.ceil(tip)
		}
		
		// Memunculkan format mata uang di tip
		val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
		
		// Setel TextView tipResult dengan text tambahan formattedTip
		binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
	}
}