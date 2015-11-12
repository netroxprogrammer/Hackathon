package Models;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 11/11/2015.
 */
public class SdCardInformation {
    Context context;
    public  SdCardInformation(Context context){
        this.context=context;
    }

    /**
     * @getSdCardFilesAndDirs
     */

    public File[] getSdCardContents(){
        File[] lists = new File[0];
        String path=Environment.getExternalStorageDirectory().toString();
        File storage=new File(path);
        if(storage.isDirectory()){
            lists=storage.listFiles();
        }
        else {
            return null;
        }
        return lists;
    }

       /**
     * @CheckSdCardWriteableAndReadAble
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
