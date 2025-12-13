package monitoria;

import java.util.ArrayList;
import java.util.Random;

public class Baralho {
    static String[] nomes = new String[]{"Ás", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valete", "Dama", "Rei", };
    static String[] naipes = new String[]{"Copas", "Espadas", "Ouros", "Paus"};
    ArrayList<Carta> cartas;
    Random random;

    Baralho(){
        cartas = new ArrayList<Carta>();
        for(int i = 0; i < naipes.length; i++){
            for(int j = 0; j < nomes.length; j++){
                cartas.add(new Carta(nomes[j], naipes[i]));
            }
        }
        for(int k = 0; k < 4; k++){
            cartas.add(new Carta("Coringa", "Coringa"));
        }
        random = new Random();
    }

    void embaralhar(){
        int index = 0;
        int indexLimite = (naipes.length * nomes.length) + 4;
        for(int i = 0; i < naipes.length; i++){
            for(int j = 0; j < nomes.length; j++){
                index = random.nextInt(indexLimite);
                cartas.add(cartas.get(index));
                cartas.remove(index);
            }
        }
    }

    Carta darCarta(){
        if(this.temCarta()){
            Carta cartaRetornada = cartas.getLast();
            cartas.removeLast();
            return cartaRetornada;
        }
        return null;
    }

    boolean temCarta(){
        if(cartas.isEmpty()){
            return false;
        }
        return true;
    }

    void imprimirBaralho(){
        for(Carta c: cartas){
            c.imprimir();
        }
    }
}
