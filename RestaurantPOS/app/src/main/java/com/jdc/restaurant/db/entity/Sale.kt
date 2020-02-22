package com.jdc.restaurant.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Sale(
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0,
    var saleDate:Date = Date(),
    var total:Int
)