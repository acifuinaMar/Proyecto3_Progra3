/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto3_progra3;

/**
 *
 * @author maryori
 */
public class Nodo {
    //Coordenada del nodo en la matriz
    int fila, columna;
    //Carrito guardado en el nodo
    Vehiculo vehiculo;
    //Vecinos del nodo
    Nodo derecha, abajo;
    
    //Constructor
    public Nodo(int fila, int columna, Vehiculo vehiculo){
        this.fila = fila;
        this.columna = columna;
        this.vehiculo = vehiculo;
        //Digo que derecha y abajo son null porque me van a servir de apuntadores
        this.derecha = null;
        this.abajo = null;
    }   
}
