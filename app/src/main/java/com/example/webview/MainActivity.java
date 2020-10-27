package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private EditText urlText;
    private Button goButton;
    private WebView webView;
    private ImageView imgBack,imgForward;
    private String temp="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlText = (EditText) findViewById(R.id.urlfield);
        goButton = (Button) findViewById(R.id.btn_go);
        webView = (WebView) findViewById(R.id.web_View);
        webView.setWebViewClient(new MyWebViewClient());
        imgBack =(ImageView) findViewById(R.id.img_back);
        imgForward =(ImageView) findViewById(R.id.img_foward);
        init();

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBrowser();
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(webView.canGoBack()){
                    webView.goBack();
                //    urlText.setText(webView.getUrl());
                }
            }
        });

        imgForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(webView.canGoForward()){
                    webView.goForward();
                   // urlText.setText(webView.getUrl());
                }
            }
        });

        urlText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    openBrowser();
                    return true;
                }
                return false;
            }
        });
    }

    private void init() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("http://youtube.com/");
       webView.requestFocus();
    }


    private void openBrowser() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("http://youtube.com/results?search_query=" + urlText.getText().toString().trim());
        webView.requestFocus();

        urlText.setText(urlText.getText().toString());
    }

}
