package com.example.abdullah.hackathon.Services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import Utils.Constant;

/**
 * Created by mac on 11/23/2015.
 */
public class Test extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate(){
        super.onCreate();
        Log.v(Constant.LOG_Constant,"My BackGround Service evry 1 second");
    }
}
