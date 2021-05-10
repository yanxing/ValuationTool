package com.yanxing.valuation.dao

import androidx.room.Dao
import androidx.room.Query
import com.yanxing.valuation.model.EPS

@Dao
interface EPSDao:BaseDao<EPS> {

    @Query("select * from eps where number=:number order by year")
    fun findAllByNumber(number:String):List<EPS>

}