package com.yanxing.valuation.util

import android.content.Context
import android.content.res.AssetManager
import com.google.gson.Gson
import com.yanxing.valuation.model.Report
import org.json.JSONArray
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


fun getYaoMingReport(context: Context): List<Report> {
    val json = getAssets(context, "yaomingkangde.json")
    val reports = ArrayList<Report>()
    try {
        val jsonArray = JSONArray(json)
        for (index in 0..jsonArray.length()) {
            reports.add(Gson().fromJson(jsonArray[index].toString(), Report::class.java))
        }
    } catch (e: Exception) {
        e.message
    }
    return reports
}

fun Gson.getLongJi(context: Context): List<Report> {
    val json = getAssets(context, "longji.json")
    val reports = ArrayList<Report>()
    try {
        val jsonArray = JSONArray(json)
        for (index in 0..jsonArray.length()) {
            reports.add(Gson().fromJson(json[index].toString(), Report::class.java))
        }
    } catch (e: Exception) {
    }
    return reports
}

private fun getAssets(context: Context, fileName: String): String {
    val stringBuilder = StringBuilder()
    try {
        val assetManager: AssetManager = context.assets
        val bf = BufferedReader(InputStreamReader(assetManager.open(fileName)))
        var line: String?
        while (bf.readLine().also { line = it } != null) {
            stringBuilder.append(line)
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return stringBuilder.toString()
}