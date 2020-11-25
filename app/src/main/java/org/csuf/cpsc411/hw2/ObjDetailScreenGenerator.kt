package org.csuf.cpsc411.hw2

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class ObjDetailScreenGenerator (val ctx : Context){
    lateinit var layoutObj : LinearLayout
    fun generate() : LinearLayout {
        layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.WHITE)

        //add Title layout
        var lbl = Title()
        layoutObj.addView(lbl)

        //add ObjDetail Section
        val oGenerator = ObjDetailSectionGenerator(ctx)
        var lblView = oGenerator.generate()
        layoutObj.addView(lblView)

        //add Add Button
        val aLayout = LinearLayout(ctx)
        val aParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        aParams.gravity =Gravity.RIGHT
        aParams.weight=  0.0F
        aLayout.layoutParams = aParams
        aLayout.orientation = LinearLayout.HORIZONTAL
        aLayout.setBackgroundColor(Color.BLUE)
        //
        val aButton= Button(ctx)
        aButton.text="Add"
        aButton.setId(R.id.add_btn)
        aButton.setBackgroundColor(Color.WHITE)
        val abParams=LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        //abParams.gravity=Gravity.BOTTOM
        abParams.setMargins(5,5,5,5)
        aLayout.addView(aButton,abParams)
        layoutObj.addView(aLayout)
        //
        var status = Status()
        layoutObj.addView(status)


        return layoutObj
    }

    fun Title():LinearLayout{
       var lLayout =LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        lLayout.layoutParams = lParams
        lLayout.orientation = LinearLayout.HORIZONTAL
        lLayout.setBackgroundColor(Color.WHITE)
        val tParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT)
        var lbl = TextView(ctx)
          lbl.text = "Please Enter Claim Information"
          lbl.gravity=Gravity.CENTER
          lbl.setTypeface(Typeface.DEFAULT_BOLD)
          lbl.setBackgroundColor(Color.WHITE)
          lLayout.addView(lbl, tParams)
        return lLayout
    }
    fun Status():LinearLayout{
        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.HORIZONTAL
        //
        val lblView = TextView(ctx)
        lblView.text = "        Status:"
        lblView.setBackgroundColor(Color.WHITE)
        val lbParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        lbParams.weight = 1.0F
        lbParams.gravity=Gravity.RIGHT
        layoutObj.addView(lblView, lbParams)
        //
        var valView = TextView(ctx)
        valView.setId(R.id.Status)
        valView.setText(" <Status Message>")
       // valView.setEnabled(false)
        valView.setTextSize(15F)
        valView.setTextColor(Color.BLACK)
        valView.setBackgroundColor(Color.WHITE)
        val vParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT)
        vParams.weight = 4.0F
        layoutObj.addView(valView, vParams)

        return layoutObj
    }
}