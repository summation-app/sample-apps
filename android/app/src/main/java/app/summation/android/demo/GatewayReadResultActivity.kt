package app.summation.android.demo

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import app.summation.android.Client
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser

class GatewayReadResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gateway_read_result)
        setTitle("Gateway Read Result")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //gateway read
        Thread({
            val client = Client(
                gatewayUrl = "http://162.223.31.136:8000",
                token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdW1tYXRpb24iLCJzdWIiOiJhZG1pbiIsInVpZCI6MCwib3JnYW5pemF0aW9uX2lkIjowLCJyb2xlX2lkIjowfQ.LWURX-7KPQqnAFLU4aF2W3di-MnhlyO3wVkhz7K2pzZi1XFUFXws7m0BnvBwQd70d39cWlmpOTCwG2RN8UD4bvaW9bfnv-qhEauYyNaXWbvSquTNKM5lrBxa4oIiNGmKfMYL3BNHqsl655z4p_3eMqkSZRXhgLroBeC7RPbSojBrr7zoAotLadBB0ImFYoffN4PdVK0AQFL9Kcz2C1FbliRd7HU9070REdRiuAKtAsg4Cl_vM0rHbUabgZoMaxKWbg5y-XBwSlKykYTqF58jqnHCoeNYdxPBlPiK4lBzXu3dtX2gqBq_4XMSWAGM6VKUw8G9l7DKl3klQV_JKKSz9w",
                gatewayToken = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdW1tYXRpb24iLCJzdWIiOiJhZG1pbiIsInVpZCI6MCwib3JnYW5pemF0aW9uX2lkIjowLCJhcHBsaWNhdGlvbl9pZCI6MCwicm9sZV9pZCI6MCwic2NvcGUiOiJkZXZlbG9wbWVudCIsImV4cCI6MjIzNzkwMjAyMy4zOTkyNDQzfQ.ROgO4hzjK0UCc1Ar_2-O0Q0ZsN5SHx-QEXAWkPC7QaoA8YEgWqTQeFGvZ6s8e94THGFFbJtQkvlfoJ9RWyDlgi4N8IIsHu3eM1eO1HxmhdZp3kSpMKSGvkRZ4jrGpFEHYLXQM8L1oMVghwfJHbRU7JywXlAvYArmpa3jw1_LVw3DUzojjJ6fv30OQJRz0dDACdxyqkvyVfA4ebNC2KWUjd_XMnIMvQxU4FJFAEVwW_Q2pJrucNb4GwswQuRvTUseXFYrP4XoFDag_iZe5chrNqJSAJFhvnSO9Px-HINqzein6zyE50-B30xiN8CwUGvAOt5v9qH11-Of4qEo51S8Uw",
                defaultDatabase = "summation",
            )
            val params = HashMap<String, Any>()
            params.put("id", 1)
            val response = client.read("Queries", params)
            if (response != null) {
                Log.d("READ", response)
                val parser: Parser = Parser.default()
                val stringBuilder: StringBuilder = StringBuilder(response)
                val json: JsonObject = parser.parse(stringBuilder) as JsonObject
                runOnUiThread({
                    val processBar: ProgressBar = findViewById(R.id.progressBar)
                    processBar.visibility = View.GONE
                    val textView: TextView = findViewById(R.id.textView)
                    textView.text = json.toJsonString(true)
                })
            }
        }).start()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}