/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia9;

import guia9.Entidad.AdivinarMeses;
import guia9.Entidad.Ahorcado;
import guia9.Entidad.Cadena;
import guia9.Servicio.AhorcadoService;
import guia9.Servicio.CadenaServicio;
import java.util.Scanner;

/**
 *
 * @author Max
 */
public class Guia9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        //JUEGO DEL AHORCADO - EJERCICIO EXTRA 2
        /*Ahorcado ahorcado = new Ahorcado();
        AhorcadoService a = new AhorcadoService();
        
        a.juego(ahorcado, leer);*/
        //JUEGO DE ADIVINAR UN MES AL AZAR - EJERCICIO EXTRA 1
        /*AdivinarMeses adivinar = new AdivinarMeses();

        System.out.println("Deberas adivinar cual es el mes en el que estoy pensando:");
        while (!adivinar.getMesSecreto().equals(leer.next())) {
            System.out.println("No acertaste, vuelve a intentarlo");
        }
        System.out.println("Correcto!! el mes es " + adivinar.getMesSecreto());*/
        //PRACTICA DE LOS METODOS DEL STRING - EJERCICIO 1
        CadenaServicio cS = new CadenaServicio();
        int opc;
        String letra;

        System.out.println("Ingrese una frase: ");
        Cadena cadena = new Cadena(leer.nextLine());
        do {
            System.out.println("Que es lo que desea hacer"
                    + "\n 1- Invertir la frase"
                    + "\n 2- Conocer la cantidad de vocales que tiene" 
                    + "\n 3- Buscar cuantas veces se repite una letra o frase"
                    + "\n 7- Salir");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("La frase invertida es: " + cS.invertirFrase(cadena));
                    break;
                case 2:
                    System.out.println("La cantidad de vocales que tiene la frase '" + cadena.getFrase()
                            + "' es: " + cS.mostrarVocales(cadena));
                    break;
                case 3:
                    System.out.println("Ingrese la palabra o frase para ver cuantas veces se repite");
                    letra = leer.next();
                    System.out.println("La cantidad de veces que se repite " + letra + " en la frase es: " 
                            + cS.vecesRepetido(cadena, letra));
                    break;
                case 7:
                    System.out.println("Nos vemos la proxima");
                    break;
            }

        } while (opc != 7);

    }

}
