package com.example.jewellersinvoice.newInvoicePackage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jewellersinvoice.database.InvoiceDatabaseDao

class NewInvoiceViewModelFactory(
    private val customerKey: Long,
    private val dataSource: InvoiceDatabaseDao) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewInvoiceViewModel::class.java)) {
            return NewInvoiceViewModel(customerKey, dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}