package co.com.codesa.productoscodesa.presentacion.presenters;

import android.content.Context;

import java.util.List;

import co.com.codesa.productoscodesa.R;
import co.com.codesa.productoscodesa.Util.Cache;
import co.com.codesa.productoscodesa.dominio.LProducto;
import co.com.codesa.productoscodesa.modelo.Producto;
import co.com.codesa.productoscodesa.presentacion.fragments.Producto.IProducto1View;

/**
 * Created by jggomezt on 02/10/2016.
 */

public class Producto1Presenter implements IProducto1Presenter {

    private IProducto1View view;
    private Context context;
    private LProducto lProducto;

    public Producto1Presenter(IProducto1View view, Context context) {
        this.view = view;
        this.context = context;
        lProducto = new LProducto();
    }

    @Override
    public void sgte(String codigo, String nombre, String fechaVencimiento, String fechaProduccion,
                     String descripcion) {
        view.mostrarCargando();

        if (codigo == null || codigo.equals("")) {
            view.mostrarFaltaIngresoDatos(context.getResources().getString(R.string.digitarcodigo));
            view.ocultarCargando();
            return;
        }

        if (nombre == null || nombre.equals("")) {
            view.mostrarFaltaIngresoDatos(context.getResources().getString(R.string.digitarnombre));
            view.ocultarCargando();
            return;
        }

        if (descripcion == null || descripcion.equals("")) {
            view.mostrarFaltaIngresoDatos(context.getResources().getString(R.string.digitardescripcion));
            view.ocultarCargando();
            return;
        }

        Producto producto = new Producto();
        producto.setCodigo(codigo);
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setFechaPrd(fechaProduccion);
        producto.setFechaVencimiento(fechaVencimiento);

        Cache.getInstance().add("producto", producto);

        LProducto objLProducto = new LProducto();
        objLProducto.addProducto(producto.getCodigo(), producto.getNombre(), producto.getFechaVencimiento(),
                producto.getFechaPrd(), producto.getDescripcion(), producto.getPrecioCompra(),
                producto.getPrecioVenta(), producto.getTipo(), null);

        List<Producto> lstPrd = objLProducto.obtenerTodosProductos();

        view.ocultarCargando();

        view.irAProducto2();

    }

    @Override
    public void mostrarDatePicker(int requestCode) {
        view.mostrarDatePicker(requestCode);
    }

}
