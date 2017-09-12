package com.example.msi.pitchbooker;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Log_In extends Fragment implements View.OnClickListener{
    EditText et_username, et_password;
    TextView tv_forgetPWD, tv_signUp;
    Button btn_login;
    Intent intent;
    public Log_In() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_log__in, container, false);
        et_username = (EditText) view.findViewById(R.id.et_username);
        et_password = (EditText) view.findViewById(R.id.et_password);
        tv_forgetPWD = (TextView)view.findViewById(R.id.tv_forgetPWD);
        tv_signUp = (TextView)view.findViewById(R.id.tv_signUp);
        btn_login = (Button)view.findViewById(R.id.btn_logIn);

        tv_forgetPWD.setOnClickListener(this);
        tv_signUp.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_forgetPWD:
                intent = new Intent(getContext(), Forget_Password.class);
                startActivity(intent);
                break;
            case R.id.tv_signUp:
                intent = new Intent(getContext(), Sign_Up.class);
                startActivity(intent);
                break;
            case R.id.btn_logIn:
                String url ="pitchbooker.gicitc.info/customer/login_username";

                StringRequest stringRequest = new StringRequest(Request.Method.POST,
                        url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
                        Gson gson = new Gson();
                        try {
                            LoginResponse login = gson.fromJson(response, LoginResponse.class);
                            if(login.isStatus()){
                                //login success
                                Home_Screen home_screen = new Home_Screen();
                                FragmentManager fragmentManager = getFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.frame, home_screen);
                                fragmentTransaction.commit();
                            }else{
                                //login failed
                                Toast.makeText(getContext(), "Password is Incorrect", Toast.LENGTH_LONG).show();
                            }
                        }catch(JsonSyntaxException e){
                            Log.e("MainActivity", Log.getStackTraceString(e));
                        }
                /* ***** use built-in JSONObject of Android system *****
                try {
                    JSONObject object = new JSONObject(response);
                    Toast.makeText(MainActivity.this, "Status: "+object.getBoolean("status"), Toast.LENGTH_LONG).show();
                    if(object.getBoolean("status")){
                        //login success
                    }else{
                        //login failed
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                */

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "Error:"+error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("username",et_username.getText().toString());
                        hashMap.put("password",et_password.getText().toString());
                        return hashMap;
                    }
                };
        }
    }

}
