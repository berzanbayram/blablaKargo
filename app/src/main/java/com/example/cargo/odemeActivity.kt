package com.example.cargo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.stripe.android.paymentsheet.PaymentSheet
import com.stripe.android.paymentsheet.PaymentSheetResult
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.IOException


class odemeActivity : AppCompatActivity() {


    companion object {
        private const val TAG = "odemeActivity"
        private const val BACKEND_URL = "https://grim-scarecrow-64378.herokuapp.com"
    }

    private lateinit var paymentIntentClientSecret: String
    private lateinit var paymentSheet: PaymentSheet

    private lateinit var payButton: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_odeme)


        payButton = findViewById(R.id.btnAlGonder2)
        payButton.setOnClickListener(::onPayClicked)
        payButton.isEnabled = false

        paymentSheet = PaymentSheet(this, ::onPaymentSheetResult)

        fetchPaymentIntent()

    }

    private fun fetchPaymentIntent() {
        val url = "$BACKEND_URL/create-payment-intent"

        val shoppingCartContent = """
            {
                "items": [
                    {"id":"xl-tshirt"}
                ]
            }
        """

        val amount : Int = 20000



        val mediaType = "application/json; charset=utf-8".toMediaType()

        val body = shoppingCartContent.toRequestBody(mediaType)
        val request = Request.Builder()
            .url(url)
            .post(body)
            .build()

        OkHttpClient()
            .newCall(request)
            .enqueue(object: Callback {
                override fun onFailure(call: Call, e: IOException) {
                    showAlert("Failed to load data", "Error: $e")
                }

                override fun onResponse(call: Call, response: Response) {
                    if (!response.isSuccessful) {
                        showAlert("Failed to load page", "Error: $response")
                    } else {
                        val responseData = response.body?.string()
                        val responseJson = responseData?.let { JSONObject(it) } ?: JSONObject()
                        paymentIntentClientSecret = responseJson.getString("clientSecret")
                        runOnUiThread { payButton.isEnabled = true }
                        Log.i(TAG, "Retrieved PaymentIntent")
                    }
                }
            })
    }



    private fun onPayClicked(view: View) {
        val configuration = PaymentSheet.Configuration("Example, Inc.")

        // Present Payment Sheet
        paymentSheet.presentWithPaymentIntent(paymentIntentClientSecret, configuration)
    }


    private fun showAlert(title: String, message: String? = null) {
        runOnUiThread {
            val builder = AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
            builder.setPositiveButton("Ok", null)
            builder.create().show()
        }
    }

    private fun showToast(message: String) {
        runOnUiThread {
            Toast.makeText(this,  message, Toast.LENGTH_LONG).show()
        }
    }

    private fun onPaymentSheetResult(paymentResult: PaymentSheetResult) {
        when (paymentResult) {
            is PaymentSheetResult.Completed -> {
                showToast("Payment complete!")

                val intent = Intent(this, KargolarimActivity::class.java)
                startActivity(intent)

            }
            is PaymentSheetResult.Canceled -> {
                Log.i(TAG, "Payment canceled!")
            }
            is PaymentSheetResult.Failed -> {
                showAlert("Payment failed", paymentResult.error.localizedMessage)
            }
        }

    }

}