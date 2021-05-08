package com.yanxing.valuation.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(element: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(element: List<T>)

    @Update
    fun update(element: T)
}