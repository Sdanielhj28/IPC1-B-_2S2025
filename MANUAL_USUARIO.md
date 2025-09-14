# Manual de Usuario

## 1. Introducción
Este sistema permite gestionar el inventario de una tienda de ropa desde la consola: agregar, buscar, eliminar productos, registrar ventas, ver bitácora y generar reportes.

## 2. Requisitos
- Computadora con Java y NetBeans (o consola Java)
- Archivos se guardan en la carpeta del proyecto

## 3. Inicio
1. Abrir el proyecto en NetBeans.
2. Ejecutar (F6).
3. Aparece el menú principal con opciones 1–8.

## 4. Uso del sistema

### 4.1 Agregar producto (Opción 1)
- Ingrese **Código**, **Nombre**, **Categoría**, **Precio**, **Cantidad**.
- El sistema valida:
  - Código **único**
  - Precio **mayor a 0**
  - Cantidad **mayor o igual a 0**
- Si es correcto, se guarda en `inventario.txt`.

### 4.2 Buscar producto (Opción 2)
- Elija el modo:
  1. Por **código** (exacto)
  2. Por **nombre** (contiene)
  3. Por **categoría** (exacta)
- Se muestran las coincidencias.

### 4.3 Eliminar producto (Opción 3)
- Ingrese el **código** del producto.
- Confirme con **S** para eliminar.
- El inventario se actualiza y guarda.

### 4.4 Registrar venta (Opción 4)
- Ingrese el **código** del producto.
- Ingrese la **cantidad** a vender.
- Si hay stock suficiente:
  - Se descuenta del inventario.
  - Se registra la venta en `ventas.txt` con **fecha/hora** y **total**.
  - Muestra el total de la venta.

### 4.5 Generar reportes (Opción 5)
- Elija:
  - **1) Stock (TXT)**: crea un archivo con todos los productos y su stock.
  - **2) Ventas (TXT)**: crea un archivo con el historial de ventas y total general.
- Los nombres incluyen **fecha/hora** (ej. `27_02_2025_14_31_05_Stock.txt`).

### 4.6 Ver datos del estudiante (Opción 6)
- Muestra nombre, carné y sección.

### 4.7 Bitácora (Opción 7)
- Muestra la lista de acciones realizadas durante la ejecución.
- Cada registro contiene fecha/hora, acción y resultado.

### 4.8 Salir (Opción 8)
- Finaliza el programa.
- (Opcional) Guarda la bitácora en `bitacora.txt`.

## 5. Consejos y solución de problemas
- Si una lectura “se salta”, ingrese de nuevo: use números válidos y no deje campos vacíos.
- Si no encuentra un producto, verifique el **código** o los filtros de búsqueda.
- Compruebe que los archivos `inventario.txt` y `ventas.txt` estén en la carpeta del proyecto.

## 6. Contacto
- Estudiante: Sergio Daniel Hernández Juárez 
- Carné: 202100246
- Curso/Sección: IPC1_B
