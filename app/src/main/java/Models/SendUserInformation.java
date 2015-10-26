package Models;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import Utils.Constant;

/**
 * Created by Abdullah on 10/18/2015.
 */
public class SendUserInformation {
    private Context context;
    public SendUserInformation(Context context){
        this.context=context;

    }
    public void sendUserNumber(){
        String  userNumber=new GetPhoneInformation(context).getPhoneNumber();
        String url= Constant.USER_NUMBER_URL+"?User_Number="+userNumber;
        StringRequest sendResquest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v(Constant.LOG_Constant, " User Number Respose: " + response.toString());
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v(Constant.LOG_Constant,"User Number Response Error");
            }
        });
        VolleyInitializer.getInstance(context).AddRequest(sendResquest);
    }

}
