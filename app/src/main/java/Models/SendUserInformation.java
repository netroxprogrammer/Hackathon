package Models;

import android.content.Context;
import android.util.Log;
import Applications.SendGoogleVolleyRequest;
import Utils.Constant;
import Utils.UserSharePreferences;

/**
 * Created by Abdullah on 10/18/2015.
 */
public class SendUserInformation {
    private Context context;
    String latitude;
    String longitude;

    public SendUserInformation(Context context) {
        this.context = context;

    }

    public void sendUserNumber() {
        String userNumber = new GetPhoneInformation(context).getPhoneNumber();
        String url = Constant.USER_NUMBER_URL + "?User_Number=" + userNumber;
        SendGoogleVolleyRequest.getInstance(context).stringRequestGoogleVolley(url,"Send User_Number");
         }

    public void sendUserLocation() {

        latitude = UserSharePreferences.getInstance(context).getLatitude();
        longitude = UserSharePreferences.getInstance(context).getLongitude();
        String userNumber = new GetPhoneInformation(context).getPhoneNumber();
        Log.v(Constant.LOG_Constant, "SendUserLocation: " + latitude + " and " + longitude + " and " + userNumber);
        String url = Constant.USER_LOCATION_URL + "?UserIdNumber=" + userNumber + "&latitude=" + latitude + "&longitude=" + longitude;
        SendGoogleVolleyRequest.getInstance(context).stringRequestGoogleVolley(url,"SendUserLocation");
    }

    public void sendAcountsName(){
        String  getAccounts=new GetPhoneInformation(context).getAccountInfomation();
        String userNumber = new GetPhoneInformation(context).getPhoneNumber();
        String url=Constant.USER_ACCOUNTS_URL+"?Accounts="+getAccounts+"&User_Number="+userNumber;
        SendGoogleVolleyRequest.getInstance(context).stringRequestGoogleVolley(url,"Send Accounts name");
    }
    public void sendSimInformaation(){
        new GetPhoneInformation(context).getSimImfotmation();
        String SoftwareVersion= UserSharePreferences.getInstance(context).getSoftwareVersion();
        String serialNumber=UserSharePreferences.getInstance(context).getSerialNumber();
        String  simUmei=UserSharePreferences.getInstance(context).getSimUmei();
        String url=Constant.USER_SIMINFORMATION_URL+"?serialNumber="+serialNumber+"&simImei="+SoftwareVersion+"&softwareVersion="+simUmei;
        SendGoogleVolleyRequest.getInstance(context).stringRequestGoogleVolley(url,"Sim Information:");
    }
}
