package com.yanxing.valuation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yanxing.valuation.dao.RoomManage
import com.yanxing.valuation.model.Company
import com.yanxing.valuation.model.Report

class DataDealViewModel :ViewModel() {

    val companyLiveData = MutableLiveData<List<Company>>()
    val reportLiveData=MutableLiveData<List<Report>>()

    fun getCompany(){
        val companys=RoomManage.roomDataBase.getCompanyDao().findAll()
        companyLiveData.value=companys
    }

    /**
     *
     */
    fun getReport(number:String){
        val reports=RoomManage.roomDataBase.getReportDao().findAllByNumber(number)

    }
}