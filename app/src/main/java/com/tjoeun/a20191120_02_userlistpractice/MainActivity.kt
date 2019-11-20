package com.tjoeun.a20191120_02_userlistpractice

import android.os.Bundle
import com.tjoeun.a20191114_01_okhttp.utils.ConnectServer
import com.tjoeun.a20191120_02_userlistpractice.adapter.UserListAdapter
import com.tjoeun.a20191120_02_userlistpractice.data.UserData
import kotlinx.android.synthetic.main.activity_main.*
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
        getUserListFromJson()

        mainListView.adapter = UserListAdapter(mContext,userList)
    }


    fun getUserListFromJson(){
        ConnectServer.getRequestUserInfo(mContext,"ALL", object : ConnectServer.jsonResponseHandler{
            override fun onResponse(json: JSONObject) {
                val data = json.getJSONObject("data")
                val userArr = data.getJSONArray("users")

                for (i in 0..(userArr.length()-1)){
                    val userDetail = userArr.getJSONObject(i)
                    val userData = UserData.getUserFromJson(userDetail)

                    userList.add(userData)
                }
            }
        })
    }
}
