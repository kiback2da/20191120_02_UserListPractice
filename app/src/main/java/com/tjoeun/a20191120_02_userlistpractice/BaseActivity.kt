package com.tjoeun.a20191120_02_userlistpractice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    var mContext : Context = this

    abstract fun setupEvents()
    abstract fun setValues()
}