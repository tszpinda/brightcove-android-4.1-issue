package com.example.android.myvideo;

import android.app.Application;
import android.os.Build;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class MyVideo extends Application {


    static {
        boolean isSdk21orBelow = Build.VERSION.SDK_INT < 21;
        if (isSdk21orBelow) {
            forceTLSv12();
        }
    }

    static void forceTLSv12() {
        try {
            SSLContext sslcontext = SSLContext.getInstance("TLSv1.2");
            sslcontext.init(null, null, null);
            SSLSocketFactory noSSLv3Factory = new Tls12SocketFactory(sslcontext.getSocketFactory());
            HttpsURLConnection.setDefaultSSLSocketFactory(noSSLv3Factory);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }

}
