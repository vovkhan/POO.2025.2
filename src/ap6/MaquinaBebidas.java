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
    double contarMoedas(ArrayList<Double> moedasArrayList){
        double soma = 0;
        for(double m: moedasArrayList) soma += m;
        return soma;
    };
    void escolherBebida(){
        int escolha = 0;
        System.out.println("Bebidas disponíveis: ");
        for(int i = 0; i < bebidas.length; i++){
            System.out.printf("%d. R$%.2f - %s", (i+1), bebidas[i].valor, bebidas[i].nome);
        }
        while(escolha < 1 && escolha > bebidas.length){
            System.out.print("Insira o id da escolha ou '99' para estornar suas moedas: ");
            escolha = scanner.nextInt();
            if(escolha == 99){
                estornarMoedas();
                break;
            }
        }
        this.bebidaEscolhidaIndice = (escolha-1);
    }
    boolean saldoSuficiente(){
        if(this.contarMoedas(moedasInseridas) < bebidas[bebidaEscolhidaIndice].valor) return false;
        return true;
    }
    void estornarMoedas(){
        for(int i = 0; i < moedasInseridas.size(); i++){
            System.out.printf("Moeda estornada: %.2f.%n", moedasInseridas.get(i));
            moedasInseridas.removeFirst();
        }
    }
    void descontarMoedas(double valor){
        ArrayList<Double> moedasDescontadas = moedasInseridas;
        int soma = 0;
        for(int i = 0; i < moedasInseridas.size(); i++){
            if(soma == valor) break;
            for(int j = moedasInseridas.size(); j > 0; j--){
                if(moedasInseridas.get(i) == moedasValidas[j]){
                    if(soma != valor){
                        soma += moedasInseridas.get(i);
                        moedasDescontadas.remove(moedasInseridas.get(i));
                    }
                }
            }
        }
        System.out.printf("Valor inserido: %.2f.%n", contarMoedas(moedasInseridas));
        System.out.printf("Valor após desconto: %.2f.%n", contarMoedas(moedasDescontadas));
    }
    void prepararBebida(){
        if(saldoSuficiente()){
            return;
        }
    }
}
