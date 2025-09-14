package Proyecto1;

import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Producto[] inventario = new Producto[100];
        int contadorProductos = 0;
        int opcion;
        
        do {
            System.out.println("\n=== SISTEMA DE INVENTARIO ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Buscar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Registrar venta");
            System.out.println("5. Ver bitácora");
            System.out.println("6. Generar reportes");
            System.out.println("7. Ver datos del estudiante");
            System.out.println("8. Salir");
            
            System.out.print("Seleccione una opción: ");
            String _tmp = sc.nextLine().trim();
            try {
                opcion = Integer.parseInt(_tmp);
            } catch (NumberFormatException e){
                System.out.println("Opción inválida.");
                opcion = -1;
            }
            //Limpiar buffer
            switch (opcion) {
                case 1: {
                    //Agrgar producto
                    System.out.println("\n--- AGREGAR PRODUCTO ---");
                    System.out.print("Código: ");
                    String codigo = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Categoria; ");
                    String categoria = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    System.out.print("Cantidad; ");
                    int cantidad = sc.nextInt();
                    
                    Producto nuevoProducto = new Producto(nombre, categoria, precio, cantidad, codigo);
                    inventario[contadorProductos] = nuevoProducto;
                    contadorProductos++;
                    System.out.println("Producto agregado exitosamente!");
                    break;
                }
                case 2:{
                    //Buscar producto
                    System.out.println("\n--- BUSCAR PRODUCTO ---");
                    System.out.print("Ingrese el código a buscar: ");
                    String codigoBuscar = sc.nextLine().trim();
                    boolean encontrado = false;
                    
                    for (int i = 0; i < contadorProductos; i++){
                        if (inventario[i].getCodigo().equals(codigoBuscar)){
                            System.out.println("Producto encontrado: " + inventario[i]);
                            encontrado = true;
                            break;                        
                        }
                    }    
                    if (!encontrado) System.out.println("Producto no encontrado");
                    break;
                }
                case 3:{
                    //Eliminar producto
                    System.out.println("\n--- ELIMINAR PRODUCTO---");
                    System.out.print("Ingrese el código del producto a eliminar: ");
                    String codigoEliminar = sc.nextline();
                    boolean eliminado = false;
                    
                    for (int i= 0; i < contadorProductos; i++){
                        if (inventario[i].getCodigo().equals(codigoEliminar)){
                            for (int j = i; j < contadorProductos - 1; j++){
                                inventario[j] = inventario [j + 1];
                        }
                        inventario[contadorProductos - 1] = null;
                        contadorProductos--;
                        eliminado = true;
                        System.out.println("Producto eliminado exitosamente.");
                        break;
                    }        
            }
                  if (!eliminado){
                        System.out.println("No se encontró con ese código.");
                    }
                    break;
                }
                    case 4:{
                    //Registrar venta
                   System.out.println("\n--- REGISTRAR VENTA ---");
                   System.out.print("Ingrese el código del producto; ");
                   String codigoVenta = sc.nextLine();
                   
                   Producto productoVenta = null;
                   int indiceVenta = -1;
                   for (int i = 0; i < contadorProductos; i++){
                    if (inventario[i].getCodigo().equals(codigoVenta)){
                    productoVenta = inventario[i];
                    indiceVenta = i;
                    break;
                    }
                   }
                   //Si no existe, salir
                   if (productoVenta == null){
                       System.out.println("Código no encontrado.");
                       break;
                   }
                   //Pedir cantidad 
                        System.out.println("Cantidad a vender: ");
                        int cantV = Integer.parseInt(sc.nextLine().trim());
                        if (cantV <=0 ){
                            System.out.println("Cantidad inválida.");
                            break;
                        }
                        if (cantV > productoVenta.getCantidad()){
                            System.out.println("Stock insuficiente.");
                            break;
                        }
                        int nuevoStock = productoVenta.getCantidad()-cantV;
                        inventario[indiceVenta].setCantidad(nuevoStock);
                        double total = productoVenta.getPrecio()*cantV;
                        System.out.println("Venta registrada. Total: %.2f\n", total);
                        break;
                    }
                    case 5:{
                        System.out.println("\n--- GENERAR REPORTES ---");
                        System.out.println("1) Reporte de stock (TXT)");
                        System.out.println("2) Reporte de ventas (TXT)");
                        System.out.print("Elige: ");
                        int opt;
                        try{
                            opt = Integer.parseInt(sc.nextLine().trim());
                        } catch (NumberFormatException e){
                            System.out.println("Opción inválida.");
                            break;
                        }
                        DatetimeFormatter fmt = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
                        String stamp = LocalDateTime.now().format(fmt);
                        
                        try{
                            if (opt == 1){
                                // ---- REPORTE DE STOCK ----
                                String nombre = stamp + "_Stock.txt";
                                try (PrintWriter pw = new PrintWriter(new FileWrite(nombre))){
                               pw.Println("REPORTE DE STOCK - " + stamp);
                               pw.Println("Código | Nombre | Categoria | Precio | Stock");
                               for (int i = 0; i < contadorProductos; i++){
                                   producto p = inventario[i];
                                   pw.printf("%s | %s | %s | %.2f | %d%n", p.getCodigo(), p.getNombre(), p.getCategoria(), p.getPrecio(), p.getCantidad());
                               }
                            }
                                System.out.println("Archivo generado: " + nombre);
                                
                        } else if (opt == 2){
                            // --- REPORTE DE VEMTAS ---
                            String nombre = stamp + "_Venta-txt";
                            double totalGeneral = 0.0;
                            
                            if (Files.exists(paths.get("ventas.txt"))){
                                List<String> lineas = Files.readAllLines(Paths.get("Ventas.txt"));
                                try (PrintWriter pw = new PrinteWriter(new FileWriter(nombre))){
                                    pw.println("REPORTE DE VENTAS - " + stamp);
                                    pw.println("FechaHora | Codigo | Cantidad | Total");
                                    for (String linea : lineas){
                                        pw.println(linea);
                                        String[] parts = linea.split("\\|");
                                        if (parts.length >=4){
                                            try{
                                                totalGeneral += Double.parseDouble(parts[3].trim());
                                            } catch (NumberFormatException ignore) {}
                                        }
                                    }
                                    pw.println("TOTAL GENERAL: %.2f%n", totalGeneral);
                                }
                                System.out.println("Archivo generado: " + nombre);
                            }else {
                                try (PrintWrite pw = new PrintWriter(new FileWriter(nombre))){
                                    pw.println("REPORTE DE VENTAS - " stamp);
                                    pw.println("No se encontró 'Venta.txt'. Aún no hay ventas registradas.");
                                }
                            }else{
                                    System.out.println("Opcion inválida.");
                                    }
                        }catch(IOException e){
                                System.out.println("Error al generar archivo; " + e.getMessage());
                                }
                        break;
                    }
                    }
                    case 6: {
                        System.out.println("\n--- DATOS DEL ESTUDIANTE ---");
                        System.out.println("Nombre: Sergio Daniel Hernández Juárez");
                        System.out.println("Carnet: 202100246");
                        System.out.println("Sección: B");
                        System.out.println("Curso: IPC1 - 2S2025");
                        break;
                    }
                    case 7: {
                        System.out.println("Saliendo del sistema...");
                        break;
                    }
