package main.java.com.grupo3.calculadora;

public class Operaciones {

    public static double sumaResta(double valorMemoria, boolean suma){
        boolean memoriaUsable;
        double resultado;

        //Validamos si la memoria ha sido inicializada
        if (valorMemoria==Double.MIN_VALUE){
            memoriaUsable=false;
        } else {
            System.out.println("\n\u001B[33m*No introducir nada hará uso del número en la memoria*\u001B[0m");
            memoriaUsable=true;
        }

        //Solicitamos los números
        double numero1 = Util.solicitarDouble("Primer número: ",memoriaUsable,"Has introducido una entrada invalida, prueba de nuevo.");
        if (numero1==Double.MIN_VALUE){
            numero1=valorMemoria;
        }
        double numero2 = Util.solicitarDouble("Segundo número: ",memoriaUsable,"Has introducido una entrada invalida, prueba de nuevo.");
        if (numero2==Double.MIN_VALUE){
            numero2=valorMemoria;
        }

        //Imprimimos y devolvemos el resultado
        if (suma){
            resultado=numero1+numero2;
            System.out.printf("\n%f+%f=%f\n",numero1, numero2, resultado);
        } else {
            resultado=numero1-numero2;
            System.out.printf("\n%f-%f=%f\n",numero1, numero2, resultado);
        }
        return resultado;
    }
}
