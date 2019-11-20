package com.tjoeun.a20191120_02_userlistpractice.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.tjoeun.a20191120_02_userlistpractice.R
import com.tjoeun.a20191120_02_userlistpractice.data.CategoryData
import com.tjoeun.a20191120_02_userlistpractice.data.UserData

class UserListAdapter(context: Context, res:Int, list:ArrayList<UserData>) : ArrayAdapter<UserData>(context, res, list) {

    var mContext = context
    var mList = list
    var inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if(tempRow == null){
            tempRow = inf.inflate(R.layout.user_list_item, null)
        }

        var row = tempRow!!
        var listData = mList.get(position)
        var loginId = row.findViewById<TextView>(R.id.userListTxtId)
        var name = row.findViewById<TextView>(R.id.userListTxtUserName)
        var color = row.findViewById<ImageView>(R.id.userListItemImgCategoryColor)

        var categoryData = listData.categoryData

        loginId.text = listData.loginId
        name.text = listData.name
        color.setBackgroundColor(Color.parseColor(categoryData?.color))

        return row
    }



    constructor(context: Context, list: ArrayList<UserData>) : this(context,R.layout.user_list_item,list)
}