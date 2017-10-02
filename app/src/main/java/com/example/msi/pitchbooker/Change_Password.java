package com.example.msi.pitchbooker;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
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

public class Change_Password extends AppCompatActivity {
    EditText et_username;
    EditText et_phoneNumber;
    EditText et_password;
    EditText et_newpassword;
    EditText et_confpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change__password);
        et_username = (EditText)findViewById(R.id.et_username);
        et_phoneNumber = (EditText)findViewById(R.id.et_phoneNumber);
        et_password = (EditText)findViewById(R.id.et_password);
        et_newpassword = (EditText)findViewById(R.id.et_newpassword);
        et_confpassword = (EditText)findViewById(R.id.et_confpassword);
    }

    public void btn_changepassword(View view) {
        SharedPreferences preferences = getSharedPreferences(getResources().getString(R.string.data_app), MODE_PRIVATE);
        if (!et_newpassword.getText().toString().equals(et_confpassword.getText().toString())){
            Toast.makeText(getApplicationContext(),"Confirm password is incorrect!", Toast.LENGTH_SHORT).show();
        }else if (et_newpassword.getText().toString().contains(" ")||et_confpassword.getText().toString().contains(" ")
                ||et_password.getText().toString().contains(" ")){
            Toast.makeText(getApplicationContext(),"Password is not allow space!", Toast.LENGTH_SHORT).show();
        }else if (et_password.getText().toString().isEmpty()&& et_newpassword.getText().toString().isEmpty()
                && et_confpassword.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Password is Empty!", Toast.LENGTH_SHORT).show();
        }else {
            change();
        }

    }

    private void change(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://pitchbooker.gicitc.info/customer/change/password";
        final SharedPreferences sharedPreferences = getSharedPreferences(getResources().getString(R.string.data_app),MODE_PRIVATE);
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

                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        }
                        if(response.contains("true")){
                            SharedPreferences sharedPreferences = getSharedPreferences(getResources().getString(R.string.data_app),MODE_PRIVATE);
                            SharedPreferences.Editor editor =sharedPreferences.edit();
                            editor.putString("pwd",et_newpassword.getText().toString());
                            editor.apply();
                            finish();

                        }else{
                            LoginResponse login = gson.fromJson(response,LoginResponse.class);
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
                SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.data_app),MODE_PRIVATE);
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("customer_id",sharedPreferences.getString("customer_id",""));
                hashMap.put("customer_old_password",et_password.getText().toString());
                hashMap.put("customer_new_password",et_newpassword.getText().toString());
                return hashMap;
            }
        };
        queue.add(stringRequest);
    }
}
