package Models;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Utils.Constant;
import Utils.UserSharePreferences;

/**
 * Created by Abdullah on 10/22/2015.
 */
public class GetPhoneInformation {
    private Context context;
    String simInfoNumber;
    TelephonyManager telephonyManager;
    public GetPhoneInformation(Context context){
        this.context=context;
        telephonyManager=(TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
    }
    public  String  getPhoneNumber(){

        simInfoNumber= telephonyManager.getSimSerialNumber();
        if(simInfoNumber==null|| simInfoNumber.isEmpty() || simInfoNumber.equalsIgnoreCase("")){
            simInfoNumber=telephonyManager.getLine1Number();
            if(simInfoNumber==null|| simInfoNumber.isEmpty() || simInfoNumber.equalsIgnoreCase("")){
                simInfoNumber=telephonyManager.getDeviceId();
            }
        }
        else
        {
            return  simInfoNumber;
        }
        return simInfoNumber;
    }
    public String getAccountInfomation(){
        AccountManager accountManager=AccountManager.get(context);
        Account[] getacounts=accountManager.getAccounts();
       // ArrayList<String> googleAccounts=new ArrayList<>();
        String name="";
        for(Account account:getacounts){

             name=name+account.name;
            Log.v(Constant.LOG_Constant," Account  Nameis : "+name);
        }
        return  name;
    }
    public void getSimImfotmation(){
        String serialNumber=telephonyManager.getSimSerialNumber();
        String simImei=telephonyManager.getDeviceId();
        String softwareVersion=telephonyManager.getDeviceSoftwareVersion();
        UserSharePreferences.getInstance(context).setSimSerialNumber(serialNumber);
        UserSharePreferences.getInstance(context).setSimImei(simImei);
        UserSharePreferences.getInstance(context).setSoftwareVersion(softwareVersion);

    }
}
