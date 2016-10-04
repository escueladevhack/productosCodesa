package co.com.codesa.productoscodesa.modelo;

import android.net.Uri;

import java.util.List;

/**
 * Created by jggomezt on 02/10/2016.
 */

public class Producto {

    private String codigo;
    private String nombre;
    private String descripcion;
    private String fechaVencimiento;
    private String fechaPrd;
    private double precioCompra;
    private double precioVenta;
    private String tipo;
    private List<Uri> urisImagenes;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFechaPrd() {
        return fechaPrd;
    }

    public void setFechaPrd(String fechaPrd) {
        this.fechaPrd = fechaPrd;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Uri> getUrisImagenes() {
        return urisImagenes;
    }

    public void setUrisImagenes(List<Uri> urisImagenes) {
        this.urisImagenes = urisImagenes;
    }
}
