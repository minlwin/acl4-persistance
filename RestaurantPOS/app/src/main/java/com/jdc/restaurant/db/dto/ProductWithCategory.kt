package com.jdc.restaurant.db.dto

import androidx.room.Embedded
import androidx.room.Relation
import com.jdc.restaurant.db.entity.Category
import com.jdc.restaurant.db.entity.Product

data class ProductWithCategory(
    @Embedded
    val product: Product,
    @Relation(parentColumn = "categoryId", entityColumn = "id")
    val category: Category
)