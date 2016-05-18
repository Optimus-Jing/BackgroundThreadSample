package org.jwalker.backgroundthreadsample.intent_service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * Created by J.Walker on 16/5/16.
 */
public class MyIntentService extends IntentService {


    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        try {
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String tag = intent.getStringExtra("tag");
        Log.d("MyIntentService", tag);

        Intent mintent = new Intent(Constants.BROADCAST_ACTION);
        mintent.putExtra("data", "from myintentservice data" + tag);
        LocalBroadcastManager.getInstance(this).sendBroadcast(mintent);
    }


}
