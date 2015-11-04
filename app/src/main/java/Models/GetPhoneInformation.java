package Models;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Abdullah on 10/22/2015.
 */
public class GetPhoneInformation {
    private Context context;
    String simInfoNumber;
    public GetPhoneInformation(Context context){
        this.context=context;
    }
    public  String  getPhoneNumber(){
        TelephonyManager telephonyManager= (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
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
    public void getAccountInfomation(){
        AccountManager accountManager=AccountManager.get(context);
        Account[] getacounts=accountManager.getAccounts();
       // ArrayList<String> googleAccounts=new ArrayList<>();
        for(Account account:getacounts){

            String name=account.name;
            String type=account.type;
            Toast.makeText(context,name+"\n"+type,Toast.LENGTH_LONG).show();
        }

    }
}
