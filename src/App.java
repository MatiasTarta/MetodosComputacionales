import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        float h, n, x0, xn,res;
        
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

        while(true){
            System.out.println("Elija su metodo de aproximacion de Area");
        System.out.println("PARA METODO DE LOS TRAPECIOS DIGITE 1");
        System.out.println("PARA METODO DE SIMPSON 1/3 DIGITE 2");
        int num =sc.nextInt();
        if(num==1){
            res= trapecio(matriz,n,h);
            System.out.println("El area de la funcion en base a la tabla es de: "+res);
        }else if(num==2){
            res= simpson13(matriz, num, h);
            System.out.println("El area de la funcion en base a la tabla es de: "+res);
        }else{
            System.out.println("!ERROR DIGITO INVALIDO¡");
        }
         
        }
    }

    public static float trapecio(float[][] matriz,float n, float h){
        //este esta correcto
        float suma=0,resultado=0;
          for(int i=1;i<n-1;i++){
            suma= matriz[1][i]+suma;
        }
        resultado= h/2 * (matriz[1][0]+ matriz[1][(int) n-1] + 2*suma);
        return resultado;
        
    }

    public static float simpson13(float[][] matriz,float n, float h){
        //metodo raro, no se si da esto. revisar
        float sumaPar=0,sumaImpar=0,resultado=0;
          for(int i=1;i<n-1;i++){
            if(i%2==0){
                sumaPar= matriz[1][i]+sumaPar;
            }else{
                sumaImpar= matriz[1][i]+sumaImpar;
            }
        }
        resultado= h/3 * (matriz[1][0]+ matriz[1][(int) n-1] + 2*sumaPar+4*sumaImpar);
        return resultado;
        
    }


}
