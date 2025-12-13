package monitoria;

import java.util.ArrayList;

public class Baralho {
    ArrayList<Carta> cartas;
    static String[] nomes = new String[]{"Ás", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valete", "Dama", "Rei", };
    static String[] naipes = new String[]{"Copas", "Espadas", "Ouros", "Paus"};

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
    }
    
}
