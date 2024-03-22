package com.example.webviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class WebViewActivity extends AppCompatActivity {
    WebView webView;
    TextView tvTitle;
    String url, title;
    ImageView ivBack;
    ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.webView);
        tvTitle = findViewById(R.id.tvTitle);
        ivBack = findViewById(R.id.ivBack);
        progressBar = findViewById(R.id.progressBar);

        Bundle bundle = getIntent().getExtras();
        title = bundle.getString("name", "Yakeerball");
        url = bundle.getString("url", "https://yakkerball.com/");

        tvTitle.setText(title);

        ivBack.setOnClickListener(v -> {
            finish();
        });

        hideProgress();

        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(url);
    }

    private void hideProgress() {
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
               progressBar.setVisibility(View.GONE);
            }
        }, 3000);
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}