package com.example.jewellersinvoice;

import com.google.gson.annotations.SerializedName

//{"success":true,"timestamp":1576213800,"date":"2019-12-13","base":"XAU","rates":{"USD":1467.8332880176126},"unit":"per ounce"}
data class MetalObject (

   var timestamp: Long = 0L,

   var success: String?,

   var base: String?,

   var rates: Rates,

   var unit: String?

)

data class Rates(
   @SerializedName("USD")
   var currentRate: String?
)