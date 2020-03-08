package com.jdc.restaurant.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Product::class,
            parentColumns = ["id"],
            childColumns = ["productId"],
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = Sale::class,
            parentColumns = ["id"],
            childColumns = ["saleId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Orders(
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0,
    @ColumnInfo(index = true)
    var productId:Long? = 0,
    var productName:String = "",
    var unitPrice:Int = 0,
    @ColumnInfo(index = true)
    var saleId:Long = 0,
    var quantity:Int = 0
) {
    val total:Int
        get() = unitPrice * quantity
}