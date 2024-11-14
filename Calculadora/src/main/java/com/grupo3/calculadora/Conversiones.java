package main.java.com.grupo3.calculadora;

import com.grupo3.calculadora.Escaner;

public class Conversiones {

    public static double convertirBinarioADecimal() {
        String binario;
        String binarioInvertido;
        boolean validado = false;
        double parteEntera = 0;
        double parteDecimal = 0;

        do {
            System.out.println("Dime el binario a convertir en decimal :");
            binario = Escaner.lector.nextLine();
            validado = esBinario(binario);
            if (validado) {
                return conversionBinarioDecimal(binario);


            } else {
                System.err.println("Numero no binario introducido");
                return 1;
            }
        } while (!validado);


    }

    /**
     * @param str Recibe como parametro un String que es el numero binario que queremos validar.
     * @return Devuelve un booleano segun si el String es binario o no.
     */
    public static boolean esBinario(String str) {
        boolean puntoEncontrado = false;
        for (char c : str.toCharArray()) {
            if (c == '.') {
                if (puntoEncontrado) {
                    return false; // Más de un punto decimal no es válido
                }
                puntoEncontrado = true; //asigno la primera aparicion
            } else if (c != '0' && c != '1') {
                return false; // Si encuentra un carácter que no es '0', '1' o '.', devuelve false
            }
        }
        return true; // Si todos los caracteres son válidos, devuelve true
    }

    /**
     * @param binario recibe el binario
     * @return devuelve un array con 2 strings del binario dividido en 2 si hay punto
     */
    public static String[] dividirBinario(String binario) {
        return binario.split("\\.");
    }

    /**
     *
     * @param binario recibe el binario
     * @return  devuelve el binario en decimal
     */
    public static double conversionBinarioDecimal(String binario) {
        String parteFraccional;
        double decimal = 0;
        double fraccionaria = 0;
        int potencia = 0;

        // Recorremos la cadena de derecha a izquierda para la parte entera
        if (!binario.contains(".")) {
            for (int i = binario.length() - 1; i >= 0; i--) {
                if (binario.charAt(i) == '1') {
                    decimal += (1 << potencia);  // o Math.pow(2, potencia); //preguntar a javi si no se entiende
                }
                potencia++;
            }
        }

        // Verificamos si hay una parte fraccionaria
        if (binario.contains(".")) {
            parteFraccional = dividirBinario(binario)[1]; // Obtener la parte fraccionaria

            for (int i = 0; i < parteFraccional.length(); i++) {
                // Convertir el carácter a número y sumar su valor correspondiente
                fraccionaria += (parteFraccional.charAt(i) - '0') * Math.pow(2, -(i + 1));

            }
        }

        return decimal + fraccionaria;
    }


    public static void main(String[] args) {

        System.out.println(convertirBinarioADecimal());
    }
}
