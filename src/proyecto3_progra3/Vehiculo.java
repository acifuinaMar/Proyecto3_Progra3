/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto3_progra3;

/**
 *
 * @author maryori
 */
public class Vehiculo {
    //Atributos del carrito
    String placa;
    String color;
    String linea;
    String modelo;
    //Dueño del carrito y su info almacenada en el obj propietario
    Propietario propietario;
    
    //Constructor
    public Vehiculo(String placa, String color, String linea, String modelo, Propietario propietario){
        this.placa = placa;
        this.color = color;
        this.linea = linea;
        this.modelo = modelo;
        this.propietario = propietario;
    }
}
