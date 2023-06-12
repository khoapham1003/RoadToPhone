package com.example.a21521003_airplanemode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AirplaneBroadcastReceiver extends BroadcastReceiver {
IAirplaneModeProcessable processor;
AirplaneBroadcastReceiver(IAirplaneModeProcessable processor)
{
    this.processor=processor;
}
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().compareTo(Intent.ACTION_AIRPLANE_MODE_CHANGED) == 0)
        {
            this.processor.airplaneProcess(intent.getBooleanExtra("state",false));
        }
    }
}
