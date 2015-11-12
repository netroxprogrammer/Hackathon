package Applications;

import android.content.Context;
import android.os.AsyncTask;
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

            try {
                Log.v(Constant.LOG_Constant,"Waiting  for Connection");
                while(true) {
                    ServerSocket server = new ServerSocket(12345);
                    Socket client = server.accept();
                    Log.v(Constant.LOG_Constant,client.toString());
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            return null;

    }
}
