package Proyecto1;

/**
 *
 * @author daniel
 */
public class Producto {
    //Atributos
    private String nombre;
    private String categoria;
    private double precio;
    private int cantidad;
    private String codigo;
    
    //Constructor
    public Producto(String nombre, String categoria, double precio, int cantidad, String codigo){
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
        this.codigo = codigo;        
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String toString(){
        return "Código: " + codigo + ", Nombre: " + nombre + ", Categoría: " + categoria + ", Precio: " + precio + ", Stock: "+ cantidad;
    }
}
