package main.java.com.grupo3.calculadora;

import com.grupo3.calculadora.Escaner;

public class Conversiones {
    // TODO: Implementar la lógica para convertir binario a decimal

    public static String convertirBinarioADecimal() {
        String binario;
        String binarioInvertido;
        boolean validado = false;

        do {
            System.out.println("Dime el binario a convertir en decimal :");
            binario = Escaner.lector.nextLine();
            validado = esBinario(binario);
            if (validado) {  //Convierte la String con el binario en una array con cada caracter.
                StringBuilder binarioInvertidoBuilder = new StringBuilder(binario); //Creo un StringBuilder apartir de mi String Binario para poder invertirla.
                binarioInvertido=binarioInvertidoBuilder.reverse().toString(); // Invierto el StringBuilder y convierto el resultado a String para almacenarlo en binarioInvertido.




            } else {
                System.err.println("Numero no binario introducido");
            }
        } while (!validado);


    }

    /**
     * @param str Recibe como parametro un String que es el numero binario que queremos validar.
     * @return Devuelve un booleano segun si el String es binario o no.
     */
    public static boolean esBinario(String str) {
        for (char c : str.toCharArray()) { //Recorre cada char de la String convertida en Array de caracteres
            if (c != '0' && c != '1') {
                return false; // Si encuentra un carácter que no es '0' o '1', devuelve false
            }
        }
        return true; // Si todos los caracteres son válidos, devuelve true
    }


    public static void main(String[] args) {
        System.out.println("hola");
    }
}
