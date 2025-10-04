# Manual Técnico

## 1. Descripción general
Aplicación de **consola** en Java para gestionar inventario de una tienda de ropa usando **vectores** y **archivos** (`inventario.txt`, `ventas.txt`, `bitacora.txt`). Incluye validaciones, bitácora y generación de reportes `.txt` (adaptable a PDF).

## 2. Requisitos
- Java **17+** (o versión del laboratorio)
- Apache **NetBeans 24**
- Sin uso de colecciones (`ArrayList`, `HashMap`, etc.)

## 3. Arquitectura y clases

### 3.1 `Producto`
**Campos**
- `String codigo`
- `String nombre`
- `String categoria`
- `double precio`
- `int cantidad`  *(stock)*

**Métodos clave**
- Constructor con validaciones básicas (precio > 0, cantidad ≥ 0, campos no vacíos)
- `getters/setters`
- `toString()`

### 3.2 Almacenamiento
- `Producto[] inventario = new Producto[100];`
- `int contadorProductos = 0;`

**Carga/guardado**
- `cargarInventario(Producto[] inventario)`  
  Lee `inventario.txt` y llena el vector.
- `guardarInventario(Producto[] inventario, int size)`  
  Reescribe el archivo con el contenido del vector.


### 3.3 Menú (en `Main`)
**Opciones**
1. Agregar producto  
   - Verifica **capacidad** y **código único**.  
   - Crea `Producto` y lo agrega a `inventario`.  
   - Llama `guardarInventario`.
2. Buscar producto  
   - Submenú: por **código**, **nombre contiene**, **categoría exacta**.  
   - Recorre vector y muestra coincidencias.
3. Eliminar producto  
   - Pide **confirmación**.  
   - Compacta el vector y reescribe archivo.
4. Registrar venta  
   - Busca por código, valida **stock**.  
   - `setCantidad(getCantidad() - cant)`  
   - `guardarInventario` y **append** a `ventas.txt`.
5. Generar reportes  
   - **Stock.txt** desde vector.  
   - **Venta.txt** leyendo `ventas.txt` y sumando total general.  
   - (*Adaptable a PDF si está permitido.*)
6. Ver datos del estudiante  
   - Imprime nombre, carné, sección.
7. Bitácora  
   - Muestra array `bitacora[]`.  
   - Cada acción registra `[fechaHora] ACCION=... RESULTADO=...`.

### 3.4 Bitácora
- Estructura simple: `String[] bitacora`, `int bitacoraSize`.
- Alta de registros en cada operación.
- Opción de persistir en `bitacora.txt` al salir.

## 4. Reglas y validaciones
- **Código único** (búsqueda lineal en el vector).
- `precio > 0`, `cantidad ≥ 0`, entradas numéricas válidas.
- En venta: `cant > 0` y `cant ≤ stock`.
- Manejo de entrada con `Scanner`: leer con `nextLine()` y **parsear**.

## 5. Estructuras de control
- Ciclos `for`/`while` para recorrer vectores.
- `switch` por opciones, **cada case con llaves `{}`** para aislar variables.

## 6. Errores comunes (y solución)
- Mezclar `nextInt()` con `nextLine()` → usar `nextLine()` + `parse`.
- `getcodigo` vs `getCodigo()` → respetar mayúsculas y **paréntesis**.
- Variables duplicadas en `case` → envolver cada `case` en `{}`.
- `NullPointerException` → validar índices y objetos no nulos.

## 7. Compilación y ejecución
- Abrir en NetBeans → **F6**.
- Directorio de trabajo: raíz del proyecto (donde se crean `.txt`).

## 8. Mejoras futuras
- Reportes en **PDF** (PDFBox), totales y estilos.
- Exportar/Importar CSV.
- Tests unitarios básicos.


