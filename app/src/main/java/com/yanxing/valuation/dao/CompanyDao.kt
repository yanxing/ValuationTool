package com.yanxing.valuation.dao

import androidx.room.Dao
import androidx.room.Query
import com.yanxing.valuation.model.Company

@Dao
interface CompanyDao:BaseDao<Company> {

    @Query("select * from company")
    fun findAll():List<Company>
}