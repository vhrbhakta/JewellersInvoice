package com.example.jewellersinvoice

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import com.example.jewellersinvoice.database.Customer
import java.text.SimpleDateFormat

//fun convertNumericQualityToString(quality: Int, resources: Resources): String {
//    var qualityString = resources.getString(R.string.three_ok)
//    when (quality) {
//        -1 -> qualityString = "--"
//        0 -> qualityString = resources.getString(R.string.zero_very_bad)
//        1 -> qualityString = resources.getString(R.string.one_poor)
//        2 -> qualityString = resources.getString(R.string.two_soso)
//        4 -> qualityString = resources.getString(R.string.four_pretty_good)
//        5 -> qualityString = resources.getString(R.string.five_excellent)
//    }
//    return qualityString
//}


//@SuppressLint("SimpleDateFormat")
//fun convertLongToDateString(systemTime: Long): String {
//    return SimpleDateFormat("EEEE MMM-dd-yyyy' Time: 'HH:mm")
//        .format(systemTime).toString()
//}



fun formatNights(customers: List<Customer>, resources: Resources): Spanned {
    val sb = StringBuilder()
    sb.apply {
        append(resources.getString(R.string.title))
        customers.forEach {
            append("<br>")
            append(resources.getString(R.string.customer_name))
            append("\t${it.name}<br>")

            append(resources.getString(R.string.customer_email))
            append("\t${it.email}<br>")
            append(resources.getString(R.string.customer_phone))
            append("\t${it.phone}<br>")
            append(resources.getString(R.string.customer_address))
            append("\t${it.address}<br>")
            append(resources.getString(R.string.customer_suite))
            append("\t${it.suite}<br>")
            append(resources.getString(R.string.customer_city))
            append("\t${it.city}<br>")
            append(resources.getString(R.string.customer_zip))
            append("\t${it.zip}<br>")
            append(resources.getString(R.string.customer_country))
            append("\t${it.country}<br><br>")
        }
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}