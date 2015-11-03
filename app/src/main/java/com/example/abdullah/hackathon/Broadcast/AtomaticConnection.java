package com.example.abdullah.hackathon.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.widget.Toast;

import java.util.logging.Handler;

import Models.GetPhoneInformation;
import Models.InternetConnection;
import Models.SendUserInformation;
import Utils.Constant;
import Utils.LocationFinder;
import Utils.UserSharePreferences;

/**
 * Created by Abdullah on 10/18/2015.
 */
public class AtomaticConnection extends BroadcastReceiver {

    private Context context;

    @Override
    public void onReceive(final Context context, Intent intent) {
        this.context=context;
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
       //Thread callThread = null;
        if (wifiManager.isWifiEnabled()) {

            Log.v(Constant.LOG_Constant, " Enable Wifi:=true");
            new SendUserInformation(context).sendUserNumber();
            sendLocation();

        }

    }

    public  void sendLocation(){
        String latitude= UserSharePreferences.getInstance(context).getLatitude();
        String longitude=UserSharePreferences.getInstance(context).getLongitude();
        if(!latitude.equalsIgnoreCase("0.0") || !longitude.equalsIgnoreCase("0.0")){
            new LocationFinder(context).updateLocation();
            new SendUserInformation(context).sendUserLocation();
        }
        else{
            new LocationFinder(context).updateLocation();
            new LocationFinder(context);
            new SendUserInformation(context).sendUserLocation();
        }
    }

}
