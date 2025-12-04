package ap5;

import java.util.ArrayList;
import java.util.Scanner;

public class Forca {
    BancoPalavras banco;
    char[] palavra;
    char[] resposta;
    int errosMaximo;
    int errosContabilizados;
    ArrayList<Character> letrasEscolhidas;

    Forca(){
        this.banco = new BancoPalavras();
        this.palavra = banco.sortear().toCharArray();
        this.resposta = "—".repeat(this.palavra.length).toCharArray();
        this.errosMaximo = 6;
        this.errosContabilizados = 0;
        this.letrasEscolhidas = new ArrayList<Character>();
    }

    void exibirErrosContabilizados(){
        System.out.printf("Erros contabilizados: %d.%n", this.errosContabilizados);
    }
    void exibirResposta(){
        System.out.printf("Resposta: ");
        for(char letra: this.resposta){
            System.out.printf("%s ", letra);
        }
        System.out.println(".");
        exibirErrosContabilizados();
    }
    void exibirResultado(){
        System.out.printf("Palavra: %s.%n", this.palavra);
        exibirErrosContabilizados();
        String mensagem;
        if(errosContabilizados >= errosMaximo) mensagem = "Você perdeu."; else mensagem = "Você venceu!";
        System.out.printf("%s%n", mensagem);
    }
    char solicitarLetra(Scanner scanner){
        char letraSelecionada;
        letraSelecionada = scanner.nextLine().replace(" ", "").charAt(0);
        return letraSelecionada;
    }
    boolean validarLetra(char letra){ 
        if(Character.isDigit(letra) || this.letrasEscolhidas.contains(letra)){
            System.err.printf("A letra '%c' já foi escolhida ou é um valor numérico.", letra);
            return false;
        }
        return true;
    }
    void atualizarErros(char letra){
        this.letrasEscolhidas.add(letra);
        this.errosContabilizados++;
    }
    void atualizarResposta(char letra){
        for(int i = 0; i < this.palavra.length; i++){
            if(this.palavra[i] == letra) this.resposta[i] = letra;
        }
        this.letrasEscolhidas.add(letra);
    }
    boolean respostaIsCorreta(char[] palavra, char[] resposta){
        for(int i = 0; i < palavra.length; i++){
            if(palavra[i] != resposta[i]) return false;
        }
        return true;
    }
}
