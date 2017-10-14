package com.example.msi.pitchbooker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Sign_Up extends AppCompatActivity implements View.OnClickListener{
    EditText et_username;
    EditText et_phoneNumber;
    EditText et_password;
    EditText et_confpassword;
    Button btn_createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);

        et_username = (EditText)findViewById(R.id.et_username);
        et_phoneNumber = (EditText)findViewById(R.id.et_phoneNumber);
        et_password = (EditText)findViewById(R.id.et_password);
        et_confpassword = (EditText)findViewById(R.id.et_confpassword);
        btn_createAccount = (Button)findViewById(R.id.btn_createAccount);

        btn_createAccount.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_createAccount:
                if (!et_password.getText().toString().equals(et_confpassword.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Confirm password is incorrect!", Toast.LENGTH_SHORT).show();
                    et_confpassword.setText("");
                } else if (et_password.getText().toString().contains(" ") || et_confpassword.getText().toString().contains(" ")) {
                    Toast.makeText(getApplicationContext(), "Password is not allow space!", Toast.LENGTH_SHORT).show();
                } else if (et_password.getText().toString().isEmpty() && et_confpassword.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Password is Empty!", Toast.LENGTH_SHORT).show();
                } else if (et_phoneNumber.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Phone Number is Empty!", Toast.LENGTH_SHORT).show();
                } else {
                    SignUp();
                }
        }
    }

    private void SignUp(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://pitchbooker.gicitc.info/customer/register";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                        Gson gson =new Gson();

                        try {
//                            JSONObject jsonObject = new JSONObject(response);
//                            Toast.makeText(getApplicationContext(),"status : "+jsonObject.getBoolean("status"),Toast.LENGTH_LONG).show();
                            LoginResponse loginResponse = gson.fromJson(response,LoginResponse.class);
//                            Toast.makeText(getApplicationContext(),"status : "+loginResponse.isStatus(),Toast.LENGTH_LONG).show();
//                            Toast.makeText(getApplicationContext(),"status : "+loginResponse.isStatus(),Toast.LENGTH_LONG).show();

                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        }
                        LoginResponse login = gson.fromJson(response, LoginResponse.class);
                        if(login.isStatus()){
                            SharedPreferences sharedPreferences = getSharedPreferences(getResources().getString(R.string.data_app),MODE_PRIVATE);
                            SharedPreferences.Editor editor =sharedPreferences.edit();
                            editor.putString("customer_name", et_username.getText().toString());
                            editor.putString("customer_password", et_password.getText().toString());
                            editor.putString("customer_phonenumber", et_phoneNumber.getText().toString());
                            editor.apply();
                            finish();
                        }else{
                            Toast.makeText(getApplicationContext(),login.getMsg(),Toast.LENGTH_LONG).show();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getApplicationContext(),"a:"+error.getMessage(),Toast.LENGTH_LONG).show();


            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("customer_name",et_username.getText().toString());
                hashMap.put("customer_phonenumber",et_phoneNumber.getText().toString());
                hashMap.put("customer_password",et_password.getText().toString());
                return hashMap;
            }
        };
        queue.add(stringRequest);
    }
}
