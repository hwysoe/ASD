package com.example.sme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomePage extends AppCompatActivity {
    Button _shopeeBtn;
    Button _lazBtn;
    Button _amazonBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageButton _shopeeBtn = (ImageButton) findViewById(R.id.shopeeBtn);
        ImageButton _lazBtn = (ImageButton) findViewById(R.id.lazBtn);
        ImageButton _amazonBtn = (ImageButton) findViewById(R.id.amazonBtn);

        _shopeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //webView.loadUrl("https://shopee.sg/");
            }
        });

        _lazBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //webView.loadUrl("https://www.lazada.sg/");
            }
        });

        _amazonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //webView.loadUrl("https://www.amazon.sg/");
            }
        });
    }
}