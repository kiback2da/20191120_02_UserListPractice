package com.tjoeun.a20191120_02_userlistpractice.data

import org.json.JSONObject

class UserData(loginId:String, name:String) {

    var mLoginId = loginId
    var mName = name

    companion object{
        fun getCategory(json:JSONObject) : CategoryData{
            var categoryData = CategoryData()
            categoryData.id = json.getInt("id")
            categoryData.title = json.getString("title")
            categoryData.color = json.getString("color")

            return categoryData
        }
    }

}