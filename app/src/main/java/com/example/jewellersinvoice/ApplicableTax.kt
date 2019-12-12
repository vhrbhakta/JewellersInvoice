package com.example.jewellersinvoice


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.jewellersinvoice.databinding.FragmentApplicableTaxBinding


class ApplicableTax : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentApplicableTaxBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_applicable_tax, container, false)
        // Navigate to Invoice Visualizer
        binding.buttonGenerateInvoice.setOnClickListener(){view:View->
            view.findNavController().navigate(ApplicableTaxDirections.actionApplicableTaxToInvoiceVisuallizer())
        }


        return binding.root
    }


}
