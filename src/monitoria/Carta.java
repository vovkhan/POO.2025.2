package monitoria;

public class Carta {
    String nome;
    String naipe;

    Carta(String nome, String naipe){
        this.nome = nome;
        this.naipe = naipe;
    }
    
    void imprimir(){
        System.out.printf("%s de %s.%n", this.nome, this.naipe);
    }
}
