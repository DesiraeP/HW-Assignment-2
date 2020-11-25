package org.csuf.cpsc411.hw2
//Desirae Prather
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


open class MainActivity : AppCompatActivity() {
     var cService= ClaimService(this)
     lateinit var cObj:Claim
    fun refreshScreen(){
        val claimTitle:EditText=findViewById(R.id.claim_title)
        val date:EditText=findViewById(R.id.date)
        claimTitle.setText(null)
        refreshStatus()
        date.setText(null)

    }
    fun refreshStatus(){
        val status:TextView=findViewById(R.id.Status)
        if(cService.state) {
            status.setText("Claim ${cObj.title} was successfully created.")
        }
        else
            status.setText("Claim ${cObj.title} failed to be created.")

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fld = ObjDetailScreenGenerator(this)
        val screen =fld.generate()
        setContentView(screen)
        //
        val bView : Button = findViewById(R.id.add_btn)

        bView.setOnClickListener{
            // add claim
            var claimTitle:EditText =findViewById(R.id.claim_title)
            var date:EditText=findViewById(R.id.date)
            var sTitle:String =claimTitle.text.toString()
            var sDate:String=date.text.toString()
            Log.d("Add","Title:${sTitle},Date:${sDate}")
            cObj=Claim(sTitle,sDate)
            cService.addClaim(cObj)
            refreshScreen()

        }
    }
}