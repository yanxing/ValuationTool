package com.yanxing.valuation.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="report")
data class Report(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    /**
     * company 编号
     */
    var number: String,
    /**
     * business volume for the first quarter
     */
    var firstQuarterBV: String,
    /**
     * the year-on-year growth rate
     */
    var compareFirstQuarterBV:String,
    /**
     * retained profits for the first quarter
     */
    var firstQuarterRP: String,
    /**
     * the year-on-year growth rate
     */
    var compareFirstQuarterRP: String,
    /**
     * deduct retained profits for the first quarter
     */
    var firstQuarterDeductRP: String,
    /**
     * the year-on-year growth rate
     */
    var compareFirstQuarterDeductRP:String,

    var halfYearBV:String,
    var compareHalfYearBV:String,
    var halfYearRP:String,
    var compareHalfYearRP: String,
    var halfYearDeductRP:String,
    var compareHalfYearDeductRP: String,

    var thirdQuarterBV:String,
    var compareThirdQuarterBV:String,
    var thirdQuarterRP: String,
    var compareThirdQuarterRP: String,
    var thirdQuarterDeductRP: String,
    var compareThirdQuarterDeductRP: String,

    var yearBV:String,
    var compareYearBV: String,
    var yearRP:String,
    var compareYearRP: String,
    var yearDeductRP:String,
    var compareYearDeductRP: String,
    /**
     * 年份
     */
    var year:Int
):Comparable<Report>{
    //按照年份排序
    override fun compareTo(other: Report): Int {
        return this.year-other.year
    }
}
