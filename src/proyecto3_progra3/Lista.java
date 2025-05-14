/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto3_progra3;

/**
 *
 * @author maryori
 */
import java.util.HashMap;
public class Lista {
    //Para guardar filas y columnas de los nodos
    private HashMap<Integer, Nodo> filas = new HashMap<>();
    private HashMap<Integer, Nodo> columnas = new HashMap<>();
    
    //Metodo de insercion de un vehiculo en un nodo
    public void insertar(int fila, int columna, Vehiculo vehiculo) {
        //Verifico si ya hay un carrito en la posicion
        if (obtenerNodo(fila, columna) != null) {
            System.out.println("Ya existe un vehículo en la posición (" + fila + ", " + columna + "). No se puede sobreescribir.");
        } else {
            //Creo un nuevo nodo con la ubicacion y carrito dado
            Nodo nuevo = new Nodo(fila, columna, vehiculo);
            // Empiezo por insertar el nodo en la fila
            if (!filas.containsKey(fila)) {
                //Si la fila no existe, la creo
                filas.put(fila, nuevo);
            } else {
                Nodo aux = filas.get(fila);
                //Si la columna es menor que la del primer nodo, lo inserto antes
                if (columna < aux.columna) {
                    nuevo.derecha = aux;
                    filas.put(fila, nuevo);
                } else {
                    //Recorrer la fila hasta encontrar la posicion solicitada
                    while (aux.derecha != null && aux.derecha.columna < columna) {
                        aux = aux.derecha;
                    }
                    //Insertar el nuevo nodo
                    nuevo.derecha = aux.derecha;
                    aux.derecha = nuevo;
                }
            }

            // Insertar en la columna
            if (!columnas.containsKey(columna)) {
                //Si la columna no existe, la creo
                columnas.put(columna, nuevo);
            } else {
                Nodo aux = columnas.get(columna);
                //Si la fila es menor que la del primer nodo, lo inserto antes
                if (fila < aux.fila) {
                    nuevo.abajo = aux;
                    columnas.put(columna, nuevo);
                } else {
                    //Recorro la columna hasta encontrar la posicion
                    while (aux.abajo != null && aux.abajo.fila < fila) {
                        aux = aux.abajo;
                    }
                    //Inserto el nuevo nodo en la posicion
                    nuevo.abajo = aux.abajo;
                    aux.abajo = nuevo;
                }
            }
        }
    }
    
    //Para eliminar
    public void eliminar(int fila, int columna) {
        boolean eliminado = false;

        // Eliminar de la fila
        if (filas.containsKey(fila)) {
            Nodo actual = filas.get(fila);

            // Caso especial, el primer nodo de la fila
            if (actual.columna == columna) {
                filas.put(fila, actual.derecha);
                eliminado = true;
            } else {
                Nodo antes = actual;
                actual = actual.derecha;

                while (actual != null && actual.columna != columna) {
                    antes = actual;
                    actual = actual.derecha;
                }

                if (actual != null) {
                    antes.derecha = actual.derecha;
                    eliminado = true;
                }
            }

            // Si ya no hay nodos en esta fila, eliminarla del mapa
            if (filas.get(fila) == null) {
                filas.remove(fila);
            }
        }

        // Eliminar de la columna
        if (columnas.containsKey(columna)) {
            Nodo actual = columnas.get(columna);

            // Caso especial, el primer nodo de la columna
            if (actual.fila == fila) {
                columnas.put(columna, actual.abajo);
                eliminado = true;
            } else {
                Nodo antes = actual;
                actual = actual.abajo;

                while (actual != null && actual.fila != fila) {
                    antes = actual;
                    actual = actual.abajo;
                }

                if (actual != null) {
                    antes.abajo = actual.abajo;
                    eliminado = true;
                }
            }

            // Si ya no hay nodos en esta columna, eliminarla del mapa
            if (columnas.get(columna) == null) {
                columnas.remove(columna);
            }
        }

        if (eliminado) {
            System.out.println("Vehículo eliminado exitosamente de (" + fila + ", " + columna + ").");
        } else {
            System.out.println("No se encontró ningún vehículo en (" + fila + ", " + columna + ").");
        }
    }

