package Proyecto1;

/**
 *
 * @author daniel
 */
public class Inventario {
    private Producto[] productos;
    private int contador;
    
    public Inventario(int capacidad){
        productos = new Producto[capacidad];
        contador = 0;
    }
    public void agregarProducto(Producto p){
        //Validar código único y campos
        //Agregar al arreglo
    }
    public void buscarPorCodigo(String codigo){
        //Recorrer arreglo y comparar
    }
}
