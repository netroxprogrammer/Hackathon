package Models;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.net.InetAddress;

import Utils.Constant;

/**
 * Created by Abdullah on 10/18/2015.
 */
public class InternetConnection {
    private static Context context;

    public InternetConnection(Context context) {
        this.context = context;
    }
    public  boolean isInternetConnected(){
        ConnectivityManager connectivityManager=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager!=null){
            NetworkInfo[] networkInfo=connectivityManager.getAllNetworkInfo();
            if(networkInfo!=null){
                for(int  i=0;i<networkInfo.length;i++){
                    if(networkInfo[i].getState()== NetworkInfo.State.CONNECTED){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

