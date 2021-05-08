package com.yanxing.valuation

import androidx.lifecycle.ViewModelProvider
import com.yanxing.valuation.dao.RoomManage
import com.yanxing.valuation.databinding.ActivityHistoryBinding
import com.yanxing.valuation.model.Report
import com.yanxing.valuation.util.RecyclerViewAdapter

class HistoryActivity :BaseActivity<ActivityHistoryBinding>() {

    override fun getLayoutResID(): Int {
        return R.layout.activity_history
    }

    override fun afterInstanceView() {
        val companys=RoomManage.mRoomDataBase.getCompanyDao().findAll()
        ViewModelProvider(this).get(DataDealViewModel::class.java).apply {
            deal(companys)
            liveData.observe(this@HistoryActivity, {

                viewBinding.recyclerView.adapter=object :
                    RecyclerViewAdapter<ArrayList<Report>>(it,R.layout.adapter_company){

                    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                        super.onBindViewHolder(holder, position)
                        mDataList[position]?.apply {
                            if (position==0){
                                this.get(0).name
                            }
                        }
                    }
                }
            })
        }


    }

}