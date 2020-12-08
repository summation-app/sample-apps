package app.summation.android.demo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun gatewayQuery(view: View) {
        val activity = GatewayQueryResultActivity()
        val intent = Intent(applicationContext, activity.javaClass)
        startActivity(intent)
    }

    fun gatewayRead(view: View) {
        val activity = GatewayReadResultActivity()
        val intent = Intent(applicationContext, activity.javaClass)
        startActivity(intent)
    }

    fun gatewayGet(view: View) {
        val activity = GatewayGetResultActivity()
        val intent = Intent(applicationContext, activity.javaClass)
        startActivity(intent)
    }

}