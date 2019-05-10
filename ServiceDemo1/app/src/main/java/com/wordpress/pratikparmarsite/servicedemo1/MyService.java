package com.wordpress.pratikparmarsite.servicedemo1;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by pratik on 12/9/17.
 */

public class MyService extends Service {

    public IBinder bind=new MyBinder();

    public IBinder onBind(Intent intent)
    {
        return bind;
    }

    public void onCreate() {
        Toast.makeText(this, "Service has started", Toast.LENGTH_LONG).show();
    }

    class MyBinder extends Binder
    {
        MyService getService()
        {
            return MyService.this;
        }

    }

}
