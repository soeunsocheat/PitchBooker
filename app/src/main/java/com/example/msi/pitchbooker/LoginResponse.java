package com.example.msi.pitchbooker;

/**
 * Created by MSI on 8/9/2017.
 */

public class LoginResponse {
    private boolean status;
    private String msg;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
