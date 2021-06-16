package com.nodz.browser.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.nodz.browser.R;
import com.nodz.browser.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        customWebViewClient client = new customWebViewClient(this);

        binding.webView.setWebViewClient(client);
        binding.webView.getSettings().setJavaScriptEnabled(true);
        binding.webView.loadUrl("https://www.google.com/search?q="+getIntent().getStringExtra("query"));

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && this.binding.webView.canGoBack()){
            this.binding.webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }


    class customWebViewClient extends WebViewClient {
        private Activity activity;

        public customWebViewClient(Activity activity) {
            this.activity = activity;
        }

        // API >= 24
        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest request) {
            return false;
            // To avoid loading links in web browser
        }

        // API < 24
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }
}