package com.samples.network.wifimanagement;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WiFiChangeActivity extends Activity
        implements View.OnClickListener{

    private TextView textView;
    private BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wi_fi_change);

        textView = (TextView)findViewById(R.id.text);

        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

            }
        };
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bEnable:

                break;
            case R.id.bDisable:

                break;
        }
    }
}
