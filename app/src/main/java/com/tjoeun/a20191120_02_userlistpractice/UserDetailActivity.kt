package com.tjoeun.a20191120_02_userlistpractice

import android.os.Bundle
import com.tjoeun.a20191114_01_okhttp.utils.ConnectServer
import com.tjoeun.a20191120_02_userlistpractice.data.CategoryData
import kotlinx.android.synthetic.main.activity_user_detail_activity.*
import org.json.JSONObject

class UserDetailActivity : BaseActivity() {

    var categoryList = ArrayList<CategoryData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail_activity)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
    }

    override fun setValues() {

    }

    fun getUserCategoryFromJson(){
        ConnectServer.getRequestUserCategory(mContext, object : ConnectServer.jsonResponseHandler{
            override fun onResponse(json: JSONObject) {
                var code = json.getInt("code")

                if(code == 200){
                    val data = json.getJSONObject("data")
                    val categoryArr = data.getJSONArray("user_categories")

                    for(i in 0..categoryArr.length()-1){

                    }
                }
            }
        }
    }
}
