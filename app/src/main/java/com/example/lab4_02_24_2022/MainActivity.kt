package com.example.lab4_02_24_2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ImageView.ScaleType
import android.widget.TextView
import android.widget.Toast
import android.graphics.Bitmap
import com.android.volley.Request
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {

    private val httpTextView: TextView
        get() = findViewById(R.id.http_text)

    private val httpButton: Button
        get() = findViewById(R.id.http_button)

    private val httpImageView: ImageView
        get() = findViewById(R.id.http_imageView)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nextImg: NextImage = NextImage()

        httpButton.setOnClickListener {
//            getText("https://google.com")
            httpTextView.text = (nextImg.linearNextImageCapt())
            getImage(nextImg.linearNextImage())
        }
    }

//    private fun getText(urlText: String) {
//        val queue = Volley.newRequestQueue(this)
//
//        val stringRequest = StringRequest(
//            Request.Method.GET,
//            urlText,
//            {response ->
//                httpTextView.text = "${response.substring(0,500)}"
////                Toast.makeText(baseContext, "${response.substring(0,500)}", Toast.LENGTH_LONG).show()
//            },
//            {httpTextView.text = "Error!"})
//
//        queue.add(stringRequest)
//    }

    private fun getImage(urlText: String) {
        val queue = Volley.newRequestQueue(this)

//        val uri = android.net.Uri.parse("https://images.metmuseum.org/CRDImages/ep/web-large/DT1567.jpg")
//        val uri = "https://images.metmuseum.org/CRDImages/ep/web-large/DT1567.jpg"
//        val uri = urlText
        var imageRequest = ImageRequest(
            urlText,
            {response ->
                httpImageView.setImageBitmap(response)},
            0,
            0,
            ImageView.ScaleType.CENTER_INSIDE,
            null
        ) { error -> Toast.makeText(this@MainActivity, error.toString(), Toast.LENGTH_LONG).show() }

        queue.add(imageRequest)
    }
}