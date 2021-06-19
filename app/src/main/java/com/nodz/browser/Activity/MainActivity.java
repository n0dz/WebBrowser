package com.nodz.browser.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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

        binding.homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HomeScreen.class));
            }
        });

        if(getIntent().getIntExtra("type",0) == 1)
            binding.webView.loadUrl("https://www.google.com/search?q="+getIntent().getStringExtra("query"));
        if(getIntent().getIntExtra("type",0) == 2)
            binding.webView.loadUrl("https://www.google.com/search?q="+getIntent().getStringExtra("queryFrag"));

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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && this.binding.webView.canGoBack()){
            this.binding.webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }



}