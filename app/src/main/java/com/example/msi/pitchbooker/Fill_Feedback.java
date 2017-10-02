package com.example.msi.pitchbooker;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class Fill_Feedback extends Fragment implements View.OnClickListener{
    EditText et_feedback;
    Button btn_sent;

    public Fill_Feedback() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fill__feedback, container, false);

        et_feedback = (EditText)view.findViewById(R.id.et_fillFeedback);
        btn_sent = (Button)view.findViewById(R.id.Sent);

        btn_sent.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Sent:
                if(et_feedback.getText().toString().isEmpty()){
                    Toast.makeText(getContext(), "Fill feedback is empty!", Toast.LENGTH_SHORT).show();
                } else {
                    sent();
                }
        }
    }

    private void sent() {
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url = "http://pitchbooker.gicitc.info/feedback/add";
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
                            Toast.makeText(getContext(),"status : "+loginResponse.isStatus(),Toast.LENGTH_LONG).show();

                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        }
                        LoginResponse login = gson.fromJson(response, LoginResponse.class);
                        if(login.isStatus()){
                            SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getResources().getString(R.string.data_app),getActivity().MODE_PRIVATE);
                            SharedPreferences.Editor editor =sharedPreferences.edit();
                            editor.putString("feedback_content", et_feedback.getText().toString());
                            editor.apply();
                            Toast.makeText(getActivity(), "Fill: "+sharedPreferences.getString("feedback_content", ""), Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getContext(),login.getMsg(),Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getApplicationContext(),"a:"+error.getMessage(),Toast.LENGTH_LONG).show();


            }
        });
        queue.add(stringRequest);
    }
}
