package com.example.msi.pitchbooker.util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;

/**
 * Created by pov on 8/7/2017.
 */

public class AppUtil {
    public static String obtainIMEI(Context context){
        return Settings.Secure.getString(
                context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }
}
