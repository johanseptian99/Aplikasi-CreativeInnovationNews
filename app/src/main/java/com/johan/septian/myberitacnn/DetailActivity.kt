package com.johan.septian.myberitacnn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.johan.septian.myberitacnn.model.ItemNews

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_URL = "extra_url"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val item = intent.getParcelableExtra<ItemNews>(EXTRA_URL)

        val webView = findViewById<WebView>(R.id.webView)

        webView.settings.javaScriptEnabled = true

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                view.loadUrl("javascript:alert('detail ${item?.judul} dimuat')")
            }
        }
        webView.loadUrl("${item?.link}")

    }
}