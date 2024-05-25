package com.example.webviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        // Set the custom WebViewClient
        webView.setWebViewClient(new MyBrowser());

        // Show progress bar initially and load URL
        showProgress();
        webView.loadUrl(url);
    }

    private void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            showProgress();
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon) {
            showProgress();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            hideProgress();
        }
    }
}
