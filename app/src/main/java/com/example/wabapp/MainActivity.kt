package com.example.wabapp

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.wabapp.ui.theme.WabAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WabAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    webScreen()
                }
            }
        }
    }
}

@Composable
fun webScreen() {
    AndroidView(factory = {
        contex->
        return@AndroidView WebView(contex).apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
        }
    },
        update = {
            it.loadUrl("https://github.com/Akash05-kr")
        })
    
}