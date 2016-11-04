package com.jaureguialzo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    /**
     * Comprueba si un código IBAN es válido
     * Utiliza el algoritmo de verificación: http://iban.es/verificacion.html
     *
     * @param iban Código de cuenta a verificar
     * @return true, si el IBAN es válido
     */
    public static boolean verificarIBAN(String iban) {

        // Pasamos a mayúsculas y eliminamos posibles espacios en blanco: http://stackoverflow.com/questions/5455794/removing-whitespace-from-strings-in-java
        String cuenta = iban.toUpperCase().replaceAll("\\s", "");

        // Aplicamos la tabla de conversión de letras a números aprovechando el código ASCII, donde la A vale 65
        int primeraLetra = ((int) cuenta.charAt(0)) - 55;
        int segundaLetra = ((int) cuenta.charAt(1)) - 55;

        // Extraemos los fragmentos que faltan
        String letrasTresCuatro = cuenta.substring(2, 4); // Tercer y cuarto caracter de la cadena
        String subcadena = cuenta.substring(4); // Nos quedamos con el texto a partir del quinto caracter

        // Componemos un String con el número que hay que dividir entre 97 para verificar
        String t = subcadena + primeraLetra + segundaLetra + letrasTresCuatro;

        /**
         * La cadena que tenemos como resultado del proceso representa un número entero demasiado grande incluso para
         * almacenarlo en un long. Necesitamos recurrir a BigInteger para poder tratarlo.
         *
         * Aquí una explicación más detallada: http://www.arquitecturajava.com/java-biginteger/
         *
         */
        BigInteger numero = new BigInteger(t); // Creamos el BigInteger
        int resto = numero.mod(BigInteger.valueOf(97)).intValue(); // Calculamos el módulo entre 97 y pasamos el resultado a int

        return resto == 1; // Si el resto es 1, el IBAN es válido
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Escriba el IBAN a comprobar (por ejemplo, ES98 2038 5778 9830 0076 0236): ");
        String cuenta = br.readLine();

        if (verificarIBAN(cuenta)) {
            System.out.println("IBAN correcto...");
        } else {
            System.err.println("IBAN incorrecto...");
        }
    }
}
