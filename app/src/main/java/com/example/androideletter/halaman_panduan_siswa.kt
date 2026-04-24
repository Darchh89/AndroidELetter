package com.example.androideletter

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.google.android.material.card.MaterialCardView

class halaman_panduan_siswa : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Set Layout
        setContentView(R.layout.halaman_panduan_siswa)

        // 2. Mode Imersif (Menyembunyikan Navbar Sistem HP)
        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
        windowInsetsController.hide(WindowInsetsCompat.Type.navigationBars())
        windowInsetsController.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        // 3. Inisialisasi Accordion
        val btnDispensasi = findViewById<MaterialCardView>(R.id.btn_dispensasi)
        val contentDispensasi = findViewById<MaterialCardView>(R.id.content_dispensasi)
        val arrowDispensasi = findViewById<ImageView>(R.id.arrow_dispensasi)

        val btnMasuk = findViewById<MaterialCardView>(R.id.btn_masuk)
        val contentMasuk = findViewById<MaterialCardView>(R.id.content_masuk)
        val arrowMasuk = findViewById<ImageView>(R.id.arrow_masuk)

        val btnKeluar = findViewById<MaterialCardView>(R.id.btn_keluar)
        val contentKeluar = findViewById<MaterialCardView>(R.id.content_keluar)
        val arrowKeluar = findViewById<ImageView>(R.id.arrow_keluar)

        // Fungsi Toggle Accordion
        fun toggleAccordion(content: View, arrow: ImageView) {
            if (content.visibility == View.GONE) {
                content.visibility = View.VISIBLE
                arrow.animate().rotation(180f).setDuration(200).start()
            } else {
                content.visibility = View.GONE
                arrow.animate().rotation(0f).setDuration(200).start()
            }
        }

        btnDispensasi.setOnClickListener { toggleAccordion(contentDispensasi, arrowDispensasi) }
        btnMasuk.setOnClickListener { toggleAccordion(contentMasuk, arrowMasuk) }
        btnKeluar.setOnClickListener { toggleAccordion(contentKeluar, arrowKeluar) }

        // --- 4. LOGIKA NAVIGASI PINDAH HALAMAN ---

        // Navigasi ke Beranda
        val navBeranda = findViewById<LinearLayout>(R.id.nav_beranda)
        navBeranda.setOnClickListener {
            val intent = Intent(this, halaman_beranda_siswa::class.java)
            // Menggunakan flag agar tidak menumpuk halaman (menghapus stack sebelumnya)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }

        // Navigasi ke Riwayat
        val navRiwayat = findViewById<LinearLayout>(R.id.nav_riwayat)
        navRiwayat.setOnClickListener {
            val intent = Intent(this, halaman_riwayat_siswa::class.java)
            startActivity(intent)
        }

        // Navigasi ke Profil
        val navProfil = findViewById<LinearLayout>(R.id.nav_profil)
        navProfil.setOnClickListener {
            val intent = Intent(this, halaman_profil_siswa::class.java)
            startActivity(intent)
        }
    }
}