package com.example.acessibilitypoc.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.acessibilitypoc.R
import com.example.acessibilitypoc.data.Items
import com.example.acessibilitypoc.databinding.ActivityMainBinding
import com.example.acessibilitypoc.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.getList()

        mainViewModel.itemsList.observe(this) {
            adapter = MainAdapter(it)
            binding.rvMain.adapter = adapter
        }

        mainViewModel.saldo.observe(this) {
            binding.txSaldo.text = it
            binding.txSaldo.contentDescription = "Meu saldo é $it reais"
        }

        mountUI()
        setAccessibility()
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.txPlus.setOnClickListener {
            mainViewModel.insertElement(mountNewItem(true))
        }

        binding.txMinus.setOnClickListener {
            mainViewModel.insertElement(mountNewItem(false))
        }
    }

    private fun setAccessibility() {
        binding.imageView.contentDescription = getString(R.string.logo_inter)
        ViewCompat.setAccessibilityHeading(binding.txHistorico, true)
        ViewCompat.setAccessibilityHeading(binding.txInserir, true)
        ViewCompat.setAccessibilityHeading(binding.txMeuSaldo, true)
        binding.txSaldo.accessibilityLiveRegion = View.ACCESSIBILITY_LIVE_REGION_POLITE
    }

    private fun mountUI() {
        binding.rvMain.layoutManager = LinearLayoutManager(this)
        binding.rvMain.setHasFixedSize(true)
    }

    private fun mountNewItem(isGain: Boolean): Items {
        val item = Items("", 0.0)
        val name = binding.etName.text.toString()
        val value = binding.etValue.text.toString()

        if (isGain) {
            item.name = name
            item.value = value.toDouble()
        } else {
            item.name = name
            item.value = -(value.toDouble())
        }
        return item
    }
}