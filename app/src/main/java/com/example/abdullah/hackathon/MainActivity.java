package com.example.abdullah.hackathon;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Debug;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.io.File;
import java.io.StringReader;

import Models.InternetConnection;
import Models.SendUserInformation;
import Models.VolleyInitializer;
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



       /* if (IsExternalStorageWriteable() == true) {
            File sdCardPath = Environment.getExternalStorageDirectory();
            File sdCardFiles = new File(sdCardPath, "/");
            for(File  files: sdCardFiles.listFiles()){
                Toast.makeText(getApplicationContext(), files.getName(), Toast.LENGTH_LONG).show();

            }

            //
        } else if (IsExternalReadStorage()==true) {
            Toast.makeText(getApplicationContext(), "Access denied", Toast.LENGTH_LONG).show();
        }*/
        }

    public void  setUpLayoutXml(){
        dataList=(TextView)findViewById(R.id.activity_main_txt_list);

    }
    public  void sendLocation(){
        String latitude=UserSharePreferences.getInstance(context).getLatitude();
        String longitude=UserSharePreferences.getInstance(context).getLongitude();
        if(!latitude.equalsIgnoreCase("0.0") || !longitude.equalsIgnoreCase("0.0")){
            new LocationFinder(context).updateLocation();
            new SendUserInformation(context).sendUserLocation();
        }
        else{
            new LocationFinder(context).updateLocation();
            new LocationFinder(context);
            try{
                Runnable runnable=new Runnable() {
                    @Override
                    public void run() {
                        new SendUserInformation(context).sendUserLocation();
                    }
                };
                Thread thread=new  Thread(runnable);
                thread.sleep(5000);
                thread.start();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void SendUserId(){
        InternetConnection internetConnection=new InternetConnection(getApplicationContext());
        boolean  state=internetConnection.isInternetConnected();
        if(state){
            new SendUserInformation(context).sendUserNumber();
            sendLocation();
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

    /**
     * @CheckSdCardWriteable
     */
    private boolean IsExternalStorageWriteable() {
        String state = Environment.getExternalStorageState();
        Log.v("State: ", state);
        if (Environment.MEDIA_MOUNTED.equals(state)) {

            return true;
        }
        return false;
    }

    /**
     * @CheckSdCardReadable
     */
    private boolean IsExternalReadStorage() {

        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;

    }

}
