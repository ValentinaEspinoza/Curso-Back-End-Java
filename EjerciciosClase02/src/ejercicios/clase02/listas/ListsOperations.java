package ejercicios.clase02.listas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class ListsOperations {
	public static void main(String[] args) {
		System.out.println("Ingrese numero entero: ");
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		List<Integer> lista= crearLista(N);
		System.out.println(String.format("Arreglo de tamaño %d: %s", N, lista));
		System.out.println("Lista sin repetidos: "+ numerosUnicosLista(lista));

		System.out.println("Lista invertida: "+ invertirLista(lista));
		
		List<Integer> lista2= crearLista(N);
		System.out.println("Lista 2:" + lista2);
		System.out.println("Interseccion: "+interseccionListas(lista, lista2));
		
		System.out.println(invertirPila("Prueba invertir"));
		String[] seriesValidas = {"()", "(())", "(()())", "(()(()))"}; 
		System.out.println("Series válidas:");
	    	for (String serie : seriesValidas) {
	            System.out.println(serie + ": " + validarParentesis(serie));
	        }

		System.out.println("Lista desordenada: " + desordenar(lista));
	}


	static List<Integer> crearLista(int N){
		Random aleatorio = new Random();
		List<Integer> lista= new ArrayList<>();
		
		for (int i=0; i<N; i++) {
			lista.add(aleatorio.nextInt(10));
		}
		return lista;
	}
	
	//Obtenga los elementos únicos de una lista
	static List<Integer> numerosUnicosLista(List<Integer> lista){
		List<Integer> listaUnicos= new ArrayList<>();
	
		for(int num : lista) {
			if (!listaUnicos.contains(num)) {
				listaUnicos.add(num);
			}
		}
		return listaUnicos;
	}
	
    // Función para invertir los elementos de una lista
    static List<Integer> invertirLista(List<Integer> lista) {
        List<Integer> listaInvertida = new ArrayList<>(lista);
        Collections.reverse(listaInvertida);
        return listaInvertida;
    }
    
    //Obtenga la intersección entre dos listas de números
    static List<Integer> interseccionListas(List<Integer> lista1, List<Integer> lista2){
    	
    	List<Integer> listaInterseccion =new ArrayList<>(lista1);
    	listaInterseccion.retainAll(lista2);
    	return listaInterseccion;
    }
    
    //Invierta una cadena utilizando una pila
    static String invertirPila (String cadena){
    	Stack<Character> stack = new Stack<>();
    	cadena.chars().forEach(c -> stack.push((char)c));
        StringBuilder cadenaInvertida = new StringBuilder();
        
        while (!stack.isEmpty()) {
            cadenaInvertida.append(stack.pop());
        }
    	return cadenaInvertida.toString();
    }
    
    // Valide una serie de paréntesis
    static boolean validarParentesis(String serie) {
        Stack<Character> stack = new Stack<>();

        for (char c : serie.toCharArray()) {
            if (c == '(') {
                stack.push(c); // Agregar a la pila si es un paréntesis de apertura
            } 
            else if (c == ')') {
                // Verificar si hay un paréntesis de apertura correspondiente
                if (stack.isEmpty()) {
                    return false; // No hay apertura para este cierre
                }
                stack.pop(); // Desapilar el paréntesis de apertura
            }
        }
        
        // Si la pila está vacía, todos los paréntesis están balanceados
        return stack.isEmpty();
    }
    
    static List<Integer> desordenar(List<Integer> lista) {
        List<Integer> listaDesordenada = new ArrayList<>(lista);
        Collections.shuffle(listaDesordenada);
        return listaDesordenada;
    }
}
