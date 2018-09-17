package com.weather.pc.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class DetailActivity extends AppCompatActivity {

    private WebView webMoview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        webMoview=findViewById(R.id.webMovie);

        Bundle bundle=getIntent().getExtras();
        webMoview.loadUrl(bundle.getString("url"));


    }
}
