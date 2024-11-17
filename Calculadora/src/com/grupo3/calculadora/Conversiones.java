package com.grupo3.calculadora;

public class Conversiones {
    /**
     * @return devuelve un double decimal de un numero binario que pedira al usuario
     */
    public static double convertirBinarioADecimal() {
        String binario;
        boolean validado;

        do {
            System.out.println("Dime el binario a convertir en decimal :");
            binario = Escaner.lector.nextLine();
            validado = esBinario(binario);
            if (!validado) {
                System.err.println("El numero no es binario");

            }
        } while (!validado);
        return conversionBinarioDecimal(binario);


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
     * @param binario recibe el binario
     * @return devuelve el binario en decimal
     */
    public static double conversionBinarioDecimal(String binario) {
        String parteFraccional;
        double decimal = 0;
        double fraccionaria = 0;
        int potencia = 0;

        // Recorremos la cadena de derecha a izquierda para la parte entera
        if (!binario.contains(".")) {
            // Si no hay punto decimal, solo calculamos la parte entera
            for (int i = binario.length() - 1; i >= 0; i--) {
                if (binario.charAt(i) == '1') {
                    decimal += Math.pow(2, potencia);  // Usamos Math.pow(2, potencia) para la parte entera
                }
                potencia++;
            }
        } else {
            // Si hay un punto, procesamos la parte entera y la fraccionaria
            String[] partes = dividirBinario(binario);  // Dividimos el binario en parte entera y fraccionaria

            // Parte entera
            String parteEntera = partes[0];
            for (int i = parteEntera.length() - 1; i >= 0; i--) {
                if (parteEntera.charAt(i) == '1') {
                    decimal += Math.pow(2, potencia);  // Usamos Math.pow(2, potencia) para la parte entera
                }
                potencia++;
            }

            // Parte fraccionaria
            parteFraccional = partes[1];
            for (int i = 0; i < parteFraccional.length(); i++) {
                if (parteFraccional.charAt(i) == '1') {
                    fraccionaria += Math.pow(2, -(i + 1));  // Parte fraccionaria usando 2^(-i-1)
                }
            }
        }

        return decimal + fraccionaria;
    }

    //*************************************************************************************************//



}
