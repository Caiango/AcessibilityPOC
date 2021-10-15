package com.example.acessibilitypoc.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.acessibilitypoc.data.Items
import com.example.acessibilitypoc.data.ItemsMock
import java.text.DecimalFormat

class MainViewModel : ViewModel() {

    val itemsList: MutableLiveData<List<Items>> = MutableLiveData()
    val saldo: MutableLiveData<String> = MutableLiveData()

    fun getList() {
        itemsList.postValue(ItemsMock.itemslist)
        updateSaldo()
    }

    fun insertElement(item: Items) {
        ItemsMock.itemslist.add(item)
        itemsList.postValue(ItemsMock.itemslist)
        updateSaldo()
    }

    private fun updateSaldo() {
        var total = 0.0
        val dec = DecimalFormat("#,###.00")
        ItemsMock.itemslist.forEach { item ->
            total += item.value
        }
        saldo.postValue(dec.format(total))
    }
}