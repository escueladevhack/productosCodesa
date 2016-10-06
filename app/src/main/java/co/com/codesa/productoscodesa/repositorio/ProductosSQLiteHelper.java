package co.com.codesa.productoscodesa.repositorio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jggomezt on 05/10/2016.
 */

public class ProductosSQLiteHelper extends SQLiteOpenHelper {

    public ProductosSQLiteHelper(Context context, String name,
                                 SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreate = "CREATE TABLE Productos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "codigo TEXT, " +
                "nombre TEXT, " +
                "fechaVenc TEXT," +
                "fechaPrd TEXT, " +
                "descripcion TEXT, " +
                "valorProd REAL," +
                "valorVenta REAL," +
                "tipo TEXT )";

        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
