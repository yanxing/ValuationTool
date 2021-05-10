package com.yanxing.valuation


import android.content.Intent
import android.text.TextUtils
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yanxing.valuation.base.BaseActivity
import com.yanxing.valuation.dao.DataDealViewModel
import com.yanxing.valuation.dao.RoomManage
import com.yanxing.valuation.databinding.ActivityMainBinding
import com.yanxing.valuation.model.Company
import com.yanxing.valuation.util.DoubleUtil
import com.yanxing.valuation.util.RecyclerViewAdapter

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutResID(): Int {
        return R.layout.activity_main
    }

    private fun cal(){
        val meigushouyi=viewBinding.meigushouyi.text.toString()
        val zongguben=viewBinding.zongguben.text.toString()
        if (!TextUtils.isEmpty(meigushouyi)&&(!TextUtils.isEmpty(zongguben))){
            viewBinding.result.text = DoubleUtil.formatTWODigits(meigushouyi.toDouble()*zongguben.toDouble())
        }

        val shizhi=viewBinding.shiZhi.text.toString()
        val yucejinglirun=viewBinding.jinglirun.text.toString()
        if (!TextUtils.isEmpty(shizhi)&&(!TextUtils.isEmpty(yucejinglirun))){
            viewBinding.result2.text=DoubleUtil.formatTWODigits(shizhi.toDouble()/yucejinglirun.toDouble())
        }


        val mubiaoshiyinglv=viewBinding.mubiaoshiyinglv.text.toString()
        val dangqianshiyinglv=viewBinding.dangqianshiyinglv.text.toString()
        val meigujiage=viewBinding.meigujiage.text.toString()
        if (!TextUtils.isEmpty(mubiaoshiyinglv)&&(!TextUtils.isEmpty(dangqianshiyinglv))&&(!TextUtils.isEmpty(meigujiage))){
            viewBinding.result3.text=DoubleUtil.formatTWODigits(mubiaoshiyinglv.toDouble()/dangqianshiyinglv.toDouble()*meigujiage.toDouble())
        }
    }

    override fun afterInstanceView() {
        RoomManage.init(this)
        viewBinding.button.setOnClickListener {
            cal()
        }
        viewBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        ViewModelProvider(this).get(DataDealViewModel::class.java).apply {
            getCompany()
            companyLiveData.observe(this@MainActivity, Observer {
                viewBinding.recyclerView.adapter =
                    object : RecyclerViewAdapter<Company>(it, R.layout.adapter_company) {
                        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                            super.onBindViewHolder(holder, position)
                            mDataList[position]?.apply {
                                holder.setText(R.id.name,name)
                            }
                        }
                    }.apply {
                        setOnItemClick { _, position ->
                            val intent = Intent(this@MainActivity, HistoryActivity::class.java)
                            intent.putExtra("number", it[position].number)
                            startActivity(intent)
                        }
                    }
            }
            )
        }
    }

    //根据分析师预测每股收益，输入总股本，计算该年净利润
    //根据财报预测净利润，输入当前市值，计算当前市盈率
    //输入想买入的市盈率，以及当前市盈率，再输入当前股价，计算目标买入股价


}