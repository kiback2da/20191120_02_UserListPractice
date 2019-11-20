package com.tjoeun.a20191120_02_userlistpractice.data

import org.json.JSONObject
import java.io.Serializable

class UserData() : Serializable{

    var loginId = ""
    var name = ""
    var categoryData : CategoryData? = null

    companion object{
        fun getUserFromJson(json:JSONObject) : UserData{
            var userData = UserData()
            userData.loginId = json.getString("login_id")
            userData.name = json.getString("name")
            userData.categoryData = CategoryData.getCategoryFromJson(json.getJSONObject("category"))

            return userData
        }
    }

}