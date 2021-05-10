package com.yanxing.valuation.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yanxing.valuation.model.Company
import com.yanxing.valuation.model.EPS
import com.yanxing.valuation.model.Report

@Database(entities = [Report::class,Company::class,EPS::class],version = 1)
abstract class AbstractRoomBase : RoomDatabase() {

    abstract fun getReportDao():ReportDao
    abstract fun getCompanyDao():CompanyDao
    abstract fun getEPSDao():EPSDao
}