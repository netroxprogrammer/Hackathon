package Applications;
import android.content.Context;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import Utils.Constant;

/**
 * Created by mac on 11/12/2015.
 */
public class HandleSockets extends AsyncTask<Void,Void,Void>{
    Context context;
    public  HandleSockets(Context context){
        this.context=context;
    }
    @Override
    protected Void doInBackground(Void... params) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
            try {
                Log.v(Constant.LOG_Constant,"Waiting  for Connection");
                while(true) {
                    Socket socket=new Socket("192.168.1.100",12345);
                    InputStream input=socket.getInputStream();
                    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(input));
                    String  data="";
                    if((data=bufferedReader.readLine())!=null){
                        Log.v(Constant.LOG_Constant,"SocketData-----"+data);
                    }
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            return null;

    }
}
