package com.example.androideletter

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class halaman_masuk_siswa : AppCompatActivity() {

    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.halaman_masuk_siswa)

        val etId = findViewById<EditText>(R.id.et_id)
        val etPassword = findViewById<EditText>(R.id.et_password)
        val btnMasuk = findViewById<MaterialButton>(R.id.btn_masuk)
        val tvDaftar = findViewById<TextView>(R.id.tv_daftar)
        val ivTogglePassword = findViewById<ImageView>(R.id.iv_toggle_password)
        val btnBack = findViewById<LinearLayout>(R.id.btn_back) // Tombol Kembali

        // Logika Tombol Kembali
        btnBack.setOnClickListener {
            val intent = Intent(this, LanjutkanSebagai::class.java)
            startActivity(intent)
            finish()
        }

        // Logika Intip Kata Sandi
        ivTogglePassword.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                ivTogglePassword.setImageResource(R.drawable.mata_oren_on)
            } else {
                etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                ivTogglePassword.setImageResource(R.drawable.mata_oren_off)
            }
            etPassword.setSelection(etPassword.text.length)
        }

        btnMasuk.setOnClickListener {
            val inputId = etId.text.toString()
            val inputPassword = etPassword.text.toString()

            if (inputId == "123" && inputPassword == "12345") {
                Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, halaman_beranda_siswa::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "ID atau Kata Sandi salah!", Toast.LENGTH_SHORT).show()
            }
        }

        tvDaftar.setOnClickListener {
            val intent = Intent(this, halaman_daftar_siswa::class.java)
            startActivity(intent)
        }
    }
}