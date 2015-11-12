package com.example.abdullah.hackathon.Services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.apache.commons.net.ftp.FTPClient;
import org.json.JSONObject;

import Applications.HandleSockets;
import Models.VolleyInitializer;
import Utils.Constant;

/**
 * Created by mac on 11/11/2015.
 */
public class getRequestFromNetwork extends Service {
    Context context=this;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate(){
        super.onCreate();
        new HandleSockets(context).execute();
        try {

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    /*String url=Constant.USER_SDCARD_INFORMATION;
    JsonObjectRequest sendReqest = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            Log.v(Constant.LOG_Constant, " Get requestfrom Php  Response : " + response.toString());
            try {
                String status = response.getString("success");
                if(status.equals("1")){
                    Toast.makeText(getApplicationContext(),"request Recive",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"NOOO request Recive",Toast.LENGTH_LONG).show();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.v(Constant.LOG_Constant," Get requestfrom Php SendUserLocation Response Error: ");
        }
    });
    VolleyInitializer.getInstance(context).AddRequest(sendReqest);*/
}
