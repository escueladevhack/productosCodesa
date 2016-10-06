package co.com.codesa.productoscodesa.dominio;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import co.com.codesa.productoscodesa.modelo.Producto;
import co.com.codesa.productoscodesa.repositorio.IProductoDAO;
import co.com.codesa.productoscodesa.repositorio.SessionDAO;

/**
 * Created by jggomezt on 02/10/2016.
 */

public class LProducto {

    private static List<Producto> lstProductos = new ArrayList<>();

    private IProductoDAO productoDAO;

    public LProducto() {
        productoDAO = SessionDAO.getProductoDAO();
    }

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

        productoDAO.insertar(producto);

    }

    public List<Producto> obtenerTodosProductos(){
        return productoDAO.obtenerTodos();
    }


}
