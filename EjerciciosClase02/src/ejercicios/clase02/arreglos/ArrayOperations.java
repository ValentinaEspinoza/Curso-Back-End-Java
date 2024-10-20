package ejercicios.clase02.arreglos;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
public class ArrayOperations {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Ingrese numero entero: ");
			int N = scanner.nextInt();
			int[] arregloEjercicios = aleatorioArrayN(N);
			System.out.println(String.format("Arreglo de tamaño %d: %s", N,Arrays.toString(arregloEjercicios)));
			
			double prom = promedioArray(arregloEjercicios);
			System.out.println("Promedio: "+ prom);
			int max = mayorNumArreglo(arregloEjercicios);
			int min = menorNumArreglo(arregloEjercicios);
			System.out.println("El maximo: " + max);
			System.out.println("El minimo: " + min);

			System.out.println("Rango: "+rangoArray(max, min));
			
			System.out.println("Desviacion estandar: "+ desviacionEstandar(prom,arregloEjercicios));
			
			int[][] diffMatrix = matrizDeDiferencia(arregloEjercicios);
			for (int[] row : diffMatrix) {
			    System.out.println(Arrays.toString(row));
			}
		}
	}
	
	//Cree un arreglo con N enteros aleatorios
	static int[] aleatorioArrayN(int N){
		int[] arrayN = new int[N];
		Random aleatorio = new Random();
		
		for(int i=0 ; i< N; i++ ) {
			int intAleatorio = aleatorio.nextInt(100);
			arrayN[i] = intAleatorio;
		}
		return arrayN;
	}

	// Calcule el promedio de un arreglo de enteros
	static double promedioArray(int[] arrayN) {
		int sumatoria = 0;
		for (int num : arrayN) {
			sumatoria += num;
		}
		return (double) sumatoria/(arrayN.length);
	}
	
	//Obtenga el mayor valor de un arreglo de enteros
	static int mayorNumArreglo(int[] arrayN) {
		int maxVal = arrayN[0];		
		for (int num : arrayN) {
			if(num > maxVal) {
				maxVal = num;
			}
		}
		return maxVal;
	}
	
	//Obtenga el menor valor de un arreglo de enteros
	static int menorNumArreglo(int[] arrayN) {
		int minVal = arrayN[0];		
		for (int num : arrayN) {
			if(num < minVal) {
				minVal = num;
			}	
		}
		return minVal;
	}
	
	//Calcule el rango de un arreglo de enteros
	static int rangoArray(int max, int min){
		return max-min;
	}
	
	//Calcule la desviación estándar de un arreglo de enteros
	static double desviacionEstandar(double prom, int[] arrayN){
		double sum = 0;
		for (int num : arrayN) {
			sum += Math.pow((num - prom),2);
		}
		return Math.sqrt(sum/arrayN.length);
	}
	
	//Obtenga el coeficiente de variación de un arreglo de enteros
	static double coefVariacion(double desv, float prom ,int[] arrayN){
		return desv/(Math.abs(prom));
	}
	
	// Calcule una matriz de que represente la diferencia entre los elementos de un arreglo
	static int[][] matrizDeDiferencia(int[] array){
		int N = array.length;
		int[][] matriz = new int[N][N];
		for (int i = 0; i<N; i++ ) {
			for (int j = 0; j<N; j++ ) {
				matriz[i][j] = array[i] - array[j];
			}	
			
		}
		return matriz;
	}
}
