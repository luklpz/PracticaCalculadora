package com.grupo3.calculadora;

public class subMenuConversiones {
    /**
     * Este metodo es el submenú de Conversiones de Bases. Imprime el menú con las opciones, lee el número introducido y según la operación eleguida llama a los metodos correspondientes
     */
    public static void subMenuConv(){
        System.out.println("**************************\n** CONVERSIONES DE BASE **\n**************************\n1. De decimal a binario\n2. De decimal a hexadecimal\n3. De binario a decimal\n4. De binario a hexadecimal\n5. De hexadecimal a binario\n6. De hexadecimal a decimal\n---------------------------\n0. Volver al menú principal\nElija una opción:");
        int subMenu;
        boolean valido;
        do {
            do {
                subMenu = Escaner.lector.nextInt();
                valido = subMenu >= 0 && subMenu <= 6;
                if (!valido) {
                    System.err.println("ERROR. El número no coincide con ninguna de las opciones, PRUEBE OTRA VEZ");
                }
            } while (!valido);
            switch (subMenu) {
                case 0 -> ;//Volver al menú principal
                case 1 -> Conversiones.convertirDecimalABinario();//Decimal a binario
                case 2 -> ;//Decimal a hexadecimal
                case 3 -> Conversiones.convertirBinarioADecimal();//Binario a decimal
                case 4 -> ;//Binario a hexadecimal
                case 5 -> ;//Hexadecimal a binario
                case 6 -> ;//Hexadecimal a decimal
            }
        }while (subMenu != 0);
    }
}
