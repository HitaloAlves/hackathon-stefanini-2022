package com.stefanini.exercicio.aula4;

import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Informe uma palavra: ");
        String palavra = scn.nextLine();

        StringBuilder palavraInvertida = new StringBuilder();


        for(int i = palavra.length()-1; i>=0;i--){
            palavraInvertida.append(palavra.charAt(i));
        }

        if(palavra.equals(palavraInvertida.toString())){
            System.out.println(palavra+" é um Palindromo");
        }else{
            System.out.println(palavra+" não é um Palidromo");
        }
    }
}
