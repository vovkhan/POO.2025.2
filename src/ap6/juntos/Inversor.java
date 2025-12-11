package ap6.juntos;

import java.util.Scanner;

public class Inversor {
    String valorOriginal;
    String valorInvertido;

    // String inverter(String valorOriginal){
    //     char[] entradaVetor = valorOriginal.toCharArray();
    //     char[] entradaInvertida = new char[entradaVetor.length];
    //     int i, j;
    //     for(i = entradaVetor.length-1, j = 0; i >= 0; i--, j++){
    //         entradaInvertida[j] = entradaVetor[i];
    //     }
    //     return String.copyValueOf(entradaInvertida);
    // }

    Inversor(String valorEntrada){
        this.valorOriginal = valorEntrada;
    }
    void inverter(String valorEntrada){
        char[] entradaVetor = valorEntrada.toCharArray();
        char[] entradaInvertida = new char[entradaVetor.length];
        int i, j;
        for(i = entradaVetor.length-1, j = 0; i >= 0; i--, j++){
            entradaInvertida[j] = entradaVetor[i];
        }
        this.valorInvertido = String.copyValueOf(entradaInvertida);
    }

    void exibirResultado(){
        System.out.printf("Entrada: %s.%n", this.valorOriginal);
        System.out.printf("Saída: %s.%n", this.valorInvertido);
    }
    
}
