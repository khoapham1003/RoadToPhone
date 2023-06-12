package com.example.a21521003_batterychanged;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BatteryBroadcastReceiver extends BroadcastReceiver {
    RelativeLayout main;
    TextView text, batLevel;

    @Override
    public void onReceive(Context context, Intent intent) {
        main = (RelativeLayout) ((MainActivity) context).findViewById(R.id.main);
        text = (TextView) ((MainActivity) context).findViewById(R.id.text);
        batLevel = (TextView) ((MainActivity) context).findViewById(R.id.batLevel);
        if (intent.getAction() != null && intent.getAction().compareTo(Intent.ACTION_BATTERY_CHANGED) == 0) {
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
//            String level = intent.getStringExtra(BatteryManager.EXTRA_BATTERY_LOW);
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            int curPower = level * 100 / scale;
            batLevel.setText(String.valueOf(curPower) + "%");

//            if (intent.getAction()!=null && intent.getAction().compareTo(Intent.ACTION_BATTERY_LOW) == 0) {
//                main.setBackgroundColor(Color.YELLOW);
//                text.setText("Low battery");
//            }
//            else{
//                main.setBackgroundColor(Color.RED);
//                text.setText("cant catch");
//            }

            if (status == BatteryManager.BATTERY_STATUS_CHARGING) {
                text.setText("Charging");
            } else {
                text.setText("Not charging");
            }

            if (curPower <= 15) {
                main.setBackgroundColor(Color.YELLOW);
            } else {
                main.setBackgroundColor(Color.GREEN);
            }
        }
    }
}
