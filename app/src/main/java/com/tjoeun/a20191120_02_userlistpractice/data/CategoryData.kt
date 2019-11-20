package com.tjoeun.a20191120_02_userlistpractice.data

import org.json.JSONObject
import java.io.Serializable

class CategoryData() : Serializable{
    var id = 0
    var title = ""
    var color = ""

    companion object{
        fun getCategoryFromJson(json: JSONObject) : CategoryData{
            var categoryData = CategoryData()
            categoryData.id = json.getInt("id")
            categoryData.title= json.getString("title")
            categoryData.color= json.getString("color")

            return categoryData
        }
    }
}