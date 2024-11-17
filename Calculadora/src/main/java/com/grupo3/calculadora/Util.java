package main.java.com.grupo3.calculadora;

import com.grupo3.calculadora.Escaner;

public class Util {

    /**
     * Solicitar y validar un "int" dentro de un rango definido.
     *
     * @param mensajeSolicitud "String" que se imprime para solicitar el número.
     * @param minimo Valor mínimo válido.
     * @param maximo Valor máximo válido.
     * @param mensajeError "String" que se imprime al recibir un valor no válido. Tras este mensaje se repite la validación sin imprimir de nuevo el mensajeSolicitud.
     * @return Devuelve el "int" validado dentro del rango definido.
     */
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