package com.samples.network.wifimanagement;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WiFiChangeActivity extends Activity
        implements View.OnClickListener{

    private TextView text;
    private WifiManager wifiManager;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifiState = intent.getIntExtra(
                    WifiManager.EXTRA_WIFI_STATE,
                    WifiManager.WIFI_STATE_UNKNOWN);
            text.append("\n\t");
            switch(wifiState){
                case WifiManager.WIFI_STATE_ENABLING:
                    text.append("Wi-Fi state enabling");
                    break;
                case WifiManager.WIFI_STATE_ENABLED:
                    text.append("Wi-Fi state enabled");
                    break;
                case WifiManager.WIFI_STATE_DISABLING:
                    text.append("Wi-Fi state disabling");
                    break;
                case WifiManager.WIFI_STATE_DISABLED:
                    text.append("Wi-Fi state disabled");
                    break;
                case WifiManager.WIFI_STATE_UNKNOWN:
                    text.append("Wi-Fi state unknown");
                    break;
                default:
                    text.append("Not defined");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wi_fi_change);

        text = (TextView)findViewById(R.id.text);
        text.append("Current wi-fi state");

        wifiManager = (WifiManager)getSystemService(WIFI_SERVICE);

        this.registerReceiver(receiver, new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bEnable:
                wifiManager.setWifiEnabled(true);
                text.append("\nStart enable Wi-Fi...");
                break;
            case R.id.bDisable:
                wifiManager.setWifiEnabled(false);
                text.append("\nStart disable Wi-Fi...");
                break;
        }
    }
}
