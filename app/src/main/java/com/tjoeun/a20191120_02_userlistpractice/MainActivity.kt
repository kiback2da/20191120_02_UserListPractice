package com.tjoeun.a20191120_02_userlistpractice

import android.os.Bundle
import com.tjoeun.a20191114_01_okhttp.utils.ConnectServer
import com.tjoeun.a20191120_02_userlistpractice.adapter.UserListAdapter
import com.tjoeun.a20191120_02_userlistpractice.data.UserData
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : BaseActivity() {

    var userList = ArrayList<UserData>()
    var userAdapter : UserListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
    }

    override fun setValues() {
        userAdapter = UserListAdapter(mContext,userList)
        mainListView.adapter = userAdapter
    }

    override fun onResume() {
        super.onResume()

        getUserListFromJson()
    }


    fun getUserListFromJson(){
        ConnectServer.getRequestUserInfo(mContext,"ALL", object : ConnectServer.jsonResponseHandler{
            override fun onResponse(json: JSONObject) {
                var code = json.getInt("code")
                val data = json.getJSONObject("data")
                val userArr = data.getJSONArray("users")

                if(code == 200) {
                    //기존 데이터 삭제 (중복방지)
                    userList.clear()
                    for (i in 0..(userArr.length() - 1)) {
                        val userDetail = userArr.getJSONObject(i)
                        val userData = UserData.getUserFromJson(userDetail)

                        userList.add(userData)
                    }

                    runOnUiThread {
                        userAdapter?.notifyDataSetChanged()
                    }
                }
            }
        })
    }
}
