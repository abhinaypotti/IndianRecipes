package com.example.dev.indianrecipes.LunchBox;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.dev.indianrecipes.R;


public class BrocoliParatha extends AppCompatActivity{
    WebView webView;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webindex);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        webView = (WebView) findViewById(R.id.webViewbasic);

        WebSettings webSetting = webView.getSettings();
        webSetting.setBuiltInZoomControls(true);
        webSetting.setJavaScriptEnabled(true);

        webView.setWebViewClient(new BrocoliParatha.WebViewClient());
        webView.loadUrl("file:///android_asset/brocoliparathaa.html");
    }
    private class WebViewClient extends android.webkit.WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        switch (item.getItemId()) {
            case android.R.id.home:


                this.finish();
                return true;
            default:
                if (id == R.id.action_send) {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_TEXT, "message to share");
                    startActivity(Intent.createChooser(i, "Share via"));
                    return true;
                }
                return super.onOptionsItemSelected(item);

        }
    }

}
