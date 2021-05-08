package com.yanxing.valuation.dao

import androidx.room.Query
import com.yanxing.valuation.model.EPS

interface EPSDao:BaseDao<EPS> {

    @Query("select * from eps where number=:number order by year")
    fun findAllByNumber(number:String):ArrayList<EPS>

}