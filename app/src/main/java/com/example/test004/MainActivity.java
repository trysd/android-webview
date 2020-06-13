package com.example.test004;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.text.SpannableStringBuilder;

public class MainActivity extends AppCompatActivity  implements OnClickListener {

    private final int FP = ViewGroup.LayoutParams.FILL_PARENT;
    private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;

    private EditText textUrl;
    private Button buttonGo;
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);


        LinearLayout ctlLinearLayout = new LinearLayout(this);
        ctlLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

        textUrl = new EditText(this);
        textUrl.setText("http://");

        buttonGo = new Button(this);
        buttonGo.setText("Go");
        buttonGo.setOnClickListener(this);

        ctlLinearLayout.addView(buttonGo, createParam(WC, WC));
        ctlLinearLayout.addView(textUrl, createParam(FP, WC));


        webview = new WebView(this);
        webview.loadUrl("http://nx.sleepjson.xyz/test2/");

        linearLayout.addView(ctlLinearLayout, createParam(FP, WC));
        linearLayout.addView(webview, createParam(WC, WC));




        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        webview.getSettings().setJavaScriptEnabled(true);
    }

    private LinearLayout.LayoutParams createParam(int w, int h){
        return new LinearLayout.LayoutParams(w, h);
    }

    public void onClick(View v) {
        SpannableStringBuilder url = (SpannableStringBuilder)textUrl.getText();
        webview.loadUrl(url.toString());

        this.textUrl.setText("");
    }

}

