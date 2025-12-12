package ap6.juntos;

import java.util.Scanner;

public class InversorTeste {
    public static void main(String[] args) {
        Inversor inversor = new Inversor();
        Scanner scanner = new Scanner(System.in);

        // System.out.printf("Input: ");
        // String entrada = scanner.nextLine();
        // String saida = inversor.inverter(entrada);

        // System.out.printf("Entrada: %s.%n", entrada);
        // System.out.printf("Saída: %s.%n", saida);

        inversor.catchValor(scanner);
        inversor.inverter();
        inversor.exibirResultado();
    }
}
