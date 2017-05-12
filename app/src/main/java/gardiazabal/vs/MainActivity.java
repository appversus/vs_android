package gardiazabal.vs;

import android.app.*;
import android.os.*;

public class MainActivity extends Activity {

    public WebView webView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);

        webView = new WebView();

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.addJavascriptInterface(new WebAppInterface(this), "Device");
        webView.loadUrl("file:///android_asset/index.html");
    }

    public class WebAppInterface {

        Context mContext;

        WebAppInterface(Context c) {
            mContext = c;
        }

        @JavascriptInterface
        public void getLocation() {
            return mContext.getResources().getConfiguration().locale.getCountry(); 
        }
    }
}
