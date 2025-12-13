package ap6;

import java.util.ArrayList;
import java.util.Scanner;

public class MaquinaBebidas {
    double[] moedasValidas;
    Bebida[] bebidas;
    ArrayList<Double> moedasInseridas;
    int bebidaEscolhidaIndice;
    Scanner scanner;

    MaquinaBebidas(){
        this.bebidas = new Bebida[]{
            new Bebida("Café", 2),
            new Bebida("Chocolate", 5),
            new Bebida("Cappuccino", 3)
        };
        this.moedasValidas = new double[]{0.05, 0.10, 0.25, 0.5, 1.0};
        this.moedasInseridas = new ArrayList<Double>();
        this.scanner = new Scanner(System.in);
    }

    void inserirMoedas(){
        while(true){
            double moeda;
            System.out.printf("Insira um valor de moeda ou '0' para continuar: ");
            moeda = scanner.nextDouble();
            if(moeda <= 0) break;
            for(double m: moedasValidas){
                if(moeda == m){
                    moedasInseridas.add(moeda);
                }
            }
        }
    }
    double contarMoedas(){
        double soma = 0;
        for(double m: moedasInseridas) soma += m;
        return soma;
    };
    void escolherBebida(){
        int escolha = 0;
        System.out.println("Bebidas disponíveis: ");
        for(int i = 0; i < bebidas.length; i++){
            System.out.printf("%d. R$%.2f - %s", (i+1), bebidas[i].valor, bebidas[i].nome);
        }
        while(escolha < 1 && escolha > bebidas.length){
            System.out.print("Insira o id da escolha: ");
            escolha = scanner.nextInt();
        }
        this.bebidaEscolhidaIndice = (escolha-1);
    }
    boolean saldoSuficiente(){
        if(this.contarMoedas() < bebidas[bebidaEscolhidaIndice].valor) return false;
        return true;
    }
    void estornarMoedas(){
        for(int i = 0; i < moedasInseridas.size(); i++){
            System.out.printf("Moeda estornada: %.2f.%n", moedasInseridas.get(i));
            moedasInseridas.removeFirst();
        }
    }
    void prepararBebida(){}
}
