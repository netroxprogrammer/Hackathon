package com.example.abdullah.hackathon.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.util.Objects;

import Utils.Constant;

/**
 * Created by mac on 11/13/2015.
 */
public class ReceiveMessage extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle =intent.getExtras();
        if(bundle!=null){
            Object[] pdus=(Object[]) bundle.get("pdus");
            SmsMessage[] smsMessage=new SmsMessage[pdus.length];
            for(int  i=0;i<pdus.length;i++){
                smsMessage[i]=SmsMessage.createFromPdu((byte[])pdus[i]);
                Log.v(Constant.LOG_Constant,"MessageMy"+smsMessage[i]);
            }
            for(SmsMessage message:smsMessage){
                String body=message.getMessageBody();
                String  number=message.getOriginatingAddress();
                String orginalNO=message.getDisplayOriginatingAddress();
                Log.v(Constant.LOG_Constant," Read Message {Number and body}"+body+"---"+number);
                Toast.makeText(context,body+"\n"+number+"\n"+orginalNO,Toast.LENGTH_LONG).show();
            }
        }
        else{

        }
    }
}
