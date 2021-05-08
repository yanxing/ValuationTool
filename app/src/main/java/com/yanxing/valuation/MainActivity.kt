package com.yanxing.valuation


import com.yanxing.valuation.dao.RoomManage
import com.yanxing.valuation.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutResID(): Int {
        return R.layout.activity_main
    }


    override fun afterInstanceView() {
        RoomManage.init(this)
        viewBinding.title.text="测试"

    }


}