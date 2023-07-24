/*
Crear una clase Ahorcado (como el juego), la cual deberá contener como atributos, 
un vector con la palabra a buscar, la cantidad de letras encontradas y la cantidad 
jugadas máximas que puede realizar el usuario. 
 */
package guia9.Entidad;

/**
 *
 * @author Max
 */
public class Ahorcado {
    private String[] palabraABuscar;
    private int cantidadDeLetrasEncontradas;
    private int cantidadDeJugadasMaximas;

    public Ahorcado() {
    }

    public Ahorcado(String[] palabraABuscar, int cantidadDeLetrasEncontradas, int cantidadDeJugadasMaximas) {
        this.palabraABuscar = palabraABuscar;
        this.cantidadDeLetrasEncontradas = cantidadDeLetrasEncontradas;
        this.cantidadDeJugadasMaximas = cantidadDeJugadasMaximas;
    }
    
    public Ahorcado(String[] palabraABuscar, int cantidadDeJugadasMaximas){
        this.palabraABuscar = palabraABuscar;
        this.cantidadDeJugadasMaximas = cantidadDeJugadasMaximas;
        this.cantidadDeLetrasEncontradas = 0;
    }

    public String[] getPalabraABuscar() {
        return palabraABuscar;
    }

    public void setPalabraABuscar(String palabraABuscar) {
        this.palabraABuscar = new String[palabraABuscar.length()];
        for (int i = 0; i < palabraABuscar.length(); i++) {
            this.palabraABuscar[i]=palabraABuscar.substring(i, i+1);
        }
    }

    public int getCantidadDeLetrasEncontradas() {
        return cantidadDeLetrasEncontradas;
    }

    public void setCantidadDeLetrasEncontradas(int cantidadDeLetrasEncontradas) {
        this.cantidadDeLetrasEncontradas = cantidadDeLetrasEncontradas;
    }

    public int getCantidadDeJugadasMaximas() {
        return cantidadDeJugadasMaximas;
    }

    public void setCantidadDeJugadasMaximas(int cantidadDeJugadasMaximas) {
        this.cantidadDeJugadasMaximas = cantidadDeJugadasMaximas;
    }
    
    
}
