package ap5;

import java.util.ArrayList;
import java.util.Scanner;

public class Forca {
    BancoPalavras banco;
    char[] palavra;
    char[] resposta;
    Scanner scanner;
    char lastLetraSelecionada;
    int errosMaximo;
    int errosContabilizados;
    ArrayList<Character> letrasEscolhidas;

    Forca(){
        this.banco = new BancoPalavras();
        this.palavra = this.banco.sortear().toCharArray();
        this.resposta = "_".repeat(this.palavra.length).toCharArray();
        this.errosMaximo = 6;
        this.errosContabilizados = 0;
        this.letrasEscolhidas = new ArrayList<Character>();
        this.scanner = new Scanner(System.in);
    }

    void exibirErrosContabilizados(){
        System.out.printf("Erros contabilizados: %d.%n", this.errosContabilizados);
    }
    void exibirResposta(){
        System.out.printf("Resposta: ");
        for(char ch: this.resposta) System.out.printf("%c ", ch);
        System.out.println(".");
    }
    void exibirResultado(){
        System.out.printf("Palavra: ");
        for(char letra: this.palavra){
            System.out.printf("%s ", letra);
        }
        System.out.println(".");
        exibirErrosContabilizados();
    }
    char catchLetra(Scanner scanner){
        char letraSelecionada;
        System.out.printf("Insira um novo dígito: ");
        letraSelecionada = scanner.nextLine().replace(" ", "").charAt(0);
        return letraSelecionada;
    }
    boolean validarLetra(char letra){ 
        if(Character.isDigit(letra) || this.letrasEscolhidas.contains(letra)){
            System.err.printf("O dígito '%c' já foi escolhido ou é inválido.%n", letra);
            return false;
        }
        return true;
    }
    void atualizarResposta(char letra){
        this.letrasEscolhidas.add(letra);
        boolean letraPresente = false;
        for(int i = 0; i < this.palavra.length; i++){
            if(this.palavra[i] == letra){
                this.resposta[i] = letra;
                letraPresente = true;
            }
        }
        if(!letraPresente){
            this.errosContabilizados++;
        }
    }
    boolean respostaIsCorreta(char[] palavra, char[] resposta){
        for(int i = 0; i < palavra.length; i++){
            if(palavra[i] != resposta[i]) return false;
        }
        return true;
    }
    void sortearNovaPalavra(){
        this.palavra = this.banco.sortear().toCharArray();
        this.resposta = "_".repeat(this.palavra.length).toCharArray();
    }
    void printPalavra(char[] palavra){
        for(char ch: palavra) System.out.printf("%c", ch);
    }

    void jogar(boolean sortearNovaPalavra){
        if(sortearNovaPalavra) this.sortearNovaPalavra();

        while(errosContabilizados < 6 && !respostaIsCorreta(this.palavra, this.resposta)){
            this.exibirResposta();
            this.exibirErrosContabilizados();
            this.lastLetraSelecionada = this.catchLetra(this.scanner);
            if(this.validarLetra(this.lastLetraSelecionada)){
                this.atualizarResposta(lastLetraSelecionada);
            }
        }
        if(respostaIsCorreta(this.palavra, this.resposta)){
            this.exibirResposta();
            System.out.println("Você acertou a palavra!");
        } else {
            System.out.print("Você perdeu. A palavra era '");
            this.printPalavra(this.palavra);
            System.out.println("'.");            
        }
    }
}
