package com.yanxing.valuation.dao

import androidx.room.Query
import com.yanxing.valuation.model.Company

interface CompanyDao:BaseDao<Company> {

    @Query("select * from company")
    fun findAll():ArrayList<Company>
}