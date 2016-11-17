package com.jaureguialzo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static double longitud(double radio) {
        double longitud = 2*Math.PI*radio;
        return longitud;
    }

    public static double area(double radio) {
        return Math.PI*Math.pow(radio,2);
    }

    public static double volumen(double radio) {
        return 4/3*Math.PI*Math.pow(radio,3);
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char opcion = ' ';

        do {
            System.out.print("=== Calculadora ===\n" +
                    "a) Longitud de la circunferencia\n" +
                    "b) Área del círculo\n" +
                    "c) Volumen de la esfera\n" +
                    "d) Salir\n" +
                    "Opción: ");

            try {
                opcion = br.readLine().charAt(0); // TODO: Tratar excepción
            } catch (IOException e) {
                e.printStackTrace();
            }

            double radio = 0;
            if (opcion == 'a' || opcion == 'b' || opcion == 'c') {
                System.out.print("Escribe el radio: ");
                radio = Double.parseDouble(br.readLine()); // TODO: Tratar excepción
            }

            switch (opcion) {
                case 'a':
                    System.out.println("La longitud es: "+longitud(radio));
                    break;
                case 'b':
                    System.out.println("El área es: "+area(radio));
                    break;
                case 'c':
                    System.out.println("El volumen es: "+volumen(radio));
                    break;
            }

        } while (opcion != 'd');


    }
}
