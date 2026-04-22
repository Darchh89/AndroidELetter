package com.example.androideletter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class halaman_beranda_siswa : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.halaman_beranda_siswa)

        // --- KODE UNTUK MENGHILANGKAN NAVBAR BAWAAN HP ---
        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)

        // 1. Menyembunyikan Navigation Bar (Tombol bawah)
        windowInsetsController.hide(WindowInsetsCompat.Type.navigationBars())

        // Opsional: Jika Anda juga ingin menyembunyikan Status Bar (Jam dan Baterai di atas)
        // windowInsetsController.hide(WindowInsetsCompat.Type.statusBars())

        // 2. Mengatur agar saat user mengusap (swipe) dari bawah layar,
        // navbar bawaan muncul sementara, lalu otomatis hilang lagi (Sticky Immersive)
        windowInsetsController.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        // --------------------------------------------------
    }
}