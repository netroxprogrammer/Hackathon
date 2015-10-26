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

/**
 * Created by Abdullah on 10/18/2015.
 */
public class AtomaticConnection extends BroadcastReceiver {

    private Context context;

    @Override
    public void onReceive(final Context context, Intent intent) {

        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        Thread callThread = null;
        if (wifiManager.isWifiEnabled()) {

            Log.v(Constant.LOG_Constant, " Enable Wifi:=true");
            try {
                Runnable runnable =new  Runnable() {
                    public void run() {

                        new SendUserInformation(context).sendUserNumber();
                    }
                };
                callThread = new Thread(runnable);
                    callThread.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                callThread.sleep(1000);
                callThread.stop();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            Log.v(Constant.LOG_Constant, " Disable Wifi:=true");
        }
    }


}
