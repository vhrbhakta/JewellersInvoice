package com.example.jewellersinvoice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.jewellersinvoice.databinding.FragmentNewInvoiceBinding

class NewInvoice : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentNewInvoiceBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_new_invoice, container, false)
        var customer_info : MutableMap<String, String?>
        binding.submitInvoice.setOnClickListener{
            customer_info = makeNewInvoice(binding)
        }

        return binding.root
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_new_invoice, container, false)
    }

    fun makeNewInvoice(binding : FragmentNewInvoiceBinding): MutableMap<String, String?>{

        val name:String? = binding.recipientName.text.toString()
        val email:String?= binding.recipientEmail.text.toString()
        val phone_num:String? = binding.recipientPhone.text.toString()
        val address:String? = binding.recipientStreetAddress.text.toString()
        val suite:String? = binding.recipientSuite.text.toString()
        val city:String? = binding.recipientCity.text.toString()
        val zip_code:String? = binding.recipientZip.text.toString()
        val country:String? = binding.recipientCountry.text.toString()
//        var customer_info= arrayOf(name, email, phone_num, address, suite, city, zip_code, country)
        var customer_info = mutableMapOf("name" to name, "email" to email, "phone_num" to phone_num,
            "address" to address, "suite" to suite, "city" to city, "zip_code" to zip_code, "country" to country)
        for(value in customer_info.keys){
            if(value.trim().equals("") || value == null){
                customer_info.set(value, null)
            }

        }
        return customer_info
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