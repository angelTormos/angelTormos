import java.util.*;

public class CodigoRefactorizado {
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

    // Generar números primos del 1 al máximo
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

        return primos;
    }

    //Inicia el array
    public static void iniciarArray(boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = true;
        }
        //omitir el 0 y el 1 ya que no son primos
        array[0] = array[1] = false;
    }

    //Realiza la criba de Eratóstenes
    public static void hacerCriba(int dim, boolean[] esPrimo) {
        for (int i = 2; i < Math.sqrt(dim) + 1; i++) {
            if (esPrimo[i]) {
                eliminarMultiplos(i, dim, esPrimo);
            }
        }
    }

    //Elimina los multiplos de 1
    public static void eliminarMultiplos(int primo, int dim, boolean[] esPrimo) {
        for (int j = 2 * primo; j < dim; j += primo) {
            esPrimo[j] = false;
        }
    }

    //Cuenta los numeros primos que hay
    public static int contarPrimos(int dim, boolean[] esPrimo) {
        int cuenta = 0;
        for (int i = 0; i < dim; i++) {
            if (esPrimo[i]) {
                cuenta++;
            }
        }
        return cuenta;
    }

    //Añade al array los numeros primos
    public static int[] llenarArrayPrimos(int dim, boolean[] esPrimo, int cuenta) {
        int[] primos = new int[cuenta];

        for (int i = 0, j = 0; i < dim; i++) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }
        return primos;
    }

    //Imprime desde el 1 hasta el numero que se le introduzca
    public static void imprimirVectorNumero(int maxNumero) {
        for (int i = 0; i < maxNumero; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(i + 1 + "\t");
        }
        System.out.println();
    }

    //Imprime todos los numeros primos hasta el que se le introduzca
    public static void imprimirVectorNumero(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(vector[i] + "\t");
        }
        System.out.println();
    }
}
