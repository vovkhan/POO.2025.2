package ap6;

import java.util.ArrayList;
import java.util.Scanner;

public class MaquinaBebidas {
    double[] moedasValidas;
    Bebida[] bebidas;
    ArrayList<Double> moedasInseridas;
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
            System.out.printf("Insira um valor de moeda em centavos ou '0' para continuar: ");
            moeda = scanner.nextDouble();
            if(moeda <= 0) break;
            for(double m: moedasValidas){
                if(moeda/100 == m){
                    moedasInseridas.add(moeda/100);
                }
            }
        }
    }
    double contarMoedas(ArrayList<Double> moedasArrayList){
        double soma = 0;
        if(!moedasArrayList.isEmpty()){
            for(double m: moedasArrayList) soma += m;
        }
        return soma;
    };
    int escolherBebida(){
        int escolha = 0;
        System.out.println("Bebidas disponíveis: ");
        for(int i = 0; i < bebidas.length; i++){
            System.out.printf("%d. R$%.2f - %s.%n", (i+1), bebidas[i].valor, bebidas[i].nome);
        }
        while(!(escolha >= 1 && escolha <= bebidas.length)){
            System.out.print("Insira o id da escolha ou '0' para estornar suas moedas: ");
            escolha = scanner.nextInt();
            if(escolha == 0) return -1;
        }
        return (escolha-1);
    }
    boolean saldoSuficiente(int index){
        if(this.contarMoedas(moedasInseridas) < bebidas[index].valor) return false;
        return true;
    }
    void estornarMoedas(){
        while(!moedasInseridas.isEmpty()){
            System.out.printf("Moeda estornada: %.2f.%n", moedasInseridas.getFirst());
            moedasInseridas.removeFirst();
        }
    }
    ArrayList<Double> descontarMoedas(double valor){
        ArrayList<Double> moedasDescontadas = new ArrayList<Double>(moedasInseridas);
        int soma = 0;
        for(int i = 0; i < moedasInseridas.size(); i++){
            if(soma == valor) break;
            for(int j = moedasValidas.length-1; j > 0; j--){
                if(moedasInseridas.get(i) == moedasValidas[j]){
                    if(soma != valor){
                        soma += moedasInseridas.get(i);
                        moedasDescontadas.remove(moedasInseridas.get(i));
                    }
                }
            }
        }
        return moedasDescontadas;
    }
    void prepararBebida(){
        int escolha = this.escolherBebida();
        if(escolha < 0) return;
        if(saldoSuficiente(escolha)){
            System.out.printf("%s preparado, bom proveito.%n", bebidas[escolha].nome);
            moedasInseridas = this.descontarMoedas(bebidas[escolha].valor);
            System.out.printf("Valor restante: %.2f.%n", contarMoedas(moedasInseridas));
        } else {
            System.out.printf("Valor insuficiente para '%s', insira mais moedas ou escolha outra bebida.%n", bebidas[escolha].nome);
        }
    }
    void iniciar(){
        while (true) {
            int acao = 0;
            System.out.println("Menu de ações:");
            System.out.printf("""
                    1. Inserir moedas.
                    2. Selecionar e preparar bebida.
                    3. Estornar moedas.
                    0. Encerrar interação.
                    Saldo disponível: %.2f
                    """, this.contarMoedas(moedasInseridas));
            System.out.print("Ação: ");
            acao = scanner.nextInt();

            switch (acao) {
                case 1:
                    this.inserirMoedas();    
                    break;
                case 2:
                    this.prepararBebida();
                    break;
                case 3:
                    this.estornarMoedas();
                    break;
                case 0:
                    this.estornarMoedas();
                    return;                
                default:
                    break;
            }
        }
    }
}
