package com.example.jcj;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    private static final String TAGA = "JCJ-A";
    private static final String TAGW = "JCJ-W";

    private WebView mWebView;

    static {
        Log.i(TAGA, "loading jcj-lib...");
        System.loadLibrary("jcj-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeWebView();

        // Example of a call to a native method
        float a = 2;
        float b = 3;
        float sum = add(2, 3);
        Log.i(TAGA, String.format("%f + %f = %f", a, b, sum));
    }

    private void initializeWebView(){
        JSInterface jsInterface = new JSInterface(this);

        mWebView = findViewById(R.id.main_webview);
        mWebView.setWebChromeClient(new MyWebChromeClient());
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.clearCache(true);
        mWebView.clearHistory();
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(jsInterface, "JSToJava");
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.loadUrl("file:///android_asset/page.html");

        mWebView.loadUrl("javascript: var result = window.jsAdd(22, 33); window.JSToJava.jsReply(result)");
    }

    public final class JSInterface {
        private Activity activity;

        public JSInterface(Activity activity) {
            this.activity = activity;
        }

        @android.webkit.JavascriptInterface
        public void someJavaFunction(String message){
            Log.i(TAGW, message);
        }

        @android.webkit.JavascriptInterface
        public void jsReply(String message){
            Log.i(TAGW, message);
        }
    }

    final class MyWebChromeClient extends WebChromeClient {
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            Log.i(TAGW, message);
            result.confirm();
            return true;
        }
    }

    /**
     * A native method that is implemented by the 'jcj-lib' native library,
     * which is packaged with this application.
     */
    public native float add(float a, float b);
}
