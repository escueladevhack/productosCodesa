package co.com.codesa.productoscodesa.repositorio;

import java.util.List;

import co.com.codesa.productoscodesa.modelo.Producto;

/**
 * Created by jggomezt on 05/10/2016.
 */

public interface IProductoDAO {

    void insertar(Producto producto);

    List<Producto> obtenerTodos();

    Producto obtenerPorId();

}
