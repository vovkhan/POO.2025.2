package monitoria;

public class BaralhoTeste {
    public static void main(String[] args){
        Baralho baralho = new Baralho();
        int qtdCartas = 5;

        System.out.printf("Baralho organizado (sem mudanças):%n%n");
        baralho.imprimirBaralho();

        baralho.embaralhar();

        System.out.printf("%nBaralho embaralhado:%n%n");
        baralho.imprimirBaralho();

        System.out.printf("%n%d cartas retiradas do topo:%n%n", qtdCartas);
        Carta carta = null;
        for(int i = 0; i < qtdCartas; i++){
            carta = baralho.darCarta();
            if(carta != null) carta.imprimir();
        }
    }
}
