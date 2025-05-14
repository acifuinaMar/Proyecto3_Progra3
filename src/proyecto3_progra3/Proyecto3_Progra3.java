/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto3_progra3;

/**
 *
 * @author maryori
 */

import java.time.Year;
import java.util.*;

public class Proyecto3_Progra3 {
    public static void main(String[] args) {
        Lista lista = new Lista();
        int opcion;
        Scanner entrada = new Scanner(System.in);
        
        //Para mantener el menu hasta que el user lo decida
        do{
            System.out.println("--------MENU--------");
            System.out.println("1. Insertar");
            System.out.println("2. Buscar");
            System.out.println("3. Eliminar");
            System.out.println("4. Imprimir fila");
            System.out.println("5. Imprimir columna");
            System.out.println("6. Salir");
            System.out.print("Opcion:");
            opcion = entrada.nextInt();
            //limpio el buffer
            entrada.nextLine();
            
            switch(opcion){
                case 1:
                    int fila = 0;
                    int columna = 0;
                    System.out.print("Agregar en fila: ");
                    fila = entrada.nextInt();
                    System.out.print("Agregar en columna: ");
                    columna = entrada.nextInt();
                    entrada.nextLine();  // limpiar buffer

                    System.out.print("Placa: ");
                    String placa = entrada.nextLine();
                    System.out.print("Color: ");
                    String color = entrada.nextLine();
                    System.out.print("Línea: ");
                    String linea = entrada.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = entrada.nextLine();

                    System.out.print("CUI del propietario: ");
                    String cui = entrada.nextLine();
                    System.out.print("Nombre del propietario: ");
                    String nombre = entrada.nextLine();
                    System.out.print("Apellido del propietario: ");
                    String apellido = entrada.nextLine();
                    System.out.print("Fecha de nacimiento del propietario (dd/mm/aaaa): ");
                    String dob = entrada.nextLine();
                    
                    if(lista.existeVehiculo(placa)){
                        System.out.println("La placa ingresada ya se encuentra registrada.");
                    } else {
                        if (validarVehiculo(placa, Integer.parseInt(modelo), linea, color) && validaPropietario(nombre, apellido, cui, dob)) {
                           //Creo al propietario y al carrito
                            Propietario p = new Propietario(nombre, apellido, dob, cui);
                            Vehiculo vehiculo = new Vehiculo(placa, color, linea, modelo, p);
                            //inserto el carrito en la matriz
                            lista.insertar(fila, columna, vehiculo);
                            System.out.println("Vehículo insertado correctamente.");
                        }
                    }
                    
                break;
                
                case 2:
                    System.out.print("Ingrese criterio de búsqueda: ");
                    String criterio = entrada.nextLine();
                    lista.buscar(criterio);
                break;
                
                case 3:
                    int filaEliminar = 0;
                    int columnaEliminar = 0;
                    
                    System.out.print("Fila del vehiculo a eliminar:");
                    filaEliminar = entrada.nextInt();
                    System.out.print("Columna del vehiculo a eliminar: ");
                    columnaEliminar = entrada.nextInt();
                    lista.eliminar(filaEliminar, columnaEliminar);
                break;
                
                case 4:
                    System.out.println("Ingrese el número de fila: ");
                    fila = entrada.nextInt();
                    lista.imprimirFila(fila);
                break;
                
                case 5:
                    System.out.println("Ingrese el número de columna: ");
                    columna = entrada.nextInt();
                    lista.imprimirColumna(columna);
                break;
                
                case 6:
                    System.out.println("Saliendo...");
                break;
                
                default:
                    System.out.println("Opcion invalida");
                break;
            }
        } while(opcion != 6);
    }
    //Para validar vehiculo
    public static boolean validarVehiculo(String placa, int modelo, String linea, String color){
        return validarPlaca(placa) && validarModelo(modelo) && validarLineaColor(linea) && validarLineaColor(color);
    }
    //Funcion que valida placa 
    public static boolean validarPlaca(String placa){
        boolean blnValidaPlaca = true;

        if (!placa.toUpperCase().matches("(P|C|M|O|TRC)\\d{3}[B-DF-HJ-NP-TV-Z]{3}")) {
            System.out.println("Error! La placa debe tener el formato correcto (ej. P123BCD).");
            blnValidaPlaca = false;
        }

        return blnValidaPlaca;
    }
    
