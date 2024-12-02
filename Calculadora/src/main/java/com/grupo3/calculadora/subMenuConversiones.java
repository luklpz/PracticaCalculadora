package com.grupo3.calculadora;

import java.util.Scanner;

public class subMenuConversiones {

    /**
     * Imprime el menú de conversiones y espera a que sea ingresada una opción.
     *
     * @return Devuelve un 'int' como opción seleccionada por el usuario.
     */
    private static int subMenu(){
        Scanner scanner = new Scanner(System.in);
        int opcion;
        //String submenú
        do {
            System.out.println("**************************\n** CONVERSIONES DE BASE **\n**************************\n1. De decimal a binario\n2. De decimal a hexadecimal\n3. De binario a decimal\n4. De binario a hexadecimal\n5. De hexadecimal a binario\n6. De hexadecimal a decimal\n---------------------------\n0. Volver al menú principal\nElija una opción:");
            opcion = Integer.parseInt(scanner.nextLine());
            if (opcion < 0 || opcion >6){
                System.err.println("ERROR. Introduzca una opción válida.");
            }
        }while (opcion < 0 || opcion >6);
        return opcion;
    }

    /**
     * Este metodo es el submenú de Conversiones de Bases. Imprime el menú con las opciones, lee el número introducido y según la operación eleguida llama a los metodos correspondientes
     */
    public static void subMenuConv(){
        int opcionSeleccionada;
        boolean cerrar=false;

        do {
            opcionSeleccionada=subMenu();
            switch (opcionSeleccionada) {
                case 0 -> cerrar = true;//Volver al menú principal
                case 1 -> Conversiones.convertirDecimalABinario();//Decimal a binario
                case 2 -> Conversiones.convertirDecimalAHexadecimal();//Decimal a hexadecimal
                case 3 -> Conversiones.convertirBinarioADecimal();//Binario a decimal
                case 4 -> Conversiones.convertirBinarioAHexadecimal();//Binario a hexadecimal
                case 5 -> Conversiones.convertirHexadecimalABinario();//Hexadecimal a binario
                case 6 -> Conversiones.convertirHexadecimalADecimal();//Hexadecimal a decimal
                default -> System.out.println();
            }
        } while (!cerrar);
    }

}
