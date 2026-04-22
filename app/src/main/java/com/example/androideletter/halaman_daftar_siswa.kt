package com.example.androideletter

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class halaman_daftar_siswa : AppCompatActivity() {

    private var isPassVisible = false
    private var isConfirmPassVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.halaman_daftar_siswa)

        val btnBack = findViewById<LinearLayout>(R.id.btn_back)
        val tvMasuk = findViewById<TextView>(R.id.tv_masuk)

        // Inisialisasi untuk fitur mata
        val etPassword = findViewById<EditText>(R.id.et_password)
        val etConfirmPassword = findViewById<EditText>(R.id.et_confirm_password)
        val ivTogglePass = findViewById<ImageView>(R.id.iv_toggle_password)
        val ivToggleConfirmPass = findViewById<ImageView>(R.id.iv_toggle_confirm_password)

        // Logika Tombol Kembali ke Halaman Utama
        btnBack.setOnClickListener {
            val intent = Intent(this, LanjutkanSebagai::class.java)
            startActivity(intent)
            finish()
        }

        // Fitur Mata: Kata Sandi
        ivTogglePass.setOnClickListener {
            isPassVisible = !isPassVisible
            if (isPassVisible) {
                etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                ivTogglePass.setImageResource(R.drawable.mata_biru_on) // Gunakan ikon biru sesuai tema daftar
            } else {
                etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                ivTogglePass.setImageResource(R.drawable.mata_biru_off)
            }
            etPassword.setSelection(etPassword.text.length)
        }

        // Fitur Mata: Konfirmasi Kata Sandi
        ivToggleConfirmPass.setOnClickListener {
            isConfirmPassVisible = !isConfirmPassVisible
            if (isConfirmPassVisible) {
                etConfirmPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                ivToggleConfirmPass.setImageResource(R.drawable.mata_biru_on)
            } else {
                etConfirmPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                ivToggleConfirmPass.setImageResource(R.drawable.mata_biru_off)
            }
            etConfirmPassword.setSelection(etConfirmPassword.text.length)
        }

        tvMasuk.setOnClickListener {
            finish()
        }
    }
}