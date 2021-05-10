package com.yanxing.valuation.dao

import androidx.room.Dao
import androidx.room.Query
import com.yanxing.valuation.model.Report

@Dao
interface ReportDao :BaseDao<Report>{

    @Query("select * from report where number=:number order by year")
    fun findAllByNumber(number:String):List<Report>
}