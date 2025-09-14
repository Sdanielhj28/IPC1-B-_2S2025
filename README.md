# Sistema de Inventario – Tienda de Ropa (Consola / Java)

Proyecto de **Introducción a la Programación y Computación 1**: sistema de inventario en **Java** (consola), usando **arreglos (vectores)**, manejo de archivos y validaciones.

##  Funcionalidades
- Agregar producto (código único, precio > 0, stock ≥ 0)
- Buscar producto (por **código**, **nombre** o **categoría**)
- Eliminar producto (con confirmación y compactación del arreglo)
- Registrar venta (valida stock, descuenta y **registra en `ventas.txt`**)
- Bitácora (acciones **OK/ERROR** con fecha/hora y usuario; visualización en menú)
- Reportes (**Stock** y **Ventas** en `.txt` con timestamp; preparado para PDF)
- Ver datos del estudiante


##  Requisitos
- Java **17+** (o el que use tu NetBeans)
- **Apache NetBeans 24**
- Consola (sin GUI)
- **Sin** colecciones (no `ArrayList`, `HashMap`, etc.)

## ▶ Cómo ejecutar
1. Abrir el proyecto en **NetBeans 24**.
2. Asegurarte de que `Main.java` tenga el `public static void main`.
3. **Run (F6)**.
4. El menú se mostrará en consola.

> Si `inventario.txt` existe en la carpeta raíz del proyecto, se **carga al iniciar**.

##  Formatos de archivos
- `inventario.txt`  
  `codigo|nombre|categoria|precio|stock`  
  Ej.: `P001|Camisa básica|Camisas|125.00|20`

- `ventas.txt`  
  `fechaHora|codigo|cantidad|total`  
  Ej.: `27/02/2025 14:31:05|P001|3|375.00`

- `bitacora.txt` (si eliges persistirla al salir)  
  `[dd/MM/yyyy HH:mm:ss] ACCION=AGREGAR RESULTADO=OK USUARIO=Dani COD=P001`

##  Pruebas rápidas
- Agregar 2 productos (uno duplicado → debe **rechazar**).
- Buscar por código/nombre/categoría.
- Vender con stock suficiente e **insuficiente** (debe rechazar).
- Eliminar producto existente y no existente.
- Salir y volver a entrar → que **cargue** inventario desde archivo.
- Generar reportes (se crean `.txt` con timestamp).

##  Pendientes/Notas
- Si la cátedra lo autoriza, generar **PDF** (Stock/Ventas) con PDFBox y nombres:  
  `DD_MM_YYYY_HH_mm_ss_Stock.pdf` y `DD_MM_YYYY_HH_mm_ss_Venta.pdf`.
- Validaciones adicionales y más mensajes de error amigables.

##  Estudiante
- **Nombre:** Sergio Daniel Hernández Juárez
- **Carné:** 202100246
- **Sección:** B

