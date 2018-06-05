package com.example.ignap.lab9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView wv = findViewById(R.id.webview);
        wv.loadUrl("http://demo.tutorialzine.com/2012/04/mobile-touch-gallery/");
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
        //listo, ya no se cierra
    }
}
