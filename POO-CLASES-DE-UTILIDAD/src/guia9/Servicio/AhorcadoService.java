/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia9.Servicio;

import guia9.Entidad.Ahorcado;
import java.util.Scanner;

/**
 *
 * @author Max
 */
public class AhorcadoService {

    /*Metodo crearJuego(): le pide la palabra al usuario y cantidad de jugadas máxima. 
    Con la palabra del usuario, pone la longitud de la palabra, como la longitud del vector. 
    Después ingresa la palabra en el vector, letra por letra, quedando cada letra de la palabra
    en un índice del vector. Y también, guarda la cantidad de jugadas máximas y el valor que 
    ingresó el usuario.*/
    private void crearJuego(Ahorcado a) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese una palabra para adivinar");
        a.setPalabraABuscar(leer.next());
        System.out.println("Oportunidades que tendra el jugador para adivinar la palabra");
        a.setCantidadDeJugadasMaximas(leer.nextInt());
    }

    /*Método longitud(): muestra la longitud de la palabra que se debe encontrar.
    Nota: buscar como se usa el vector.length.*/
    private void longitud(Ahorcado a) {
        System.out.println("La palabra tiene " + a.getPalabraABuscar().length + " letras");
    }

    /*Método buscar(letra):  este método recibe una letra dada por el usuario y busca
    si la letra ingresada es parte de la palabra o no. También informará si la letra estaba o no.*/
    private void buscar(Ahorcado a, String letra) {
        if (encontradas(a, letra)) {
            System.out.println("La letra se encuentra en la palabra");
            System.out.println("Numero de letras (encontradas,faltantes): " + a.getCantidadDeLetrasEncontradas() + "," + (a.getPalabraABuscar().length - a.getCantidadDeLetrasEncontradas()));
        } else {
            System.out.println("No se encuentra la letra en la palabra");
            System.out.println("Numero de letras (encontradas,faltantes): " + a.getCantidadDeLetrasEncontradas() + "," + (a.getPalabraABuscar().length - a.getCantidadDeLetrasEncontradas()));
        }
    }

    /*Método encontradas(letra):  que reciba una letra ingresada por el usuario y muestre cuantas
    letras han sido encontradas y cuántas le faltan. Este método además deberá devolver true si la
    letra estaba y false si la letra no estaba, ya que, cada vez que se busque una letra que no esté,
    se le restará uno a sus oportunidades.*/
    private boolean encontradas(Ahorcado a, String letra) {
        int cont = 0;
        for (int i = 0; i < a.getPalabraABuscar().length; i++) {
            if (a.getPalabraABuscar()[i].equals(letra)) {
                cont++;
                a.setCantidadDeLetrasEncontradas(a.getCantidadDeLetrasEncontradas() + 1);
            }
        }
        if (cont == 0) {
            a.setCantidadDeJugadasMaximas(a.getCantidadDeJugadasMaximas() - 1);
        }
        return cont > 0;
    }

    /*Método intentos(): para mostrar cuántas oportunidades le queda al jugador.*/
    private void intentos(Ahorcado a) {
        System.out.println("Le quedan " + a.getCantidadDeJugadasMaximas() + " oportunidades");
    }

    /*Metodo letraIngresadaPreviamente(letra): Para saber si ya fue ingresada una letra
    perteneciente a la palabra nuevamente, devuelve boolean*/
    private boolean letraIngresadaPreviamente(Ahorcado a, String letra, String[] letrasIngresadas) {
        for (int i = 0; i < letrasIngresadas.length; i++) {
            if (letrasIngresadas[i] != null) {
                if (letrasIngresadas[i].equals(letra)) {
                    System.out.print("Ya fue ingresada anteriormente. ");
                    return true;
                }
            }
        }
        return false;
    }

    /*Metodo mostrarOrdenPalaabra(letra): muestra las letras ingresadas hasta el momento en orden*/
    private void mostrarOrdenPalabra(Ahorcado a, String letra, String[] palabra) {
        for (int i = 0; i < a.getPalabraABuscar().length; i++) {
            if (a.getPalabraABuscar()[i].equals(letra)) {
                palabra[i] = letra;
            }
        }
        for (int i = 0; i < a.getPalabraABuscar().length; i++) {
            if (palabra[i] != null) {
                System.out.print(palabra[i]);
            } else {
                System.out.print("-");
            }
        }
        System.out.println("");
    }

    /*Método juego(): el método juego se encargará de llamar todos los métodos previamente
    mencionados e informará cuando el usuario descubra toda la palabra o se quede sin intentos. 
    Este método se llamará en el main.*/
    public void juego(Ahorcado a, Scanner leer) {
        String letra = "";
        int contadorLetrasIngresadas = 0;
        crearJuego(a);
        String[] letrasIngresadas = new String[a.getPalabraABuscar().length + a.getCantidadDeJugadasMaximas()];
        String[] formarPalabra = new String[a.getPalabraABuscar().length];
        while (a.getCantidadDeJugadasMaximas() != 0) {
            longitud(a);

            do {
                System.out.println("Ingrese una letra");
                letra = leer.next();
            } while (letraIngresadaPreviamente(a, letra, letrasIngresadas));

            if (letrasIngresadas[contadorLetrasIngresadas] == null) {
                letrasIngresadas[contadorLetrasIngresadas] = letra;
                if (contadorLetrasIngresadas <= letrasIngresadas.length) {
                    contadorLetrasIngresadas++;
                }
            }

            buscar(a, letra);
            intentos(a);
            System.out.println("");
            mostrarOrdenPalabra(a, letra, formarPalabra);
            System.out.println("");
            if (a.getCantidadDeLetrasEncontradas() == a.getPalabraABuscar().length) {
                System.out.print("Adivinaste!!! La palabra es: ");
                for (int i = 0; i < a.getPalabraABuscar().length; i++) {
                    System.out.print(a.getPalabraABuscar()[i]);
                }
                System.out.println("");
                break;
            }
        }
        if (a.getCantidadDeJugadasMaximas() == 0) {
            System.out.println("No quedan mas oportunidades crack");
        }

    }
}
