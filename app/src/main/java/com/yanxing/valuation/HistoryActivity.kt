package com.yanxing.valuation

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yanxing.valuation.base.BaseActivity
import com.yanxing.valuation.dao.DataDealViewModel
import com.yanxing.valuation.databinding.ActivityHistoryBinding
import com.yanxing.valuation.model.EPS
import com.yanxing.valuation.model.Report
import com.yanxing.valuation.util.DoubleUtil
import com.yanxing.valuation.util.RecyclerViewAdapter

class HistoryActivity : BaseActivity<ActivityHistoryBinding>() {

    private lateinit var mReportAdapter: RecyclerViewAdapter<Report>
    private val mReports=ArrayList<Report>()
    private lateinit var mEPSAdapter:RecyclerViewAdapter<EPS>
    private val mEPS=ArrayList<EPS>()

    override fun getLayoutResID(): Int {
        return R.layout.activity_history
    }

    override fun afterInstanceView() {
        initReportAdapter()
        initEPSAdapter()
        intent.getStringExtra("number")?.let {
            ViewModelProvider(this).get(DataDealViewModel::class.java).apply {
                getReport(it)
                getEPS(it)
                reportLiveData.observe(this@HistoryActivity, {
                    mReports.addAll(it)
                    mReportAdapter.update(mReports)
                })
                epsLiveData.observe(this@HistoryActivity, {
                    mEPS.addAll(it)
                    mEPSAdapter.update(mEPS)
                })
            }
        }
    }

    private fun initReportAdapter(){
        viewBinding.reportRecyclerView.layoutManager=LinearLayoutManager(this)
        mReportAdapter=object :RecyclerViewAdapter<Report>(mReports,R.layout.adapter_report){
            override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                super.onBindViewHolder(holder, position)
                if (position==0){
                    holder.setText(R.id.first,getString(R.string.yijidu))
                    holder.setText(R.id.half,getString(R.string.zhongbao))
                    holder.setText(R.id.third,getString(R.string.erjidu))
                    holder.setText(R.id.year,getString(R.string.nianbao))
                }else{
                    mDataList[position-1]?.apply {
                        holder.setText(R.id.date,year.toString()+"年")
                        holder.setText(
                            R.id.first,
                            getString(R.string.yingyeshouru) + DoubleUtil.format(firstQuarterBV) + getString(
                                R.string.tongbizengzhang
                            ) + compareFirstQuarterBV + ")\n" +
                                    getString(R.string.jinglirun) + DoubleUtil.format(firstQuarterRP) + getString(
                                R.string.tongbizengzhang
                            ) + compareFirstQuarterRP + ")\n" +
                                    getString(R.string.koufeijinglirun) + DoubleUtil.format(
                                firstQuarterDeductRP
                            ) + getString(R.string.tongbizengzhang) + compareFirstQuarterDeductRP + ")"
                        )
                        holder.setText(
                            R.id.half,
                            getString(R.string.yingyeshouru) + DoubleUtil.format(halfYearBV) + getString(
                                R.string.tongbizengzhang
                            ) + compareHalfYearBV + ")\n" +
                                    getString(R.string.jinglirun) + DoubleUtil.format(halfYearRP) + getString(
                                R.string.tongbizengzhang
                            ) + compareHalfYearRP + ")\n" +
                                    getString(R.string.koufeijinglirun) + DoubleUtil.format(
                                halfYearDeductRP
                            ) + getString(R.string.tongbizengzhang) + compareHalfYearDeductRP + ")"
                        )
                        holder.setText(
                            R.id.third,
                            getString(R.string.yingyeshouru) + DoubleUtil.format(thirdQuarterBV) + getString(
                                R.string.tongbizengzhang
                            ) + compareThirdQuarterBV + ")\n" +
                                    getString(R.string.jinglirun) + DoubleUtil.format(thirdQuarterRP) + getString(
                                R.string.tongbizengzhang
                            ) + compareThirdQuarterRP + ")\n" +
                                    getString(R.string.koufeijinglirun) + DoubleUtil.format(
                                thirdQuarterDeductRP
                            ) + getString(R.string.tongbizengzhang) + compareThirdQuarterDeductRP + ")"
                        )
                        holder.setText(
                            R.id.year,
                            getString(R.string.yingyeshouru) + DoubleUtil.format(yearBV) + getString(
                                R.string.tongbizengzhang
                            ) + compareYearBV + ")\n" +
                                    getString(R.string.jinglirun) + DoubleUtil.format(yearRP) + getString(
                                R.string.tongbizengzhang
                            ) + compareYearRP + ")\n" +
                                    getString(R.string.koufeijinglirun) + DoubleUtil.format(
                                yearDeductRP
                            ) + getString(R.string.tongbizengzhang) + compareYearDeductRP + ")"
                        )
                    }
                }
            }

            override fun getItemCount(): Int {
                return super.getItemCount()+1
            }
        }
        viewBinding.reportRecyclerView.adapter=mReportAdapter
    }

    private fun initEPSAdapter(){
        viewBinding.epsRecyclerView.layoutManager=LinearLayoutManager(this)
        mEPSAdapter=object :RecyclerViewAdapter<EPS>(mEPS,R.layout.adapter_eps){
            override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                super.onBindViewHolder(holder, position)
                if (position==0){
                    holder.setText(R.id.date,getString(R.string.year_eps))
                    holder.setText(R.id.real,getString(R.string.real))
                    holder.setText(R.id.forecast,getString(R.string.forecast))
                }else{
                    mDataList[position-1]?.apply {
                        holder.setText(R.id.date,year.toString()+"年")
                        holder.setText(R.id.real,real)
                        holder.setText(R.id.forecast,forecast)
                    }
                }
            }

            override fun getItemCount(): Int {
                return super.getItemCount()+1
            }
        }
        viewBinding.epsRecyclerView.adapter=mEPSAdapter
    }

}