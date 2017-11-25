package com.example.jcj;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    private static final String TAG = "JCJ-A";

    static {
        Log.i(TAG, "loading jcj-lib...");
        System.loadLibrary("jcj-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        float a = 2;
        float b = 3;
        float sum = add(2, 3);
        Log.i(TAG, String.format("%f + %f = %f", a, b, sum));
    }

    /**
     * A native method that is implemented by the 'jcj-lib' native library,
     * which is packaged with this application.
     */
    public native float add(float a, float b);
}
