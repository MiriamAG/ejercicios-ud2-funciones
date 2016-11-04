package com.jaureguialzo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static double convertirTemperatura(double celsius) {
        return celsius * 1.8 + 32;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Temperatura en ºC: ");
        double t = Double.parseDouble(br.readLine());

        System.out.println("La temperatura en ºF es: " + convertirTemperatura(t));
    }
}
