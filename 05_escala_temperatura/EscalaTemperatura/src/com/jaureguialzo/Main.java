package com.jaureguialzo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * Convierte una temperatura de grados celsius a otra escala de temperatura seleccionable
     *
     * @param celsius Temperatura en grados celsius que se quiere convertir
     * @param escala  Escala de destino 'F' (Fahrenheit) o 'K' (Kelvin)
     * @return El resultado de la conversión o Double.NaN (Not a Number) si no se puede convertir
     */
    public static double convertirTemperatura(double celsius, char escala) {

        switch (escala) {
            case 'F':
                return celsius * 1.8 + 32;
            case 'K':
                return celsius + 273.15;
            default:
                return Double.NaN; // Otra opción sería disparar una excepción
        }
    }

    /**
     * Convierte una temperatura de grados celsius a otra escala de temperatura seleccionable
     *
     * @param celsius Temperatura en grados celsius que se quiere convertir
     * @param escala  Escala de destino 1 (Fahrenheit) o 2 (Kelvin)
     * @return El resultado de la conversión o Double.NaN si no se puede convertir
     */
    public static double convertirTemperaturaV2(double celsius, int escala) {

        switch (escala) {
            case 1:
                return celsius * 1.8 + 32;
            case 2:
                return celsius + 273.15;
            default:
                return Double.NaN;
        }
    }

    /**
     * Programa principal
     *
     * @param args Parámetros de línea de comandos
     * @throws IOException No tratamos este tipo de excepción para no complicar el programa
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int opcion;

        do {

            // Menú
            System.out.print("=== Temperaturas ===\n" +
                    "1. Convertir a Fahrenheit\n" +
                    "2. Convertir a Kelvin\n" +
                    "3. Salir\n" +
                    "Opción: ");

            opcion = Integer.parseInt(br.readLine());

            // Pedir la temperatura, solo si hemos elegido una opción válida
            double t = 0;
            if (opcion == 1 || opcion == 2) {
                System.out.print("Temperatura en ºC: ");
                t = Double.parseDouble(br.readLine());

                // No hacer esto, depende de que las opciones del menú no cambien, no es reutilizable
                System.out.println("La temperatura en ºF es (V2): " + convertirTemperaturaV2(t, opcion));
            }

            // En función de lo seleccionado, actuar
            switch (opcion) {
                case 1:
                    System.out.println("La temperatura en ºF es: " + convertirTemperatura(t, 'F'));
                    break;
                case 2:
                    System.out.println("La temperatura en ºK es: " + convertirTemperatura(t, 'K'));
                    break;
                case 3:
                    System.out.println("Terminando, que tengas un buen día...");
                    break;
                default:
                    System.out.println("Opción incorrecta, vuelve a intentarlo...");
                    break;
            }

        } while (opcion != 3);

    }
}