    //Para encontrar con cualquier criterio
    public void buscar(String criterio) {
        //Indicador
        boolean encontrado = false;
        //Recorro todas las filas (HashMap filas)
        for (Nodo filaActual : filas.values()) {
            Nodo actual = filaActual;
            //Recorro los nodos de la fila actual
            while (actual != null) {
                Vehiculo v = actual.vehiculo;
                Propietario p = v.propietario;

                //Verifico si lo que mando es user coincide con cualquier info registrada
                if (v.placa.equalsIgnoreCase(criterio) ||
                    v.color.equalsIgnoreCase(criterio) ||
                    v.linea.equalsIgnoreCase(criterio) ||
                    v.modelo.equalsIgnoreCase(criterio) ||
                    p.nombre.equalsIgnoreCase(criterio) ||
                    p.apellido.equalsIgnoreCase(criterio) ||
                    p.dob.equalsIgnoreCase(criterio) ||
                    p.cui.equalsIgnoreCase(criterio)) {

                    //Si algo coincide, imprimo lo que encontre
                    System.out.println("Vehículo encontrado en (" + actual.fila + "," + actual.columna + "):");
                    System.out.println("  Placa: " + v.placa);
                    System.out.println("  Color: " + v.color);
                    System.out.println("  Línea: " + v.linea);
                    System.out.println("  Modelo: " + v.modelo);
                    System.out.println("  Propietario: " + p.nombre + " " + p.apellido);
                    System.out.println("  CUI: " + p.cui);
                    System.out.println("  Fecha Nacimiento: " + p.dob);
                    encontrado = true;
                }

                //Avanzo hacia el siguiente en la fila
                actual = actual.derecha;
            }
        }

        //Si no encontre, le digo al user
        if (!encontrado) {
            System.out.println("No se encontraron coincidencias con el criterio: " + criterio);
        }
    }
    
    //Metodo privado para obtener un nodo en una ubicacion especifica
    private Nodo obtenerNodo(int fila, int columna) {
       //Verifico si la fila existe
        if (!filas.containsKey(fila)) return null;

        //Empiezo desde el primer nodo de la fila hasta encontrar la columna indicada
        Nodo actual = filas.get(fila);
        while (actual != null) {
            //si se encuentra, regreso el nodo y sino avanzo a la derecha
            if (actual.columna == columna) return actual;
            actual = actual.derecha;
        }
        //Si no se encuentra, no regresa nadaa
        return null;
    }
    //Metodo que verifica que una placa no este registrada aun
    public boolean existeVehiculo(String placa) {
        //Recorrro todas las filas
        for (Nodo filaActual : filas.values()) {
            Nodo actual = filaActual;
            //Recorro los nodos de cada fila
            while (actual != null) {
                Vehiculo vehiculo = actual.vehiculo;
                //Verifico si la placa del carrito coincide con la que estamos buscando
                if (vehiculo != null && vehiculo.placa.equalsIgnoreCase(placa)) {
                    return true; //Si la encuentro, retorno true
                }
                //Avanzo a la derecha
                actual = actual.derecha;
            }
        }
        //Si no se encuentra, retorno false
        return false;
    }
    
    public void imprimirFila(int fila) {
        //verifico si la fila existe
        if (!filas.containsKey(fila)) {
            System.out.println("La fila " + fila + " no contiene ningún vehículo.");
            return;
        }
        
        
        Nodo actual = filas.get(fila);
        System.out.println("Vehículos en la fila " + fila + ":");

        //Recorro la fila imprimiendo la info de los carritos
        while (actual != null) {
            Vehiculo v = actual.vehiculo;
            Propietario p = v.propietario;

            System.out.println("  Columna: " + actual.columna);
            System.out.println("    Placa: " + v.placa);
            System.out.println("    Color: " + v.color);
            System.out.println("    Línea: " + v.linea);
            System.out.println("    Modelo: " + v.modelo);
            System.out.println("    Propietario: " + p.nombre + " " + p.apellido);
            System.out.println("    CUI: " + p.cui);
            System.out.println("    Fecha Nacimiento: " + p.dob);
            System.out.println("---------------------------------");

            //avanzo a la derecha
            actual = actual.derecha;
        }
    }
    
    public void imprimirColumna(int columna) {
        //verifico que la columna exista
        if (!columnas.containsKey(columna)) {
            System.out.println("La columna " + columna + " no contiene ningún vehículo.");
            return;
        }

        Nodo actual = columnas.get(columna);
        System.out.println("Vehículos en la columna " + columna + ":");

        //recorro la columna e imprimo la info de cada carrito
        while (actual != null) {
            Vehiculo v = actual.vehiculo;
            Propietario p = v.propietario;

            System.out.println("  Fila: " + actual.fila);
            System.out.println("    Placa: " + v.placa);
            System.out.println("    Color: " + v.color);
            System.out.println("    Línea: " + v.linea);
            System.out.println("    Modelo: " + v.modelo);
            System.out.println("    Propietario: " + p.nombre + " " + p.apellido);
            System.out.println("    CUI: " + p.cui);
            System.out.println("    Fecha Nacimiento: " + p.dob);
            System.out.println("---------------------------------");

            //avanzamos hacia abajo
            actual = actual.abajo;
        }
    }
}

