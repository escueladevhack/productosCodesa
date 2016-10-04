package co.com.codesa.productoscodesa.presentacion.fragments.Producto;

/**
 * Created by jggomezt on 02/10/2016.
 */

public interface IProducto1View {

    void mostrarCargando();
    void ocultarCargando();
    void mostrarDatePicker(int requestCode);
    void clickSgte();
    void irAProducto2();
    void mostrarFaltaIngresoDatos(String dato);

}
