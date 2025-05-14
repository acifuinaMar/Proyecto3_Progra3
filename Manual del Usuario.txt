# Manual de Usuario | Proyecto 3, Programación 3
## Descripción del programa
Este programa permite registrar, buscar, eliminar e imprimir información de vehículos y sus propietarios, organizados en una **estructura de lista ortogonal** (una matriz de nodos). Cada vehículo está vinculado a un propietario con validaciones rigurosas para asegurar la integridad de los datos ingresados.
## ¿Cómo ejecutar el programa?
 1. **Requisitos previos**
    * Java Development Kit (JDK): Versión 17 o superior.
    * NetBeans IDE: Versión 12.0 o superior (opcional, pero recomendado).
    * Sistema Operativo: Windows, macOS o Linux.
2. **Archivos necesarios**
    * Proyecto3_Progra3.java
    * Lista.java
    * Nodo.java
    * Vehiculo.java
    * Propietario.java
3. **Iniciar desde NetBeans**
    * Abrir NetBeans y cargar el proyecto.
    * Asegurarse de que todos los archivos están en el mismo paquete.
    * Hacer clic en "Run" para ejecutar el proyecto.
4. **Iniciar desde Consola (Terminal)**
    * Compilar todos los archivos:
    ```
    javac*.java
    ```
    * Ejecutar el programa:
    ```
    java Proyecto3_Progra3
    ```

## Descripción del menú
Cuando se ejecuta el programa, en consola se despliega un menú con las siguientes opciones:
1. **Insertar**

**Datos requeridos**
* 1 número entero positivo para indicar la fila en la matriz ortogonal.
* 1 número entero positivo para indicar la columna en la matriz ortogonal.
* Placa del vehículo con la forma:
Prefijo + 3 consonantes + 3 dígitos. Recordando que, en Guatemala, se reconocen los prefijos: P, C, M, O, TRC.
* Color del vehículo (se admiten letras, números, espacios o guiones).
* Línea del vehículo.
* Modelo del vehículo en formato yyyy. Siendo admitidos modelos desde 1900 hasta el año en curso.
* CUI del propietario. 13 dígitos sin espacios o guiones, en el que los últimos 4 pertenecen al departamento y municipio de nacimiento, y el 9 dígito es el dígito verificador (calculado a partir del módulo 11).
* Nombre y apellido del propietario (solamente letrás con un máximo de 2 nombres y 2 apellidos).
* Fecha de nacimiento en formato dd/mm/yyyy .
**Validaciones**
* Formato correcto de placa y CUI.
*  Modelo dentro del rango válido.
* Nombres y apellidos conformados únicamente por letras.
* Fecha válida considerando días, meses y años bisiestos.
* Línea y color con caracteres válidos.

2. **Buscar**

Permite buscar un vehículo o propietrio ingresando cualquier criterio de búsqueda (placa, nombre, apellido, CUI, color, línea, modelo, entre otros). El programa despliega los resultados que coincidan con el críterio de búsqueda ingresado.

3. **Eliminar**

Permite eliminar un vehículo desde una posición específica en la matriz, ingresando la fila y columna correspondientes.

4. **Imprimir fila**

Muestra todos los vehículos registrados en una fila específica de la matriz ortogonal.

5. **Imprimir columna**

Muestra todos los vehículos registrados en una columan específica de la matriz ortogonal.

6. **Salir**

Finaliza la ejecución del programa.

## Mensajes de Error y Validación
Conforme se realizan los procesos, se muestran en consola mensajes de corroboración o alerta para hacer saber si la operación fue realizada con éxito o no. En caso de no ser concluidas con éxito, se hace saber al usuario qué información debe revisar o corregir y así garantizar la calidad de los datos. Algunos mensajes que encontrará son:
* "La placa ingresada ya se encuentra registrada."
* "Modelo inválido."
* "Nombre o apellido inválido."
* "CUI inválido."
* "Fecha de nacimiento inválida."
* "Marca, línea o color inválido."
* "Opción inválida." (si la opción de menú no es del 1 al 6).

## Preguntas Frecuentes (FAQ)
1. **¿Qué hacer si el programa no inicia?**
* Verifique que tiene instalada la versión correcta de Java (JDK 17 o superior).
* Asegúrese de que los archivos .java estén en la misma carpeta o paquete del proyecto.
* Si usa NetBeans, asegúrese de que el proyecto esté correctamente configurado y limpio (Clean and Build).

2. **¿Por qué recibo el mensaje "Placa ingresada ya existe"?**
* Cada vehículo debe tener una placa única. Si recibe este mensaje, significa que ya existe un vehículo registrado con esa placa.

3. **¿Qué debo hacer si aparece "CUI inválido"?**
* Asegúrese de que el CUI ingresado tiene 13 dígitos sin espacios ni guiones.
* Verifique que el dígito verificador (9º dígito) es correcto según el módulo 11.

4. **¿Puedo registrar más de un vehículo por propietario?**
* Sí, siempre que cada vehículo tenga una placa única.

5. ** ¿Qué hago si la fecha de nacimiento me da error?**
* Asegúrese de ingresarla en el formato dd/mm/yyyy.
* Verifique que el día, mes y año sean válidos (considerando años bisiestos).

6. **¿El programa guarda automáticamente los vehículos ingresados?**
* No. Los datos se mantienen mientras el programa esté en ejecución. Si desea guardar la información de manera permanente, deberá implementar un sistema de almacenamiento (archivos o base de datos).

7. **¿Puedo usar el programa sin NetBeans?**
* Sí. Puede ejecutarlo desde la consola (Terminal) siguiendo las instrucciones del apartado "¿Cómo ejecutar el Programa?".

8. **¿Qué pasa si intento eliminar un vehículo que no existe?**
* El programa le informará que la posición ingresada está vacía.