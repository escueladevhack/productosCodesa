package co.com.codesa.productoscodesa.presentacion.presenters;

/**
 * Created by jggomezt on 02/10/2016.
 */

public interface IProducto1Presenter {

    void sgte(String codigo, String nombre, String fechaVencimiento, String fechaProduccion,
              String descripcion);

    void mostrarDatePicker(int requestCode);

}
