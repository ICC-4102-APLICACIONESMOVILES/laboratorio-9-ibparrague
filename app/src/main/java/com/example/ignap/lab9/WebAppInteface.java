package com.example.ignap.lab9;

import android.content.Context;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInteface {
    Context myContext;

    WebAppInteface(Context c){
        myContext = c;
    }


    @JavascriptInterface
    public void finishActivity (View view){
        //finishActivity();
        System.exit(1);
    }
}
