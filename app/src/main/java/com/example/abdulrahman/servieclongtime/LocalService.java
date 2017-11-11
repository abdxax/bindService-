package com.example.abdulrahman.servieclongtime;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Random;

/**
 * Created by Abdulrahman on 11/11/17.
 */

public class LocalService extends Service{
private final IBinder binder=new Bund();
private final Random random=new Random();

    int fb;
    @Override
    public void onCreate() {
        super.onCreate();
        fb=10;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //background code
        return START_NOT_STICKY;
    }

public class Bund extends Binder{
        LocalService service(){
            return LocalService.this;
    }
}
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public int getRandom(){
       return random.nextInt(100);
       // return fb;
    }
}
