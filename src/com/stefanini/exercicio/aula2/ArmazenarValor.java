package com.stefanini.exercicio.aula2;

public class ArmazenarValor {
    public static void main(String[] args) {

        Long numLong = 2147483649L;
        byte numByte = 120;
        short numShort = 150;
        String nomString = "Bem vindos Devs!";
        String numHex = "0x2202";
        double numDouble = 99999.987;

        System.out.printf("Long: %d\nByte: %d\nShort: %d\nString: %s\nHexadecimal: %s\nDouble: %.3f",numLong, numByte, numShort, nomString, numHex, numDouble);
    }
}
