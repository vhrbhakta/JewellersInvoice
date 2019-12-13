package com.example.jewellersinvoice.newInvoicePackage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jewellersinvoice.database.InvoiceDatabaseDao
import kotlinx.coroutines.*

class NewInvoiceViewModel(
    private val customerKey: Long = 0L,
    val database: InvoiceDatabaseDao
) : ViewModel() {



    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _navigateToMyInvoices = MutableLiveData<Boolean?>()

    val navigateToMyInvoices: LiveData<Boolean?>
        get() = _navigateToMyInvoices

    fun doneNavigating() {
        _navigateToMyInvoices.value = null
    }
    fun getUserInputs(name:String,email:String){

    }
    fun onSetNewInvoice(zipCode: Int) {
        uiScope.launch {
            // IO is a thread pool for running operations that access the disk, such as
            // our Room database.
            withContext(Dispatchers.IO) {
                val customer = database.get(customerKey) ?: return@withContext
                customer.zip = zipCode
                database.update(customer)
            }

            // Setting this state variable to true will alert the observer and trigger navigation.
            _navigateToMyInvoices.value = true
        }
    }
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}