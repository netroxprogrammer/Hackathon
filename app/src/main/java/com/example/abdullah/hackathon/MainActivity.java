package com.example.abdullah.hackathon;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import Models.InternetConnection;
import Models.SendUserInformation;

import com.example.abdullah.hackathon.Services.LocationService;
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
        startService(new Intent(this, LocationService.class));



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
