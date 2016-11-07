package com.jaureguialzo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * Enumeración para expresar los posibles valores de la escala de temperaturas
     */
    public enum Escala {
        CELSIUS, FAHRENHEIT, KELVIN
    }

    /**
     * Convierte una temperatura de grados celsius a otra escala de temperatura seleccionable
     *
     * @param celsius Temperatura en grados celsius que se quiere convertir
     * @param destino Escala de destino expresado mediante {@link Escala}
     * @return El resultado de la conversión o Double.NaN (Not a Number) si no se puede convertir
     */
    public static double convertirTemperatura(double celsius, Escala destino) {

        switch (destino) {
            case CELSIUS:
                return celsius;
            case FAHRENHEIT:
                return celsius * 1.8 + 32;
            case KELVIN:
                return celsius + 273.15;
            default:
                return Double.NaN;
        }
    }

    /**
     * Programa principal
     *
     * @param args Parámetros de línea de comandos
     */
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int opcion = 0;

        do {

            // Menú
            System.out.print("=== Temperaturas ===\n" +
                    "1. Convertir a Fahrenheit\n" +
                    "2. Convertir a Kelvin\n" +
                    "3. Salir\n" +
                    "Opción: ");

            // Pedir la opción al usuario
            try {
                opcion = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.err.println("Escribe un valor numérico...");
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Pedir la temperatura, solo si hemos elegido una opción válida
            double t = Double.NaN;
            if (opcion == 1 || opcion == 2) {

                // Nos aseguramos de que escribe un valor adecuado
                do {
                    System.out.print("Temperatura en ºC: ");
                    try {
                        t = Double.parseDouble(br.readLine());
                    } catch (NumberFormatException e) {
                        System.err.println("Escribe un valor numérico...");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                while (Double.isNaN(t)); // Cuidado, no se puede usar == al comparar: http://stackoverflow.com/questions/8819738/why-does-double-nan-double-nan-return-false
            }

            // En función de lo seleccionado y el valor introducido, actuar
            switch (opcion) {
                case 1:
                    System.out.println("La temperatura en ºF es: " + convertirTemperatura(t, Escala.FAHRENHEIT));
                    break;
                case 2:
                    System.out.println("La temperatura en ºK es: " + convertirTemperatura(t, Escala.KELVIN));
                    break;
                case 3:
                    System.out.println("Terminando, que tengas un buen día...");
                    break;
                default:
                    System.err.println("Opción incorrecta, vuelve a intentarlo...");
                    break;
            }

        } while (opcion != 3);

    }
}
