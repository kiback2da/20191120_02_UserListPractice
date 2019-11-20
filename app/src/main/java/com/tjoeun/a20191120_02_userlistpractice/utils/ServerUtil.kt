package com.tjoeun.a20191114_01_okhttp.utils

import android.content.Context
import android.util.Log
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ServerUtil {

    interface jsonResponseHandler{
        fun onResponse(json : JSONObject)
    }

    companion object {
        //어느 서버에 접속할지 서버 주소를 저장하는 변수
        var BASE_URL = "http://192.168.0.26:5000"

        fun getRequestBankInfo(context: Context, handler: ServerUtil.jsonResponseHandler){
            var client = OkHttpClient()
            var urlBuilder = HttpUrl.parse("${BASE_URL}/info/bank")!!.newBuilder()
            //파라미터 첨부가 필요없다.
            var requestUrl = urlBuilder.build().toString()
            var request = Request.Builder().url(requestUrl).build()

            client.newCall(request).enqueue(object : Callback{
                override fun onFailure(call: Call, e: IOException) {
                    Log.d("로그","서버 통신 에러")
                }

                override fun onResponse(call: Call, response: Response) {
                    Log.d("로그 : onResponse","onResponse")
                    var body = response.body()!!.string()
                    Log.d("로그 : onResponse","${body}")
                    var json = JSONObject(body)
                    handler?.onResponse(json)
                }

            })
        }

        fun getRequestDeliveryListInfo(context: Context, handler: ServerUtil.jsonResponseHandler){
            var client = OkHttpClient()
            var urlBuilder = HttpUrl.parse("${BASE_URL}/info/company")!!.newBuilder()
            //파라미터 첨부가 필요없다.
            var requestUrl = urlBuilder.build().toString()
            var request = Request.Builder().url(requestUrl).build()

            client.newCall(request).enqueue(object : Callback{
                override fun onFailure(call: Call, e: IOException) {
                    Log.d("로그","서버 통신 에러")
                }

                override fun onResponse(call: Call, response: Response) {
                    Log.d("로그 : onResponse","onResponse")
                    var body = response.body()!!.string()
                    Log.d("로그 : onResponse","${body}")
                    var json = JSONObject(body)
                    handler?.onResponse(json)
                }

            })
        }
    }

}