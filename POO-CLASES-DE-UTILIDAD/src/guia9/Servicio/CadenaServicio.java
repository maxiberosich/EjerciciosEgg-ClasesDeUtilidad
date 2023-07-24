/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia9.Servicio;

import guia9.Entidad.Cadena;

/**
 *
 * @author Max
 */
public class CadenaServicio {
    
    /*Método mostrarVocales(), deberá contabilizar la cantidad de vocales que tiene la frase ingresada.*/
    public int mostrarVocales(Cadena cadena){
        int vocales = 0;
        for (int i = 0; i < cadena.getLongitud(); i++) {
            switch (cadena.getFrase().substring(i,i+1).toLowerCase()) {
                case "a":
                    vocales++;
                    break;
                case "e":
                    vocales++;
                    break;
                case "i":
                    vocales++;
                    break;
                case "o":
                    vocales++;
                    break;
                case "u":
                    vocales++;
                    break;
            }
        }
        return vocales;
    }
    
    /*Método invertirFrase(), deberá invertir la frase ingresada y mostrarla por pantalla.
    Por ejemplo: Entrada: "casa blanca", Salida: "acnalb asac".*/
    public String invertirFrase(Cadena cadena){
        String nuevaFrase = "";
        for (int i = cadena.getLongitud() - 1; i >= 0; i--) {
            nuevaFrase = nuevaFrase.concat(cadena.getFrase().substring(i,i+1));
        }
        return nuevaFrase;
    }
    
    /*Método vecesRepetido(String letra), recibirá un carácter ingresado por el usuario y
    contabilizar cuántas veces se repite el carácter en la frase, por ejemplo:*/
    public int vecesRepetido(Cadena cadena, String letra){
        int repetido = 0;
        for (int i = 0; i < cadena.getLongitud(); i=i+letra.length()) {
            if(cadena.getFrase().substring(i, i+letra.length()).equalsIgnoreCase(letra)){
                repetido++;
            }
        }
        return repetido;
    }
}
