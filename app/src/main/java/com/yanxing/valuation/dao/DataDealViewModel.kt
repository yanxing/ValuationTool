package com.yanxing.valuation.dao

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yanxing.valuation.model.Company
import com.yanxing.valuation.model.EPS
import com.yanxing.valuation.model.Report
import com.yanxing.valuation.util.DoubleUtil

class DataDealViewModel :ViewModel() {

    val companyLiveData = MutableLiveData<List<Company>>()
    val reportLiveData=MutableLiveData<List<Report>>()
    val epsLiveData=MutableLiveData<List<EPS>>()

    fun getCompany(){
        val companys=RoomManage.roomDataBase.getCompanyDao().findAll()
        companyLiveData.value=companys
    }

    fun getReport(number:String){
        val reports=RoomManage.roomDataBase.getReportDao().findAllByNumber(number)
        //查询计算同比增长，否则每次添加修改都需要计算
        for (index in reports.size-1 downTo 0){
            if (index-1>0) {
                //一季度
                if (reports[index-1].firstQuarterBV!=0.0) {
                    reports[index].compareFirstQuarterBV =
                        DoubleUtil.formatTWODigits(
                            DoubleUtil.sub(
                                reports[index].firstQuarterBV,
                                reports[index - 1].firstQuarterBV
                            ) / reports[index - 1].firstQuarterBV
                        ) + "%"
                }
                if (reports[index-1].firstQuarterRP!=0.0) {
                    reports[index].compareFirstQuarterRP =
                        DoubleUtil.formatTWODigits(
                            DoubleUtil.sub(
                                reports[index].firstQuarterRP,
                                reports[index - 1].firstQuarterRP
                            ) / reports[index - 1].firstQuarterRP
                        ) + "%"
                }
                if (reports[index-1].firstQuarterDeductRP!=0.0) {
                    reports[index].compareFirstQuarterDeductRP =
                        DoubleUtil.formatTWODigits(
                            DoubleUtil.sub(
                                reports[index].firstQuarterDeductRP,
                                reports[index - 1].firstQuarterDeductRP
                            ) / reports[index - 1].firstQuarterDeductRP
                        ) + "%"
                }

                //中报
                if (reports[index-1].halfYearBV!=0.0) {
                    reports[index].compareHalfYearBV =
                        DoubleUtil.formatTWODigits(
                            DoubleUtil.sub(
                                reports[index].halfYearBV,
                                reports[index - 1].halfYearBV
                            ) / reports[index - 1].halfYearBV
                        ) + "%"
                }
                if (reports[index-1].halfYearRP!=0.0) {
                    reports[index].compareHalfYearRP =
                        DoubleUtil.formatTWODigits(
                            DoubleUtil.sub(
                                reports[index].halfYearRP,
                                reports[index - 1].halfYearRP
                            ) / reports[index - 1].halfYearRP
                        ) + "%"
                }
                if (reports[index-1].halfYearDeductRP!=0.0) {
                    reports[index].compareHalfYearDeductRP =
                        DoubleUtil.formatTWODigits(
                            DoubleUtil.sub(
                                reports[index].halfYearDeductRP,
                                reports[index - 1].halfYearDeductRP
                            ) / reports[index - 1].halfYearDeductRP
                        ) + "%"
                }

                //三季度
                if (reports[index-1].thirdQuarterBV!=0.0) {
                    reports[index].compareThirdQuarterBV =
                        DoubleUtil.formatTWODigits(
                            DoubleUtil.sub(
                                reports[index].thirdQuarterBV,
                                reports[index - 1].thirdQuarterBV
                            ) / reports[index - 1].thirdQuarterBV
                        ) + "%"
                }
                if (reports[index-1].thirdQuarterRP!=0.0) {
                    reports[index].compareThirdQuarterRP =
                        DoubleUtil.formatTWODigits(
                            DoubleUtil.sub(
                                reports[index].thirdQuarterRP,
                                reports[index - 1].thirdQuarterRP
                            ) / reports[index - 1].thirdQuarterRP
                        ) + "%"
                }
                if (reports[index-1].thirdQuarterDeductRP!=0.0) {
                    reports[index].compareThirdQuarterDeductRP =
                        DoubleUtil.formatTWODigits(
                            DoubleUtil.sub(
                                reports[index].thirdQuarterDeductRP,
                                reports[index - 1].thirdQuarterDeductRP
                            ) / reports[index - 1].thirdQuarterDeductRP
                        ) + "%"
                }

                //年报
                if (reports[index-1].yearBV!=0.0) {
                    reports[index].compareYearBV =
                        DoubleUtil.formatTWODigits(
                            DoubleUtil.sub(
                                reports[index].yearBV,
                                reports[index - 1].yearBV
                            ) / reports[index - 1].yearBV
                        ) + "%"
                }
                if (reports[index-1].yearRP!=0.0) {
                    reports[index].compareYearRP =
                        DoubleUtil.formatTWODigits(
                            DoubleUtil.sub(
                                reports[index].yearRP,
                                reports[index - 1].yearRP
                            ) / reports[index - 1].yearRP
                        ) + "%"
                }
                if (reports[index-1].yearDeductRP!=0.0) {
                    reports[index].compareYearDeductRP =
                        DoubleUtil.formatTWODigits(
                            DoubleUtil.sub(
                                reports[index].yearDeductRP,
                                reports[index - 1].yearDeductRP
                            ) / reports[index - 1].yearDeductRP
                        ) + "%"
                }
            }
        }
        reportLiveData.value=reports
    }

    fun getEPS(number:String){
        val eps=RoomManage.roomDataBase.getEPSDao().findAllByNumber(number)
        epsLiveData.value=eps
    }
}