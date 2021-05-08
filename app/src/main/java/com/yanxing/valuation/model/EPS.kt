package com.yanxing.valuation.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="eps")
data class EPS(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    /**
     * 预测
     */
    var forecast:String,
    /**
     * 真实
     */
    var real:String,
    /**
     * company 编号
     */
    var number:String,
    /**
     * 年份
     */
    var year:Int
)
