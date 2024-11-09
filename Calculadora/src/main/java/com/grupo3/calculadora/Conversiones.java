package main.java.com.grupo3.calculadora;

import com.grupo3.calculadora.Escaner;

public class Conversiones {
    // TODO: Implementar la lógica para convertir binario a decimal

    public static String binarioADecimal() {
        String binario;
        boolean validado = false;

        do {
            System.out.println("Dime el binario a convertir en decimal :");
            binario = Escaner.lector.nextLine();
            validado = esBinario(binario);
            if (validado){



            }else {
                System.out.println("Numero no binario introducido");
            }
        } while (!validado);


    }

    public static boolean esBinario(String str) {
        for (char c : str.toCharArray()) {
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
