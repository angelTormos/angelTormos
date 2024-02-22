import java.util.*;

/**
 * Esta clase realiza la criba de Eratóstenes para generar números primos hasta un número dado.
 */
public class CodigoJavaDoc {

    /**
     * Punto de entrada principal del programa.
     * Solicita al usuario un número y muestra los vectores inicial y de primos hasta ese número.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el número para la criba de Eratóstenes:");
        int maxNumero = scanner.nextInt();

        int[] primos = generarPrimos(maxNumero);

        System.out.println("\nVector inicial hasta :" + maxNumero);
        imprimirVectorNumero(maxNumero);

        System.out.println("\nVector de primos hasta:" + maxNumero);
        imprimirVectorNumero(primos);
    }

    /**
     * Genera un array con números primos hasta el número máximo proporcionado.
     *
     * @param max El número máximo hasta el cual generar números primos.
     * @return Un array que contiene los números primos hasta el número máximo.
     */
    public static int[] generarPrimos(int max) {
        if (max < 2) {
            return new int[0];
        }

        int dim = max + 1;
        boolean[] esPrimo = new boolean[dim];

        iniciarArray(esPrimo);

        hacerCriba(dim, esPrimo);

        int cuenta = contarPrimos(dim, esPrimo);
        int[] primos = llenarArrayPrimos(dim, esPrimo, cuenta);

        return primos;    }

    /**
     * Inicializa un array de tipo booleano.
     *
     * @param array El array a inicializar.
     */
    public static void iniciarArray(boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = true;
        }
        //omitir el 0 y el 1 ya que no son primos
        array[0] = array[1] = false;
    }

    /**
     * Realiza la criba de Eratóstenes para marcar los números no primos en un array booleano.
     *
     * @param dim     Tamaño del array.
     * @param esPrimo Array booleano que indica si un número es primo o no.
     */
    public static void hacerCriba(int dim, boolean[] esPrimo) {
        for (int i = 2; i < Math.sqrt(dim) + 1; i++) {
            if (esPrimo[i]) {
                eliminarMultiplos(i, dim, esPrimo);
            }
        }
    }

    /**
     * Elimina los múltiplos de un número primo en un array booleano.
     *
     * @param primo   El número primo cuyos múltiplos se deben eliminar.
     * @param dim     Tamaño del array.
     * @param esPrimo Array booleano que indica si un número es primo o no.
     */
    public static void eliminarMultiplos(int primo, int dim, boolean[] esPrimo) {
        for (int j = 2 * primo; j < dim; j += primo) {
            esPrimo[j] = false;
        }
    }

    /**
     * Cuenta la cantidad de números primos en un array booleano.
     *
     * @param dim     Tamaño del array.
     * @param esPrimo Array booleano que indica si un número es primo o no.
     * @return La cantidad de números primos en el array.
     */
    public static int contarPrimos(int dim, boolean[] esPrimo) {
        int cuenta = 0;
        for (int i = 0; i < dim; i++) {
            if (esPrimo[i]) {
                cuenta++;
            }
        }
        return cuenta;
    }

    /**
     * Llena un array con los números primos encontrados en un array booleano.
     *
     * @param dim    Tamaño del array booleano.
     * @param esPrimo Array booleano que indica si un número es primo o no.
     * @param cuenta Cantidad de números primos en el array.
     * @return Un array que contiene los números primos.
     */
    public static int[] llenarArrayPrimos(int dim, boolean[] esPrimo, int cuenta) {
        int[] primos = new int[cuenta];

        for (int i = 0, j = 0; i < dim; i++) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }
        return primos;
    }

    /**
     * Imprime los números del 1 hasta el número proporcionado.
     *
     * @param maxNumero El número hasta el cual imprimir.
     */
    public static void imprimirVectorNumero(int maxNumero) {
        for (int i = 0; i < maxNumero; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(i + 1 + "\t");
        }
        System.out.println();
    }

    /**
     * Imprime un array de números, con un máximo de 10 números por línea.
     *
     * @param vector El array de números a imprimir.
     */
    public static void imprimirVectorNumero(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(vector[i] + "\t");
        }
        System.out.println();
    }
}
