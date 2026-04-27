package com.example.androideletter

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.google.android.material.card.MaterialCardView

class halaman_beranda_siswa : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.halaman_beranda_siswa)

        // Hilangkan Navbar Bawaan HP
        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
        windowInsetsController.hide(WindowInsetsCompat.Type.navigationBars())
        windowInsetsController.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        // Deklarasi tombol navigasi bawah
        val navPanduan = findViewById<LinearLayout>(R.id.nav_panduan)
        val navRiwayat = findViewById<LinearLayout>(R.id.nav_riwayat)
        val navProfil = findViewById<LinearLayout>(R.id.nav_profil)

        // Deklarasi Card di tengah halaman
        val cardLihatSurat = findViewById<MaterialCardView>(R.id.card_lihat_surat)
        val cardBuatSurat = findViewById<MaterialCardView>(R.id.card_buat_surat)

        // Klik "Lihat Surat" mengarah ke menu pilihan lihat surat
        cardLihatSurat.setOnClickListener {
            startActivity(Intent(this, halaman_lihat_surat_siswa::class.java))
        }

        // Klik "Buat Surat" mengarah ke menu pilihan pembuatan surat
        cardBuatSurat.setOnClickListener {
            startActivity(Intent(this, halaman_buat_surat_siswa::class.java))
        }

        // Navigasi bawah
        navPanduan.setOnClickListener {
            startActivity(Intent(this, halaman_panduan_siswa::class.java))
        }

        navRiwayat.setOnClickListener {
            startActivity(Intent(this, halaman_riwayat_siswa::class.java))
        }

        navProfil.setOnClickListener {
            startActivity(Intent(this, halaman_profil_siswa::class.java))
        }
    }
}