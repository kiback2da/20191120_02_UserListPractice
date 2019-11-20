package com.tjoeun.a20191120_02_userlistpractice

import android.os.Bundle
import com.tjoeun.a20191114_01_okhttp.utils.ConnectServer
import com.tjoeun.a20191120_02_userlistpractice.data.UserData
import org.json.JSONObject

class MainActivity : BaseActivity() {

    var userList = ArrayList<UserData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
    }

    override fun setValues() {
        ConnectServer.getRequestUserInfo(mContext,"active", object : ConnectServer.jsonResponseHandler{
            override fun onResponse(json: JSONObject) {
                val data = json.getJSONObject("data")
                val users = data.getJSONArray("users")

                for (user in 0..(users.length()-1)){

                }
            }
        })
    }
}
