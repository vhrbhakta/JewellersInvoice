package com.example.jewellersinvoice.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customer_info_table")
data class Customer(
    @PrimaryKey(autoGenerate = true)
    var customerID: Long = 0L,
    @ColumnInfo(name = "name")
    var name:String = "Jane Doe",
    @ColumnInfo(name="email")
    var email:String = "jdoe@ilovejewelry.com",
    @ColumnInfo(name="phone")
    var phone:Long = 0L,
    @ColumnInfo(name="address")
    var address:String = "1234 Jewels Rd.",
    @ColumnInfo(name="suite")
    var suite:String = "suite 00",
    @ColumnInfo(name="city")
    var city:String = "Emerald City",
    @ColumnInfo(name="zip")
    var zip:Int = 0,
    @ColumnInfo(name="country")
    var country:String = "Jewelry Country"
    )