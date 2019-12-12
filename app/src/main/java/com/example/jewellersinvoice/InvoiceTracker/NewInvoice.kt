package com.example.jewellersinvoice.InvoiceTracker


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.jewellersinvoice.R
import com.example.jewellersinvoice.database.InvoiceDatabase
import com.example.jewellersinvoice.databinding.FragmentNewInvoiceBinding

class NewInvoice : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentNewInvoiceBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_new_invoice, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = InvoiceDatabase.getInstance(application).invoiceDatabaseDao
        val viewModelFactory = InvoiceTrackerViewModelFactory(dataSource, application)
        val invoiceTrackerViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(InvoiceTrackerViewModel::class.java)

        binding.invoiceTrackerViewModel = invoiceTrackerViewModel
        binding.setLifecycleOwner(this)

        return binding.root
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_new_invoice, container, false)
    }



}
/**
 * From user
 * Name, address, email , phone,
 *
 * From business
 * Name, address, email, phone, sales Tax number,
 *
 * For Invoice
 * Products(inq price and name - could be added at run or at separate frag), quantity, due date, company name(previously created or at run time)
 *
 *
 * **/