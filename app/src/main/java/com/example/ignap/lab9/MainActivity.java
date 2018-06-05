package com.example.ignap.lab9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView wv = findViewById(R.id.webview);
        wv.setWebViewClient(new MyWebClient());
        //wv.loadUrl("http://demo.tutorialzine.com/2012/04/mobile-touch-gallery/");
        wv.loadUrl("https://saf.uandes.cl/");
        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);
        wv.addJavascriptInterface(new WebAppInteface(this), "Android");

        wv.setWebChromeClient(new WebChromeClient(){
            public void onConsoleMessage(String name, int lineNumber, String sourceID){
                Log.d("MyApplication"," -- From line " + lineNumber + "of" + sourceID);
            }
        });
    }


    @Override
    public void onBackPressed() {

        WebView wv = findViewById(R.id.webview);

        if (wv.canGoBack()){
            wv.goBack();
        }

        /*
        public boolean OnKeyDown(int keyCode, KeyEvent event){
            if (keyCode == keyEvent.KEYCODE_BACK) && MyWebView.CanGoBack
        }
        */
    }
}
