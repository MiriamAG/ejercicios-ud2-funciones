package com.jaureguialzo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static String morse(String cadena) {
        String r = "";

        int longitud = cadena.length();

        for (int i = 0; i < longitud; i++) {


            char letra = cadena.toUpperCase().charAt(i);

            switch (letra) {
                case 'C':
                    int siguiente = i+1;

                    if( siguiente < longitud ) {
                        char letraSiguiente = cadena.toUpperCase().charAt(siguiente);
                        if (letraSiguiente == 'H') {
                            r += "----"; // CH
                            i++;
                        }
                    } else {
                        r += "-.-."; // C
                    }
                    break;
                case 'H':
                    r += "....";
                    break;
                case 'O':
                    r += "---";
                    break;
                case 'L':
                    r += ".-..";
                    break;
                case 'A':
                    r += ".-";
                    break;
            }

            r += " ";
        }

        return r;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String texto;
        do {
            System.out.print("Escribe: ");
            texto = br.readLine();

            if (!texto.equalsIgnoreCase("STOP")) {
                System.out.println(morse(texto));
            }
        } while (!texto.equalsIgnoreCase("STOP"));

    }
}
