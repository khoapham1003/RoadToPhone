package com.example.a21521003_airplanemode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IAirplaneModeProcessable {

    AirplaneBroadcastReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isAirplane = Settings.System.getInt(this.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON,0)!=0;
    this.airplaneProcess(isAirplane);


    receiver=new AirplaneBroadcastReceiver(this);
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        this.registerReceiver(receiver,intentFilter);

    }

    public void airplaneProcess(boolean isAirplaneMode){
        String text = "Airplane mode is OFF";
        if(isAirplaneMode)
        {
            text = "Airplane mode is ON";
        }
        TextView status = findViewById(R.id.tv_status);
        status.setText(text);
        Toast.makeText(this, "AIRPLANE_MODE_CHANGE", Toast.LENGTH_SHORT).show();
    }

    @Override

    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}

