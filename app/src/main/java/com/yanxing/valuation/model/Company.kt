package com.yanxing.valuation.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="company")
data class Company(
    @PrimaryKey
    var number:String,
    var name:String
)
