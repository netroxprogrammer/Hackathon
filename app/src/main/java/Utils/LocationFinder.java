package Utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.os.Bundle;

/**
 * Created by Abdullah on 10/23/2015.
 */
public class LocationFinder implements LocationListener{
    Context context;
    LocationManager locationManager;
    public LocationFinder(Context context){
        this.context=context;
        locationManager=(LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
    }
    @Override
    public void onLocationChanged(Location location) {

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
