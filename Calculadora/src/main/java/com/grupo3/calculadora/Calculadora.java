package com.grupo3.calculadora;

public class Calculadora {
    /**
     * Mét0do para imprimir el menú y solicitar que el usuario seleccione una opción del mismo. Al recibir el número, lo valida, y en caso de no estar en el rango imprime un mensaje de error y lo vuelve a solicitar.
     *
     * @return Devuelve la opción 'int' seleccionada por el usuario.
     */
    private static int menuPrincipal(){
        //String menú
        String mainMenu = "\n\n*****************\n** CALCULADORA **\n*****************\n1. Operaciones aritméticas\n2. Conversiones de base\n--------------------------\n0. Salir del programa\n\nElija una opción:";
        //Solicitamos y validamos las opciones del menu
        return  Util.solicitarInt(mainMenu,0,2,"Has  introducido una entrada \u001b[1;31mno válida\u001b[0m. A continuación vuelva a elejir una opción:\n");
    }

    public static void main(String[] args) {
        //Declaramos variables
        int opcionSeleccionada;
        boolean cerrar=false;

        //Iniciamos la calculadora
        do {
            opcionSeleccionada=menuPrincipal();
            switch (opcionSeleccionada) {
                case 0 -> cerrar=true;
                case 1 -> SubmenuOperaciones.switchOperaciones();
                case 2 -> SubMenuConversiones.subMenuConv();
                default -> System.out.println();
            }
        } while (!cerrar);
        Escaner.dispose();
    }

}