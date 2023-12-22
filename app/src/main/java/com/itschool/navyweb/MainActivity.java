package com.itschool.navyweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    private WebView poqwebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CookieManager.getInstance().setAcceptCookie(true);

        poqwebView=(WebView) findViewById(R.id.webview);
        //poqwebView.setWebViewClient(new WebViewClient());
        
        poqwebView.loadUrl("https://www.navy.lk ");
        WebSettings webSettings=poqwebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDisplayZoomControls(true);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                // on below line displaying a log that admob ads has been initialized.
                Log.i("Admob", "Admob Initialized.");
            }
        });

        // on below line creating and initializing variable for adView.
        AdView adView = findViewById(R.id.adView);
        // on below line creating and initializing variable for adRequest
        AdRequest adRequest = new AdRequest.Builder().build();
        // on below line loading request inside our adview.
        adView.loadAd(adRequest);
    }
}