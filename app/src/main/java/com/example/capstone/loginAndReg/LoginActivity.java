package com.example.capstone.loginAndReg;

import android.content.Intent;
import android.graphics.Color;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.capstone.GlobalApp;
import com.example.capstone.MainActivity;
import com.example.capstone.R;
import com.example.capstone.dataClasses.RegClass;
import com.example.capstone.utils.AppSession;
import com.example.capstone.utils.Constants;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import Pojos.LoginResponse;
import ratofit.RestService;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;

public class LoginActivity extends AppCompatActivity {



//Declaring variables
    EditText etEmail, etPassword;
    Button btnLogin;
    TextView tvRegister;
    AppSession session;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // hiding the action bar
        getSupportActionBar().hide();

        // calling method in which variables initialized
        init();
    }


    private void init(){
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegister = findViewById(R.id.tvRegister);
        coordinatorLayout = findViewById(R.id.cl);

        session = new AppSession(this);

        // button click listeners
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // validation of fields
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

               /* if (!email.equals(session.getStringData(Constants.EMAIL))){
                    showError(getResources().getString(R.string.error),getResources().getString(R.string.regemail));
                    return;
                }

                if (!password.equals(session.getStringData(Constants.PASSWORD))){
                    showError(getResources().getString(R.string.error),getResources().getString(R.string.regpass));
                    return;
                }*/

                LoginModel loginModel = new LoginModel(email,password);
                doLogin(loginModel);
                session.storeBoolenData(Constants.ISLOGIN,true);
            }
        });


        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openAnotherActivity(RegisterActivity.class);
               // WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
               // String s = Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress());

            }
        });
    }


    // method to open desire activity
    private void openAnotherActivity(Class myClass){
        Intent intent = new Intent(LoginActivity.this, myClass);
        startActivity(intent);
        finish();
    }


    // method to show error in a snackbar
    private void showError(String mTitle, String message){

        Snackbar snackbar = Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_LONG);
        View view = snackbar.getView();
        CoordinatorLayout.LayoutParams params=(CoordinatorLayout.LayoutParams)view.getLayoutParams();
        params.gravity = Gravity.TOP;
        view.setLayoutParams(params);
        snackbar.setBackgroundTint(Color.RED);
        snackbar.show();

    }






    private void doLogin(LoginModel loginModel ){

        GlobalApp appEnv = (GlobalApp) getApplication();
        RestService service = appEnv.getRestService();

        service.doLogin(loginModel,new Callback<LoginResponse>() {
            @Override
            public void success(LoginResponse loginResponse, Response response) {
                openAnotherActivity(MainActivity.class);
            }

            @Override
            public void failure(RetrofitError error) {
                 showError(error.getMessage(),error.getMessage());
            }
        });
    }







    public class LoginModel {
        String email;
        String password;
        LoginModel(String email, String password){
            this.email = email;
            this.password = password;
        }
    }






}


