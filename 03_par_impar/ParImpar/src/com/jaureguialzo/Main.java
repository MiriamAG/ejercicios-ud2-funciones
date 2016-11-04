package com.jaureguialzo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static boolean esPar(int n) {
        return n % 2 == 0;
    } // true, false

    public static boolean esImpar(int n) {
        return !esPar(n);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Escribe un valor: ");
        int valor = Integer.parseInt(br.readLine());

        if (esPar(valor)) {
            System.out.println("Es PAR");
        } else {
            System.out.println("Es IMPAR");
        }

        if (esImpar(valor)) {
            System.out.println("Es IMPAR");
        } else {
            System.out.println("Es PAR");
        }

    }
}
