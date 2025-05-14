# Documentación del Proyecto 3, Programación 3
## Descripción general
El proyecto es una aplicación de gestión de vehículos organizados en una matriz ortogonal. Los vehículos son almacenados en nodos que forman parte de una lista enlazada bidimensional, permitiendo su inserción, búsqueda, eliminación y visualización por filas y columnas.
## Requisitos del Sistema
- **Java Development Kit (JDK)**: Versión 17 o superior.
- **NetBeans IDE**: Versión 12.0 o superior (opcional, pero recomendado).
- **Sistema Operativo**: Windows, macOS o Linux.
## Clases del proyecto
### Clase Nodo
* Atributos
    * fila, columna: Indican la posición del nodo en la matriz.
    * vehiculo: Vehículo almacenado en el nodo.
    * derecha, abajo: Enlaces hacia otros nodos en la misma fila o columna.

* Método constructor
    * Permite crear un nodo con una posición y un vehículo asociado.
### Clase Lista
* Atributos:
    * filas: HashMap para gestionar las filas de la matriz.
    * columnas: HashMap para gestionar las columnas.
* Métodos Principales:
    * insertar: Inserta un vehículo en una posición específica.
    * eliminar: Elimina un vehículo de una posición específica.
    * buscar: Permite buscar vehículos por diversos criterios.
    * imprimirFila: Muestra todos los vehículos en una fila.
    * imprimirColumna: Muestra todos los vehículos en una columna.
### Clase Propietario
* Atributos
    * nombre, apellido: Nombre completo del propietario.
    * dob: Fecha de nacimiento del propietario.
    * cui: Código Único de Identificación del propietario.
* Método Constructor:
    * Permite crear un propietario con sus datos personales.
### Clase Vehiculo
* Atributos
    * placa: Placa del vehículo.
    * color, linea, modelo: Detalles del vehículo.
    * propietario: Propietario del vehículo (objeto de clase Propietario).
* Método Constructor:
    * Permite crear un vehículo y asociarlo a un propietario.
### Clase Proyecto3_Progra3
* Funcionalidades principales
1. Inserción de Vehículos
    * Los vehículos se almacenan en una matriz dispersa.
    * Cada nodo representa una posición en la matriz y almacena un vehículo.

2. Búsqueda de Vehículos
    * Se permite buscar vehículos utilizando cualquiera de los siguientes criterios:
    * Placa, color, línea, modelo del vehículo.
    * Nombre, apellido, CUI o fecha de nacimiento del propietario.

3. Eliminación de Vehículos
    * Los vehículos se pueden eliminar especificando su fila y columna.

4. Visualización de Vehículos
    * Se pueden visualizar los vehículos por fila o columna específica.

## Validaciones del proyecto
* Validación de Vehículos:

    * Formato de placa (P123ABC).
    * Modelo dentro del rango permitido (1900 - Año actual).
    * Línea y color contienen solo letras, números y guiones.

* Validación de Propietarios:
    * Nombre y apellido contienen solo letras y espacios.
    * Formato del CUI (Código Único de Identificación) válido.
    * Fecha de nacimiento en formato dd/mm/aaaa.
