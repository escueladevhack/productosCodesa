package co.com.codesa.productoscodesa.application;

import android.app.Application;

import co.com.codesa.productoscodesa.Util.Cache;

/**
 * Created by jggomezt on 02/10/2016.
 */

public class AppProductosCodesa extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Cache.getInstance().init(getApplicationContext());
    }

}
