package com.example.profilfakultas

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("Registered")
class FakWeb : AppCompatActivity() {
    // Inisiasi Javascript
    @SuppressLint("Registered")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setting Layout
        setContentView(R.layout.web_fakultas)

        // Inisiasi WebView
        val webView = findViewById<WebView>(R.id.webview)

        // Inisiasi Intent
        val intentFakultas = intent

        if (intentFakultas.hasExtra(Intent.ACTION_VIEW)) {
            // Grab Intent Detail Fac
            val partWeb = intentFakultas.getStringExtra(Intent.ACTION_VIEW)
            webView.settings.javaScriptEnabled = true

            // Proses Load Client -> Alert Javascript Created
            webView.webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView, url: String) {
                    view.loadUrl("javascript:alert('Load Website Success!')")
                }
            }

            // Alert Javascript -> Toast
            webView.webChromeClient = object : WebChromeClient() {
                override fun onJsAlert(
                    view: WebView,
                    url: String,
                    message: String,
                    result: JsResult
                ): Boolean {
                    Toast.makeText(this@FakWeb, message, Toast.LENGTH_LONG).show()
                    result.confirm()
                    return true
                }
            }

            // Parameter WebView Load
            webView.loadUrl(partWeb)
        }
    }
}