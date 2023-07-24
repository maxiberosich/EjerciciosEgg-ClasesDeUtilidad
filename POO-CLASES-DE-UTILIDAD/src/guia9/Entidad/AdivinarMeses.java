/*
Crea una clase en Java donde declares una variable de tipo array de Strings que contenga 
los doce meses del año, en minúsculas. A continuación, declara una variable mesSecreto de 
tipo String, y hazla igual a un elemento del array (por ejemplo, mesSecreto = mes[9]. 
El programa debe pedir al usuario que adivine el mes secreto. Si el usuario acierta mostrar
un mensaje, y si no lo hace, pedir que vuelva a intentar adivinar el mes secreto. 
 */
package guia9.Entidad;

/**
 *
 * @author Max
 */
public class AdivinarMeses {
    private String[] meses;
    private String mesSecreto;

    public AdivinarMeses() {
        this.meses = new String[]{"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
        this.mesSecreto = meses[(int) (Math.random() * 12)];
    }

    public String[] getMeses() {
        return meses;
    }

    public void setMeses(String[] meses) {
        this.meses = meses;
    }

    public String getMesSecreto() {
        return mesSecreto;
    }

    public void setMesSecreto(String mesSecreto) {
        this.mesSecreto = mesSecreto;
    }
    
    
}
