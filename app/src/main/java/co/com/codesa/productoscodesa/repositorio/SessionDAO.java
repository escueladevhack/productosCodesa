package co.com.codesa.productoscodesa.repositorio;

/**
 * Created by jggomezt on 05/10/2016.
 */

public class SessionDAO {

    private static ProductoDAO productoDAO;

    public static ProductoDAO getProductoDAO() {
        return productoDAO;
    }

    public static void setProductoDAO(ProductoDAO productoDAO) {
        SessionDAO.productoDAO = productoDAO;
    }
}
