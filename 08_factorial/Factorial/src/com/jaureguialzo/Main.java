package com.jaureguialzo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static int factorial(int numeroUsuario) {
        if (numeroUsuario == 0) {
            return 1;
        } else {
            return numeroUsuario * factorial(numeroUsuario - 1);
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Escribe un nº: ");

        int numero = Integer.parseInt(br.readLine());

        System.out.println("el factorial es: " + factorial(numero));


    }
}
