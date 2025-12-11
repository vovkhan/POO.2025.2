package ap6;

import java.util.ArrayList;
import java.util.Scanner;

public class MaquinaBebidas {
    double[] moedasValidas;
    Bebida[] bebidas;
    ArrayList<Double> moedasInseridas;
    int bebidaEscolhida;
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

    void inserirMoedas(double[] moedasValidas, ArrayList<Double> moedasArrayList, Scanner scanner){
        while(true){
            double moeda;
            System.out.printf("Insira uma moeda: ");
            moeda = scanner.nextDouble();
            for(double m: moedasValidas){
                if(moeda == m){
                    moedasArrayList.add(moeda);
                }
            }
        }
    }
    double contarMoedas(ArrayList<Double> moedasArrayList){
        double soma = 0;
        for(double m: moedasArrayList) soma += m;
        return soma;
    };
}
