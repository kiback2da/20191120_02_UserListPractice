package com.tjoeun.a20191120_02_userlistpractice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.tjoeun.a20191120_02_userlistpractice.R
import com.tjoeun.a20191120_02_userlistpractice.data.CategoryData

class UserListAdapter(context: Context, res:Int, list:ArrayList<CategoryData>) : ArrayAdapter<CategoryData>(context, res, list) {

    var mContext = context
    var mList = list
    var inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if(tempRow == null){
            tempRow = inf.inflate(R.layout.user_list_item, null)
        }

        var row = tempRow!!


        return row
    }



    constructor(context: Context, list: ArrayList<CategoryData>) : this(context,
        R.layout.user_list_item,list)
}