package com.stefanini.exercicio.aula3;

import java.text.DecimalFormat;

public class OperadoresLogicos {
    public static void main(String[] args) {
        double d1 = 0.1;
        double d2 = 0.2;

        System.out.println(d1 + d2 == 0.3);
        //A máquina usa pontos flutuantes de base 2(binário) que trás uma falta de precisão,
        // diferente de quando é usado a base 10(decimal) por nós seres humanos

        //Solução = Arredondar com o format
        System.out.println( new DecimalFormat("#,#0.0").format(d1+d2).equals(new DecimalFormat("#,#0.0").format(0.3)));

        int valor = 10;
        int valorDois = 10;

        System.out.println(valorDois++ == ++valor);

        // valor incrementa antes(pre-incremento) de comparar e valorDois apenas depois(pos-incremento) da comparação
        // 11 != 10


        //Diferença entre o operador && e &
        //R: o "&&" só aceita valores verdadeiro ou falso, quando ao "&" faz a comparação a nivel de bits
        //Ex: 10 & 7 = 2 (10 em bit = 1010, 7 em bit 0111) (1 + 0 = 0, 0 + 1 = 0, 1 + 1 = 1, 0 + 1 = 0) = (0010 = 2)

        //Diferença entre o operador || e |
        //R: Mesma lógica da pergunta 3, só muda que se tiver 1 entre os dois bit comparados vai ser 1
        // e para dar 0 os dois bits de


    }
}
