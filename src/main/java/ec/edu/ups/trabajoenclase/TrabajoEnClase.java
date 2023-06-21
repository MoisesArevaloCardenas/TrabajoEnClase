/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.edu.ups.trabajoenclase;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Administrator
 */
public class TrabajoEnClase {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una secuencia de signos: ");
        String entrada = scanner.nextLine();

        char[] arregloSignos = entrada.toCharArray();
        Stack<Character> nuevoArreglo = new Stack<>();

        for (int i = 0; i < arregloSignos.length; i++) {
            char signo = arregloSignos[i];

            if (signo == '(' || signo == '[' || signo == '{') {
                nuevoArreglo.push(signo);
                mostrarArreglo(nuevoArreglo);
            } else if (signo == ')' || signo == ']' || signo == '}') {
                if (!nuevoArreglo.isEmpty()) {
                    nuevoArreglo.pop();
                    mostrarArreglo(nuevoArreglo);
                } else {
                    System.out.println("Error: Se encontró un signo de cierre sin un signo de apertura correspondiente.");
                    scanner.close();
                    return;
                }
            } else {
                System.out.println("Signo no válido: " + signo);
            }
        }
    }

    private static void mostrarArreglo(Stack<Character> arreglo) {
        System.out.print("Nuevo arreglo: ");
        for (Character signo : arreglo) {
            System.out.print(signo + " ");
        }
        System.out.println();
    }

}
