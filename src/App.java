import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        float h, n, x0, xn;

        // Solicitar datos al usuario
        System.out.println("Ingrese su H:");
        h = sc.nextFloat();

        System.out.println("Ingrese su intervalo");
        System.out.print("x0: ");
        x0 = sc.nextFloat();
        System.out.print("xN: ");
        xn = sc.nextFloat();

        // Calcular el número de puntos en el intervalo
        n = (xn - x0) / h + 1;

        // Crear la matriz
        float[][] matriz = new float[2][(int) n];

        // Llenar la primera fila con los valores de x
        for (int i = 0; i < n; i++) {
            matriz[0][i] = x0 + i * h;
        }

        // Solicitar los valores de f(x) al usuario para cada x en la tabla
        System.out.println("Ingrese los valores de f(x) para cada x:");

        for (int i = 0; i < n; i++) {
            System.out.print("f(" + matriz[0][i] + "): ");
            matriz[1][i] = sc.nextFloat();
        }

        // Imprimir la tabla de datos
        System.out.println("\nTabla de datos:");
        System.out.println("x\tf(x)");
        for (int i = 0; i < n; i++) {
            System.out.println(matriz[0][i] + "\t" + matriz[1][i]);
        }

        sc.close();
    }
}
