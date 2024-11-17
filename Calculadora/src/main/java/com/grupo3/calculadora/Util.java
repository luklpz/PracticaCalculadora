package main.java.com.grupo3.calculadora;

import com.grupo3.calculadora.Escaner;

public class Util {
    public static int solicitarInt(String mensajeSolicitud,int minimo , int maximo, String mensajeError) {
        int numero;
        do {
            //Solicitamos el entero
            System.out.println(mensajeSolicitud);
            numero = Integer.parseInt(Escaner.lector.nextLine().replaceAll("\\D",""));

            //Validamos el número
            if (numero < minimo || numero > maximo) {
                System.err.printf(mensajeError);
            }
        } while (numero < minimo || numero > maximo);
        return numero;
    }

}