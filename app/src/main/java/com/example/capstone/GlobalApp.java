package com.example.capstone;

import android.app.Application;
import android.text.TextUtils;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import ratofit.RestService;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.client.Response;

public class GlobalApp extends Application {

    static RestService service;

    @Override
    public void onCreate() {

        setRestAdapter();
        super.onCreate();
    }

    public static void setRestAdapter() {

        String url = "https://comiccrazewebapi.azurewebsites.net/api";

            OkHttpClient okHttpClient = new OkHttpClient();
            okHttpClient.setReadTimeout(1, TimeUnit.MINUTES);
            okHttpClient.setConnectTimeout(1, TimeUnit.MINUTES);


            RestAdapter restAdapter = new RestAdapter.Builder().setClient(new OkClient(okHttpClient))
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setEndpoint(url)
                    .build();
            service = restAdapter.create(RestService.class);



    }

    public static RestService getRestService() {
        return service;
    }
}