    //Funcion que valida el modelo del vehiculo
    public static boolean validarModelo(int modelo){
        boolean blnValidaModelo;
        int actualidad = Year.now().getValue();
        blnValidaModelo = modelo >= 1900 && modelo <= actualidad;
        if(!blnValidaModelo){
            System.out.println("Modelo invalido");
        }
        return blnValidaModelo;
    }
    
    //Funcion que validara Marca, Linea y color del vehiculo
    public static boolean validarLineaColor(String cadena2) {
        boolean blnValidaMarcaLineaColor = true;
        // Permite letras, números, espacios y guiones
        blnValidaMarcaLineaColor = cadena2 != null && !cadena2.trim().isEmpty() && cadena2.matches("[a-zA-Z0-9\\- ]+");
        if(!blnValidaMarcaLineaColor){
            System.out.println("Marca, linea o color invalido");
        }
        return blnValidaMarcaLineaColor;
    }
    
    //Funcion que valida al propietario 
    public static boolean validaPropietario(String nombre, String apellido, String cui, String dob){
        return validarNombreApellido(nombre) && validarNombreApellido(apellido) && validarCui(cui) && validarFecha(dob);
    }
    
    //Funcion que valida nombres y apellidos (solo letras)
    public static boolean validarNombreApellido(String nombre) {
        boolean blnValidaCadena;
        // Verifica que no esté vacío y contenga solo letras (con o sin tilde), ñ, y máximo un espacio entre palabras
        blnValidaCadena = !nombre.isEmpty() && nombre.matches("([A-Za-zÁÉÍÓÚáéíóúÑñ]+\\s?){1,2}");

        if (!blnValidaCadena) {
            System.out.println("Nombre o apellido inválido");
        }

        return blnValidaCadena;
    }
    //Funcion que valida el cui
    public static boolean validarCui(String cui){
        int digito, suma = 0;
        String numeros, codigo;
        int numVerificador;
        int[] arreglo = {9, 8, 7, 6, 5, 4, 3, 2};
        boolean encontrado = false;
        boolean blnValidaCui = true;
        int verificadorCalculado;
        String[] arregloCodigos = {
            "0101", "0102", "0103", "0104", "0105", "0106", "0107", "0108", 
            "0109", "0110", "0111", "0112", "0113", "0114", "0115", "0116", 
            "0117", "0201", "0202", "0203", "0204", "0205", "0206", "0207", 
            "0208", "0301", "0302", "0303", "0304", "0305", "0306", "0307", 
            "0308", "0309", "0310", "0311", "0312", "0313", "0314", "0315", 
            "0316", "0401", "0402", "0403", "0404", "0405", "0406", "0407", 
            "0408", "0409", "0410", "0411", "0412", "0413", "0414", "0415", 
            "0416", "0501", "0502", "0503", "0504", "0505", "0506", "0507", 
            "0508", "0509", "0510", "0511", "0512", "0513", "0601", "0602", 
            "0603", "0604", "0605", "0606", "0607", "0608", "0609", "0610", 
            "0611", "0612", "0613", "0614", "0701", "0702", "0703", "0704", 
            "0705", "0706", "0707", "0708", "0709", "0710", "0711", "0712", 
            "0713", "0714", "0715", "0716", "0717", "0718", "0719", "0801", 
            "0802", "0803", "0804", "0805", "0806", "0807", "0808", "0901", 
            "0902", "0903", "0904", "0905", "0906", "0907", "0908", "0909", 
            "0910", "0911", "0912", "0913", "0914", "0915", "0916", "0917", 
            "0918", "0919", "0920", "0921", "0922", "0923", "0924", "1001", 
            "1002", "1003", "1004", "1005", "1006", "1007", "1008", "1009", 
            "1010", "1011", "1012", "1013", "1014", "1015", "1016", "1017", 
            "1018", "1019", "1020", "1101", "1102", "1103", "1104", "1105", 
            "1106", "1107", "1108", "1109", "1201", "1202", "1203", "1204", 
            "1205", "1206", "1207", "1208", "1209", "1210", "1211", "1212", 
            "1213", "1214", "1215", "1216", "1217", "1218", "1219", "1220", 
            "1221", "1222", "1223", "1224", "1225", "1226", "1227", "1228", 
            "1229", "1301", "1302", "1303", "1304", "1305", "1306", "1307", 
            "1308", "1309", "1310", "1311", "1312", "1313", "1314", "1315", 
            "1316", "1317", "1318", "1319", "1320", "1321", "1322", "1323", 
            "1324", "1325", "1326", "1327", "1328", "1329", "1330", "1331", 
            "1332", "1401", "1402", "1403", "1404", "1405", "1406", "1407", 
            "1408", "1409", "1410", "1411", "1412", "1413", "1414", "1415", 
            "1416", "1417", "1418", "1419", "1420", "1421", "1422", "1423", 
            "1424", "1501", "1502", "1503", "1504", "1505", "1506", "1507", 
            "1508", "1509", "1601", "1602", "1603", "1604", "1605", "1606", 
            "1607", "1608", "1609", "1610", "1611", "1612", "1613", "1614", 
            "1615", "1616", "1617", "1618", "1701", "1702", "1703", "1704", 
            "1705", "1706", "1707", "1708", "1709", "1710", "1711", "1712",
            "1801", "1802", "1803", "1804", "1805", "1901", "1902", "1903", 
            "1904", "1905", "1906", "1907", "1908", "1909", "1910", "2001", 
            "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", 
            "2010", "2011", "2101", "2102", "2103", "2104", "2105", "2106", 
            "2107", "2201", "2202", "2203", "2204", "2205", "2206", "2207", 
            "2208", "2209", "2210", "2211", "2212", "2213", "2214", "2215", 
            "2216", "2217"
        };//Cierro el arreglo
        // Si el CUI tiene 13 caracteres, se divide en subcadenas
        if (cui.length() == 13) {
            numeros = cui.substring(0,8);
            numVerificador = Integer.parseInt(cui.substring(8,9));
            codigo = cui.substring(9,13);

            // Calculo del número verificador basado en "numeros"
            for (int i = 0; i < 8; i++){
                digito = Character.getNumericValue(numeros.charAt(i));
                suma += digito * arreglo[i];
            }

            // Aplicar módulo 11
            verificadorCalculado = 11 - (suma % 11);
            if (verificadorCalculado == 11 || verificadorCalculado == 10) {
                verificadorCalculado = 1;
            }

            // Validar el código (ajusta el arregloCodigos como sea necesario)
            for (String arregloCodigo : arregloCodigos) {
                if (arregloCodigo.equals(codigo)) {
                    encontrado = true;
                    break;
                }
            }

            // Validación final del CUI
            blnValidaCui = encontrado && numVerificador == verificadorCalculado;
        } else {
            System.out.println("El CUI debe tener 13 dígitos");
            blnValidaCui = false;
        }
        if(!blnValidaCui){
            System.out.println("Cui invalido.");
        }
        return blnValidaCui;
    }
    //Funcion que valida fecha de nacimiento
    public static boolean validarFecha(String dob){
        boolean blnValidaFecha = true;

        if (dob == null || dob.length() != 10) {
            blnValidaFecha = false;
        } else {
            int dia, mes, year;
            try {
                dia = Integer.parseInt(dob.substring(0, 2));
                mes = Integer.parseInt(dob.substring(3, 5));
                year = Integer.parseInt(dob.substring(6, 10));

                if (dob.charAt(2) != '/' || dob.charAt(5) != '/') {
                    blnValidaFecha = false;
                }

                switch (mes) {
                    case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                        if (dia > 31 || dia < 1) {
                            blnValidaFecha = false;
                        }
                        break;

                    case 4: case 6: case 9: case 11:
                        if (dia > 30 || dia < 1) {
                            blnValidaFecha = false;
                        }
                        break;

                    case 2:
                        // Verificar año bisiesto
                        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                            if (dia > 29 || dia < 1) {
                                blnValidaFecha = false;
                            }
                        } else {
                            if (dia > 28 || dia < 1) {
                                blnValidaFecha = false;
                            }
                        }
                        break;

                    default:
                        blnValidaFecha = false; // Mes no válido
                        break;
                }
            } catch (NumberFormatException e) {
                blnValidaFecha = false;
            }
        }
        
        if(!blnValidaFecha){
            System.out.println("Fecha de nacimiento invalida");
        }
        return blnValidaFecha;
    }
}
