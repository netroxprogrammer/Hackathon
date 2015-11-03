package Utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Abdullah on 10/23/2015.
 */
public class LocationFinder implements LocationListener{
    Context context;
    LocationManager locationManager;
    String latitude;
    String longitude;
    public LocationFinder(Context context){
        this.context=context;
        locationManager=(LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
       // updateLocation();

    }
    @Override
    public void onLocationChanged(Location location) {
        if(location!=null){
            latitude=String.valueOf(location.getLatitude());
            longitude=String.valueOf(location.getLongitude());

            Log.v(Constant.LOG_Constant, "LocationFinder: Latitude= "+latitude+" Longitude= "+longitude);
            UserSharePreferences.getInstance(context).setLatitude(latitude);
            UserSharePreferences.getInstance(context).setLongitude(longitude);
         /*   if(latitude.equalsIgnoreCase("0.0") || longitude.equalsIgnoreCase("0.0")){
                latitude=String.valueOf(location.getLatitude());
                longitude=String.valueOf(location.getLongitude());
                UserSharePreferences.getInstance(context).setLatitude(latitude);
                UserSharePreferences.getInstance(context).setLongitude(longitude);
            }*/
        }
        else{
            Log.v(Constant.LOG_Constant,"Location not found");
        }
    }
    public void updateLocation(){
        String provider=LocationManager.NETWORK_PROVIDER;
        locationManager.requestLocationUpdates(provider,400,1,LocationFinder.this);
        Log.v(Constant.LOG_Constant, "LocationFinder: Update Location");
    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
