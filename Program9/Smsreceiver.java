package com.example.itlab.msgalert;

import android.content.BroadcastReceiver;

import android.content.Context;

import android.content.Intent;

import android.os.Bundle;

import android.telephony.SmsMessage;

import android.widget.Toast;

/**

* Created by itlab on 25/1/18.34324324

*/

public class Smsreceiver extends BroadcastReceiver{

@Override

public void onReceive(Context context, Intent intent) {

Bundle bundle = intent.getExtras();

SmsMessage[] msgs = null;

String str = "";

if (bundle != null)

{

//---retrieve the SMS message received---

Object[] pdus = (Object[]) bundle.get("pdus");

msgs = new SmsMessage[pdus.length];

for (int i=0; i<msgs.length; i++){

msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);

str += "SMS from " + msgs[i].getOriginatingAddress();

str += " :";

str += msgs[i].getMessageBody().toString();

str += "n";

}

Toast.makeText(context,str,Toast.LENGTH_LONG).show();

}

}

}
