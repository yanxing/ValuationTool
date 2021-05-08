package com.yanxing.valuation.dao

import android.content.Context
import androidx.room.Room

object RoomManage {

    lateinit var roomDataBase: AbstractRoomBase
    private const val DATABASE_NAME="valuation_tool"

    /**
     * 初始化数据库
     */
    fun init(context: Context){
        roomDataBase = Room.databaseBuilder(context, AbstractRoomBase::class.java, DATABASE_NAME)
            .allowMainThreadQueries()
            .build()
    }
}