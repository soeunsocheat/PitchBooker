package com.example.msi.pitchbooker;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.msi.pitchbooker.util.AppUtil;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.HashMap;
import java.util.Map;


public class Log_In extends AppCompatActivity implements View.OnClickListener{
    EditText et_username, et_password;
    TextView tv_signUp;
    Button btn_login;
    Intent intent;
    public Log_In() {
        // Required empty public constructor
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log__in);
        et_username = (EditText)findViewById(R.id.et_username);
        et_password = (EditText)findViewById(R.id.et_password);
        tv_signUp = (TextView)findViewById(R.id.tv_signUp);
        btn_login = (Button)findViewById(R.id.btn_logIn);

        tv_signUp.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_signUp:
                intent = new Intent(this, Sign_Up.class);
                startActivity(intent);
                break;
            case R.id.btn_logIn:
                if (et_username.getText().toString().isEmpty()&& et_password.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Username & Password is Empty!", Toast.LENGTH_SHORT).show();
                }else {
                    Login();
                }
        }
    }
    private void Login() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://pitchbooker.gicitc.info/customer/login_username";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //                                Toast.makeText(getActivity(),response,Toast.LENGTH_LONG).show();
                        Gson gson = new Gson();

                        try {
                            //                            JSONObject jsonObject = new JSONObject(response);
                            //                            Toast.makeText(getApplicationContext(),"status : "+jsonObject.getBoolean("status"),Toast.LENGTH_LONG).show();
                            LoginResponse loginResponse = gson.fromJson(response, LoginResponse.class);
                            //                            Toast.makeText(getApplicationContext(),"status : "+loginResponse.isStatus(),Toast.LENGTH_LONG).show();
                            //                                    Toast.makeText(Log_In.this,"status : "+loginResponse.isStatus(),Toast.LENGTH_LONG).show();

                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        }
                        LoginResponse login = gson.fromJson(response, LoginResponse.class);
                        if (login.isStatus()) {
                            SharedPreferences sharedPreferences = getSharedPreferences(getResources().getString(R.string.data_app), MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("customer_id", login.getCustomer_id() + "");
                            editor.putString("customer_name", et_username.getText().toString());
                            editor.putString("customer_password", et_password.getText().toString());
                            editor.apply();
                            intent = new Intent(Log_In.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(Log_In.this, "" + login.getMsg(), Toast.LENGTH_LONG).show();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //                Toast.makeText(getApplicationContext(),"a:"+error.getMessage(),Toast.LENGTH_LONG).show();


            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                Context ctx = Log_In.this;
                ;
                hashMap.put("customer_name", et_username.getText().toString());
                hashMap.put("customer_password", et_password.getText().toString());
                hashMap.put("customer_device_id", AppUtil.obtainIMEI(ctx));
                return hashMap;
            }
        };
        queue.add(stringRequest);

    }

}
