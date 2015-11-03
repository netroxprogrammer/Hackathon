package Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Abdullah on 10/26/2015.
 */
public class UserSharePreferences {
    public Context context;
    public   static UserSharePreferences mInstance;
    private  SharedPreferences pref;
    private  String prefName="my_sharesPreference";
    private  String LATITUDE_USER="latitude";
    private  String LONGITUDE_USER="longitude";


    public UserSharePreferences(Context context){
        this.context=context;
        pref=context.getSharedPreferences(prefName,Context.MODE_PRIVATE);
    }
    public  static UserSharePreferences getInstance(Context c){
        if(mInstance==null){

            mInstance=new UserSharePreferences(c);
        }
        return mInstance;
    }
    public void setLongitude(String longitude){
        SharedPreferences.Editor editor=pref.edit();
        editor.putString(LONGITUDE_USER,longitude);
        editor.commit();
        Log.v(Constant.LOG_Constant," SharePreff: Save Longitude");
    }
    public void setLatitude(String latitude){
        SharedPreferences.Editor editor=pref.edit();
        editor.putString(LATITUDE_USER,latitude);
        editor.commit();
        Log.v(Constant.LOG_Constant, " SharePreff: Save Latitude");
    }
    public String getLongitude(){
        String  value="";
        value=pref.getString(LONGITUDE_USER,"0.0");
        Log.v(Constant.LOG_Constant,"SharePreff: Value of Longitude: :"+value);
        return value;
    }
    public String getLatitude(){
        String value="";
        value=pref.getString(LATITUDE_USER,"0.0");
        Log.v(Constant.LOG_Constant,"SharePreff: Value of Latitude: :"+value);
        return value;
    }
}
