package com.jaureguialzo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Introduzca una cantidad en euros: ");
        double euros = Double.parseDouble(br.readLine());

        System.out.print("Moneda a la que convertir (USD, GBP, CNY, JPY): ");
        String moneda = br.readLine();

        System.out.println("--- " + euros + " euros son " + calcularCambio(euros, moneda) + " " + moneda + " ---");
        System.out.println("--- " + euros + " euros son " + calcularCambioV2(euros, moneda) + " " + moneda + " ---");
    }

    public static double calcularCambio(double valor, String moneda) {
        switch (moneda) {
            case "USD":
                return valor * 1.08977;
            //break;    // Unreachable
            case "GBP":
                return valor * 1.08977;
            case "CNY":
                return valor * 1.08977;
            case "JPY":
                return valor * 1.08977;
            default:
                return -1;
        }
    }

    public static double calcularCambioV2(double valor, String moneda) {

        double r = -1;

        switch (moneda) {
            case "USD":
                r = valor * 1.08977;
            case "GBP":
                r = valor * 1.08977;
            case "CNY":
                r = valor * 1.08977;
            case "JPY":
                r = valor * 1.08977;
        }

        return r;
    }
}
