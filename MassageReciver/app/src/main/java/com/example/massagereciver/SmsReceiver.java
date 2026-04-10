package com.example.massagereciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();

        assert bundle != null;
        Object[] smsObj = (Object[]) bundle.get("pdus");

        assert smsObj != null;
        for (Object obj : smsObj) {

            SmsMessage massage = SmsMessage.createFromPdu((byte[]) obj);

            String mobNo = massage.getDisplayOriginatingAddress();
            String msg = massage.getDisplayMessageBody();

            Log.d("MsgDetails", "MobNo: "+ mobNo +", Msg: "+msg);

        }

    }
}
