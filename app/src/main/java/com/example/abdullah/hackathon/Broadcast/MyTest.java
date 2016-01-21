package com.example.abdullah.hackathon.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import com.example.abdullah.hackathon.Services.getRequestFromNetwork;

/**
 * Created by mac on 11/23/2015.
 */
public class MyTest extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },1000);
    }
}
