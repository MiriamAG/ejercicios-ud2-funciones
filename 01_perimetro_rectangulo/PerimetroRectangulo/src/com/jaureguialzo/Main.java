package com.jaureguialzo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Aquí NO

public class Main {

    // Aquí se puede escribir la función

    public static int perimetroRectangulo(int b, int altura) {
        return 2 * (b + altura);
    }

    public static void main(String[] args) throws IOException {

        // Aquí NO

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Escribe la base: ");
        int base = Integer.parseInt(br.readLine());

        System.out.println("Escribe la altura: ");
        int altura = Integer.parseInt(br.readLine());

        // Llamada a la función
        int perimetro = perimetroRectangulo(base, altura);

        System.out.println("El perímetro es: " + perimetro);
    }

    // Aquí también se puede escribir la función

}

// Aquí NO