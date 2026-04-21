package com.example.t3_mobile

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNama = findViewById<EditText>(R.id.etNama)
        val rgKelamin = findViewById<RadioGroup>(R.id.rgKelamin)
        val rbLaki = findViewById<RadioButton>(R.id.rbLaki)
        val rbPerempuan = findViewById<RadioButton>(R.id.rbPerempuan)
        val cbMembaca = findViewById<CheckBox>(R.id.cbMembaca)
        val cbCoding = findViewById<CheckBox>(R.id.cbCoding)
        val cbOlahraga = findViewById<CheckBox>(R.id.cbOlahraga)
        val btnTampilkan = findViewById<Button>(R.id.btnTampilkan)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        btnTampilkan.setOnClickListener {
            val nama = etNama.text.toString()

            if (nama == "") {
                etNama.error = "Nama tidak boleh kosong!"
            } else {

                var kelamin = ""
                if (rbLaki.isChecked) {
                    kelamin = "Laki-laki"
                } else if (rbPerempuan.isChecked) {
                    kelamin = "Perempuan"
                }

                if (kelamin == "") {
                    Toast.makeText(this, "Pilih jenis kelamin dulu!", Toast.LENGTH_SHORT).show()
                } else {

                    var hobi = ""
                    if (cbMembaca.isChecked) {
                        hobi = hobi + "Membaca, "
                    }
                    if (cbCoding.isChecked) {
                        hobi = hobi + "Coding, "
                    }
                    if (cbOlahraga.isChecked) {
                        hobi = hobi + "Olahraga, "
                    }

                    if (hobi == "") {
                        hobi = "-"
                    }

                    val hasilAkhir = "Nama    : " + nama + "\n" +
                            "Kelamin : " + kelamin + "\n" +
                            "Hobi    : " + hobi

                    // 5. Tampilkan hasilnya ke TextView
                    tvHasil.text = hasilAkhir
                    tvHasil.setTextColor(Color.parseColor("#3F51B5"))
                    tvHasil.setTypeface(null, Typeface.BOLD)
                }
            }
        }
    }
}