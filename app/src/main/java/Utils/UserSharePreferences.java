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




    public UserSharePreferences(Context context){
        this.context=context;
        pref=context.getSharedPreferences(Constant.prefName,Context.MODE_PRIVATE);
    }
    public  static UserSharePreferences getInstance(Context c){
        if(mInstance==null){

            mInstance=new UserSharePreferences(c);
        }
        return mInstance;
    }
    public void setLongitude(String longitude){
        SharedPreferences.Editor editor=pref.edit();
        editor.putString(Constant.LONGITUDE_USER,longitude);
        editor.commit();
        Log.v(Constant.LOG_Constant," SharePreff: Save Longitude");
    }
    public void setLatitude(String latitude){
        SharedPreferences.Editor editor=pref.edit();
        editor.putString(Constant.LATITUDE_USER,latitude);
        editor.commit();
        Log.v(Constant.LOG_Constant, " SharePreff: Save Latitude");
    }
    public String getLongitude(){
        String  value="";
        value=pref.getString(Constant.LONGITUDE_USER,"0.0");
        Log.v(Constant.LOG_Constant,"SharePreff: Value of Longitude: :"+value);
        return value;
    }
    public String getLatitude(){
        String value="";
        value=pref.getString(Constant.LATITUDE_USER,"0.0");
        Log.v(Constant.LOG_Constant,"SharePreff: Value of Latitude: :"+value);
        return value;
    }
    public void setSimSerialNumber(String  serialNumber){
        SharedPreferences.Editor editor=pref.edit();
        editor.putString(Constant.SIMSERAIL_NUMBER,serialNumber);
        editor.commit();
        Log.v(Constant.LOG_Constant,"SharePreff: Save SimSerialNumber= "+serialNumber);
    }
    public void setSimImei(String sim_imei){
        SharedPreferences.Editor editor=pref.edit();
        editor.putString(Constant.SIM_IMEI, sim_imei);
        editor.commit();
        Log.v(Constant.LOG_Constant, "SharePreff: Save SIMIMEI Number= " + sim_imei);
    }
    public void setSoftwareVersion(String softwareVersion){
        SharedPreferences.Editor editor=pref.edit();
        editor.putString(Constant.SOFTWAREVERSION,softwareVersion);
        editor.commit();
        Log.v(Constant.LOG_Constant, "SharePreff: Save SoftwareVersion= " + softwareVersion);
    }
    public  String getSerialNumber(){
        String  value="";
        value=pref.getString(Constant.SIMSERAIL_NUMBER,"");
        Log.v(Constant.LOG_Constant, "SharePref: getSerialNumber: " + value);
        return value;
    }
    public String getSimUmei(){
        String  value="";
        value=pref.getString(Constant.SIM_IMEI,"");
        Log.v(Constant.LOG_Constant, "SharePref: getSIMIMEI: " + value);
        return value;
    }
    public String getSoftwareVersion(){
        String  value="";
        value=pref.getString(Constant.SOFTWAREVERSION,"");
        Log.v(Constant.LOG_Constant, "SharePref: getSoftwareVersion: " + value);
        return value;
    }

}
