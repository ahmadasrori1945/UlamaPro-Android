package id.co.telkomsigma.ulamapro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class KIblatWebActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiblat_web);

        WebView wv = (WebView) findViewById(R.id.kiblatwebview);

        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAppCacheEnabled(true);

        wv.setWebChromeClient(new WebChromeClient());

        wv.loadUrl("https://qiblafinder.withgoogle.com/intl/id/");
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}