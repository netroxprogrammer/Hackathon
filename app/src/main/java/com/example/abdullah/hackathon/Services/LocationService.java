package com.example.abdullah.hackathon.Services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.example.abdullah.hackathon.MainActivity;

import Models.SendUserInformation;
import Utils.Constant;
import Utils.LocationFinder;

/**
 * Created by mac on 11/3/2015.
 */
public class LocationService extends Service {
    Context context=this;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate(){
        super.onCreate();
        Handler handler=new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               //MainActivity mainactivty=(MainActivity)context;
                // mainactivty.sendLocation();
                new LocationFinder(context);
                new LocationFinder(context).updateLocation();
                new SendUserInformation(context).sendUserLocation();
                Log.v(Constant.LOG_Constant,"Location BackGround service: started after  5 second ");
            }
        },5000);
    }


}
