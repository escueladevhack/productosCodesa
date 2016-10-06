package co.com.codesa.productoscodesa.application;

import android.app.Application;

import co.com.codesa.productoscodesa.Util.Cache;
import co.com.codesa.productoscodesa.repositorio.ProductoDAO;
import co.com.codesa.productoscodesa.repositorio.ProductosSQLiteHelper;
import co.com.codesa.productoscodesa.repositorio.SessionDAO;

/**
 * Created by jggomezt on 02/10/2016.
 */

public class AppProductosCodesa extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Cache.getInstance().init(getApplicationContext());
        ProductosSQLiteHelper prdsqlite = new ProductosSQLiteHelper(getApplicationContext(),
                "DBProductosCodesa", null, 1);
        SessionDAO.setProductoDAO(new ProductoDAO(prdsqlite));

    }

}
