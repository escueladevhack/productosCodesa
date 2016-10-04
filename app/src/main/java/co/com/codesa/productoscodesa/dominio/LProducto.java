package co.com.codesa.productoscodesa.dominio;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import co.com.codesa.productoscodesa.modelo.Producto;

/**
 * Created by jggomezt on 02/10/2016.
 */

public class LProducto {

    public static List<Producto> lstProductos = new ArrayList<>();

    public void addProducto(String codigo, String nombre, String fechaVencimiento, String fechaProduccion,
                            String descripcion, double precioCompra, double precioVenta, String tipo,
                            List<Uri> urisImagenes) {

        Producto producto = new Producto();
        producto.setCodigo(codigo);
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setFechaPrd(fechaProduccion);
        producto.setFechaVencimiento(fechaVencimiento);
        producto.setPrecioCompra(precioCompra);
        producto.setPrecioVenta(precioVenta);
        producto.setTipo(tipo);
        producto.setUrisImagenes(urisImagenes);

        lstProductos.add(producto);

    }


}
