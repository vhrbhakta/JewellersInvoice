package com.example.jewellersinvoice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.jewellersinvoice.databinding.FragmentNewInvoiceBinding

class NewInvoice : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentNewInvoiceBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_new_invoice, container, false)

        binding.buttonToInvoiceItems.setOnClickListener(){view:View->
            view.findNavController().navigate(NewInvoiceDirections.actionNewInvoiceToInvoiceItems())
        }

        return binding.root

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