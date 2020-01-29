package com.jdc.room.ignores.db.entity

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    ignoredColumns = ["photo"]
)
data class Notes(
    @PrimaryKey(autoGenerate = true)
    var id:Long? = null,
    var title:String,
    var photo:Bitmap?,
    var path:String,
    var creation:Date?
)