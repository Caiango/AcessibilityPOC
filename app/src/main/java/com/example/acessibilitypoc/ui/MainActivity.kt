package com.example.acessibilitypoc.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.acessibilitypoc.R
import com.example.acessibilitypoc.data.ItemsMock
import com.example.acessibilitypoc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mountUI()
        setAccessibility()
    }

    private fun setAccessibility() {
        binding.imageView.contentDescription = getString(R.string.logo_inter)
        ViewCompat.setAccessibilityHeading(binding.txHistorico, true)
        ViewCompat.setAccessibilityHeading(binding.txInserir, true)
        ViewCompat.setAccessibilityHeading(binding.txMeuSaldo, true)
        binding.txSaldo.accessibilityLiveRegion = View.ACCESSIBILITY_LIVE_REGION_POLITE
    }

    private fun mountUI() {
        adapter = MainAdapter(ItemsMock.itemslist)
        binding.rvMain.layoutManager = LinearLayoutManager(this)
        binding.rvMain.setHasFixedSize(true)
        binding.rvMain.adapter = adapter
    }
}