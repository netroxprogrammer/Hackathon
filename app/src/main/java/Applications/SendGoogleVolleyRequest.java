package Applications;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import Models.VolleyInitializer;
import Utils.Constant;

/**
 * Created by mac on 11/5/2015.
 */
public class SendGoogleVolleyRequest {
    private Context context;
    public static SendGoogleVolleyRequest mInstants;
    public SendGoogleVolleyRequest(Context context){
        this.context=context;
    }
    public  static SendGoogleVolleyRequest getInstance(Context c){
        if(mInstants==null){
            mInstants=new SendGoogleVolleyRequest(c);
        }
        return mInstants;
    }
    public void stringRequestGoogleVolley(String  url, final String  respnonseId){
        StringRequest sendReqest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v(Constant.LOG_Constant, respnonseId+" Response : " + response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v(Constant.LOG_Constant, respnonseId+ "SendUserLocation Response Error: ");
            }
        });
        VolleyInitializer.getInstance(context).AddRequest(sendReqest);

    }
}
