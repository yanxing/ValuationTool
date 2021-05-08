package com.yanxing.valuation


import android.content.Intent
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yanxing.valuation.base.BaseActivity
import com.yanxing.valuation.dao.DataDealViewModel
import com.yanxing.valuation.dao.RoomManage
import com.yanxing.valuation.databinding.ActivityMainBinding
import com.yanxing.valuation.model.Company
import com.yanxing.valuation.util.RecyclerViewAdapter

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutResID(): Int {
        return R.layout.activity_main
    }

    override fun afterInstanceView() {
        RoomManage.init(this)
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


}