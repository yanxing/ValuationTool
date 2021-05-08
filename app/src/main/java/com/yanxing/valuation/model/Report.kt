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
     * 一季度营业收入
     */
    var firstQuarterBV: Double?=null,
    /**
     * 一季度营业收入同比增长
     */
    var compareFirstQuarterBV:String="",
    /**
     * 一季度净利润
     */
    var firstQuarterRP: Double?=null,
    /**
     *一季度净利润同比增长
     */
    var compareFirstQuarterRP: String="",
    /**
     * 一季度扣非净利润
     */
    var firstQuarterDeductRP: Double?=null,
    /**
     * 一季度扣非净利润同比增长
     */
    var compareFirstQuarterDeductRP:String="",

    var halfYearBV:Double?=null,
    var compareHalfYearBV:String="",
    var halfYearRP:Double?=null,
    var compareHalfYearRP: String="",
    var halfYearDeductRP:Double?=null,
    var compareHalfYearDeductRP: String="",

    var thirdQuarterBV:Double?=null,
    var compareThirdQuarterBV:String="",
    var thirdQuarterRP: Double?=null,
    var compareThirdQuarterRP: String="",
    var thirdQuarterDeductRP: Double?=null,
    var compareThirdQuarterDeductRP: String="",

    var yearBV:Double?=null,
    var compareYearBV: String="",
    var yearRP:Double?=null,
    var compareYearRP: String="",
    var yearDeductRP:Double?=null,
    var compareYearDeductRP: String="",
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
