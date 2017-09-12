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
import com.example.msi.pitchbooker.util.AppUtil;
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
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                String url ="http://pitchbooker.gicitc.info/customer/login_username";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(getActivity(),response,Toast.LENGTH_LONG).show();
                                Gson gson =new Gson();

                                try {
//                            JSONObject jsonObject = new JSONObject(response);
//                            Toast.makeText(getApplicationContext(),"status : "+jsonObject.getBoolean("status"),Toast.LENGTH_LONG).show();
                                    LoginResponse loginResponse = gson.fromJson(response,LoginResponse.class);
//                            Toast.makeText(getApplicationContext(),"status : "+loginResponse.isStatus(),Toast.LENGTH_LONG).show();
                                    Toast.makeText(getActivity(),"status : "+loginResponse.isStatus(),Toast.LENGTH_LONG).show();

                                } catch (JsonSyntaxException e) {
                                    e.printStackTrace();
                                }
                                LoginResponse login = gson.fromJson(response, LoginResponse.class);
                                if(login.isStatus()){
                                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getResources().getString(R.string.data_app),getActivity().MODE_PRIVATE);
                                    SharedPreferences.Editor editor =sharedPreferences.edit();
                                    editor.putString("customer_id", login.getCustomer_id()+"");
                                    editor.putString("customer_name", et_username.getText().toString());
                                    editor.putString("customer_password", et_password.getText().toString());
                                    editor.apply();

                                    Profile profile = new Profile();
                                    FragmentManager fragmentManager = getFragmentManager();
                                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                    fragmentTransaction.replace(R.id.frame, profile);
                                    fragmentTransaction.commit();
                                }else{
                                    Toast.makeText(getActivity(),login.getMsg(),Toast.LENGTH_LONG).show();
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
                        Context ctx = getActivity();
                        hashMap.put("customer_name",et_username.getText().toString());
                        hashMap.put("customer_password",et_password.getText().toString());
                        hashMap.put("customer_device_id", AppUtil.obtainIMEI(ctx));
                        return hashMap;
                    }
                };
                queue.add(stringRequest);
        }
    }

}
