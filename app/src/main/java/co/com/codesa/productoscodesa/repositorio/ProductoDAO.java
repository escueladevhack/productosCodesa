package co.com.codesa.productoscodesa.repositorio;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import co.com.codesa.productoscodesa.modelo.Producto;

/**
 * Created by jggomezt on 05/10/2016.
 */

public class ProductoDAO implements IProductoDAO {

    private ProductosSQLiteHelper prdsqlite;

    public ProductoDAO(ProductosSQLiteHelper prdsqlite) {
        this.prdsqlite = prdsqlite;
    }

    @Override
    public void insertar(Producto producto) {
        /*String sql = "INSERT INTO Productos(codigo, nombre, fechaVenc, fechaPrd," +
                "descripcion, valorProd, valorVenta, tipo) values " +
                "(" + producto.getCodigo() + "," + producto.getNombre() + "," +
                producto.getFechaVencimiento() + "," + producto.getFechaPrd() + "," +
                producto.getDescripcion() + "," + producto.getPrecioCompra() + "," +
                producto.getPrecioVenta() + "," + producto.getTipo() + ")";*/

        ContentValues contentValues = new ContentValues();

        contentValues.put("codigo", producto.getCodigo());
        contentValues.put("nombre", producto.getNombre());
        contentValues.put("fechaVenc", producto.getFechaVencimiento());
        contentValues.put("fechaPrd", producto.getFechaPrd());
        contentValues.put("descripcion", producto.getDescripcion());
        contentValues.put("valorProd", producto.getPrecioCompra());
        contentValues.put("valorVenta", producto.getPrecioVenta());
        contentValues.put("tipo", producto.getTipo());

        SQLiteDatabase db = prdsqlite.getWritableDatabase();
        db.insert("Productos", null, contentValues);
    }

    @Override
    public List<Producto> obtenerTodos() {
        SQLiteDatabase sql = prdsqlite.getReadableDatabase();
        String columnas[] = new String[]{"codigo, nombre, fechaVenc, fechaPrd, descripcion",
                "valorProd", "valorVenta", "tipo"};
        Cursor cursor = sql.query("Productos", columnas, null, null, null, null, null);

        Producto producto;
        List<Producto> lstPrd = new ArrayList<>();

        while (cursor.moveToNext()) {
            producto = new Producto();
            producto.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            producto.setCodigo(cursor.getString(cursor.getColumnIndex("codigo")));
            producto.setFechaVencimiento(cursor.getString(cursor.getColumnIndex("fechaVenc")));
            producto.setFechaPrd(cursor.getString(cursor.getColumnIndex("fechaPrd")));
            producto.setDescripcion(cursor.getString(cursor.getColumnIndex("descripcion")));
            producto.setPrecioCompra(cursor.getDouble(cursor.getColumnIndex("valorProd")));
            producto.setPrecioVenta(cursor.getDouble(cursor.getColumnIndex("valorVenta")));
            producto.setTipo(cursor.getString(cursor.getColumnIndex("tipo")));
            lstPrd.add(producto);
        }

        return lstPrd;
    }

    @Override
    public Producto obtenerPorId() {
        SQLiteDatabase db = prdsqlite.getReadableDatabase();
        String select = "Select codigo, nombre, fechaVenc, fechaPrd, descripcion," +
                "valorProd,valorVenta,tipo from Productos";

        Cursor cursor = db.rawQuery(select, null);

        Producto producto = null;

        if (cursor.moveToNext()) {
            producto = new Producto();
            producto.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            producto.setCodigo(cursor.getString(cursor.getColumnIndex("codigo")));
            producto.setFechaVencimiento(cursor.getString(cursor.getColumnIndex("fechaVenc")));
            producto.setFechaPrd(cursor.getString(cursor.getColumnIndex("fechaPrd")));
            producto.setDescripcion(cursor.getString(cursor.getColumnIndex("descripcion")));
            producto.setPrecioCompra(cursor.getDouble(cursor.getColumnIndex("valorProd")));
            producto.setPrecioVenta(cursor.getDouble(cursor.getColumnIndex("valorVenta")));
            producto.setTipo(cursor.getString(cursor.getColumnIndex("tipo")));
        }

        return producto;

    }

}
