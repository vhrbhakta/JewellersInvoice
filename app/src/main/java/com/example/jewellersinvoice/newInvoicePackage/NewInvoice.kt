package com.example.jewellersinvoice.newInvoicePackage


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
//import com.example.jewellersinvoice.NewInvoiceArgs
//import com.example.jewellersinvoice.NewInvoiceDirections
import com.example.jewellersinvoice.R
import com.example.jewellersinvoice.database.InvoiceDatabase
import com.example.jewellersinvoice.databinding.FragmentNewInvoiceBinding
import com.example.jewellersinvoice.invoiceTracker.MyInvoicesDirections

class NewInvoice : Fragment() {
    lateinit var binding: FragmentNewInvoiceBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_new_invoice, container, false)
        val application = requireNotNull(this.activity).application

        val arguments = NewInvoiceArgs.fromBundle(arguments!!)
        val dataSource = InvoiceDatabase.getInstance(application).invoiceDatabaseDao
        val viewModelFactory = NewInvoiceViewModelFactory(arguments.customerKey, dataSource)
        val newInvoiceViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(NewInvoiceViewModel::class.java)
        binding.newInvoiceViewModel = newInvoiceViewModel
        newInvoiceViewModel.navigateToMyInvoices.observe(this, Observer {
            if (it == true) { // Observed state is true.
                this.findNavController().navigate(
                    NewInvoiceDirections.actionNewInvoiceToMyInvoices())
                newInvoiceViewModel.doneNavigating()
            }
        })
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