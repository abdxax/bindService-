package com.example.abdulrahman.servieclongtime;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  LocalService localService;
  boolean Bnudl=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent=new Intent(this,LocalService.class);
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
    }

    public void bustat(View view) {
        if(Bnudl){
            Toast.makeText(this,"num "+localService.getRandom(),Toast.LENGTH_LONG).show();
        }

    }

    private ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LocalService.Bund bund=(LocalService.Bund) iBinder;
            localService=bund.service();
            Bnudl=true;
        }

        @Override
    public void onServiceDisconnected(ComponentName componentName) {
        Bnudl=false;
    }
};
}
