package com.jdc.restaurant.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0,
    @ForeignKey(
        entity = Category::class,
        parentColumns = ["id"],
        childColumns = ["categoryId"],
        onDelete = ForeignKey.CASCADE
    )
    @ColumnInfo(index = true)
    var categoryId:Long = 0,
    var name:String = "",
    var price:Int = 0,
    var description:String = ""
)