package org.csuf.cpsc411.hw2

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import java.io.InterruptedIOException

class ClaimService(val ctx : MainActivity) {
var state:Boolean=false
inner class addServiceRespHandler:AsyncHttpResponseHandler(){
    override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?) {
        if (responseBody != null) {
            val respStr = String(responseBody)
            Log.d("Claim Service", "The add Service response : ${respStr}")
             state=true
            (ctx as MainActivity).refreshStatus()// This will show add is successful

        }
    }

    override fun onFailure(
        statusCode: Int,
        headers: Array<out Header>?,
        responseBody: ByteArray?,
        error: Throwable?
    ) {
        if (responseBody != null) {
            val respStr = String(responseBody)
            Log.d("Claim Service", "The add Service failed response : ${respStr}")
            state=false
            (ctx as MainActivity).refreshStatus()
        }
    }

}
    fun addClaim(cObj:Claim){
        val claim = AsyncHttpClient()
        val requestUrl = "http://192.168.0.134:8010/ClaimService/add"
        // convert the cobj into JSON string
        val cJsonString= Gson().toJson(cObj)
        // send the post request
        val entity = StringEntity(cJsonString)
        Log.d("Entity","${entity}")
        Log.d("Json","${cJsonString}")
        state=false //My onFailure is not working so this is used for when the restful server is not running

        claim.post(ctx,requestUrl,entity,"application/Json",addServiceRespHandler())
    }
}