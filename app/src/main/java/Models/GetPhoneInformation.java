package Models;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.widget.Toast;

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
}
