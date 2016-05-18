package org.jwalker.backgroundthreadsample.intent_service;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.TextView;

import org.jwalker.backgroundthreadsample.R;

/**
 * Created by J.Walker on 16/5/17.
 */
public class StartActivity extends Activity {

    private MyBroadcastReciver myBroadcastReciver;

    private TextView mtextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        mtextview = (TextView) findViewById(R.id.textview);

        Intent intent = new Intent(this, MyIntentService.class);
        intent.putExtra("tag", "intentservice1");
        startService(intent);

        intent = new Intent(this, MyIntentService.class);
        intent.putExtra("tag", "intentservice2");
        startService(intent);
    }

    @Override
    protected void onStart() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Constants.BROADCAST_ACTION);
        myBroadcastReciver = new MyBroadcastReciver();
        LocalBroadcastManager.getInstance(this).registerReceiver(myBroadcastReciver, intentFilter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myBroadcastReciver);
        super.onStop();


    }


    public class MyBroadcastReciver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String data = intent.getStringExtra("data");
            mtextview.setText(data);
        }
    }
}