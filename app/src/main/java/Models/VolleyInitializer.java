package Models;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Abdullah on 10/14/2015.
 */
public class VolleyInitializer {
    private static VolleyInitializer mIntance;
    private RequestQueue requestQueue;
    private static Context context;

    private VolleyInitializer(Context context) {
        this.context = context;

        requestQueue = getRequestQueue();

    }

    public static synchronized VolleyInitializer getInstance(Context context) {

        if (mIntance == null) {
            mIntance = new VolleyInitializer(context);
        }
        return mIntance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void AddRequest(Request<T> req) {
        getRequestQueue().add(req);
    }
}
