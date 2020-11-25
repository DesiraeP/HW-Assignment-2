package org.csuf.cpsc411.hw2

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout

class ValueColumnGenerator(val ctx : Context) {
    fun generate() : LinearLayout {
        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.BLUE)
        //
        val vParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)

        var value = EditText(ctx)
        value.setId(R.id.claim_title)
        value.setHint("Enter Claim Title")
        value.setBackgroundColor(Color.WHITE)
        layoutObj.addView(value, vParams)
        val v2Params = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        v2Params.topMargin = 5
        v2Params.bottomMargin=5
        value = EditText(ctx)
        value.setId(R.id.date)
        value.setHint("Enter Date")
        value.setBackgroundColor(Color.WHITE)
        layoutObj.addView(value, v2Params)

        return layoutObj
    }
}