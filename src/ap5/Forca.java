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
        this.palavra = this.sortearNovaPalavra;
        this.resposta = "—".repeat(this.palavra.length).toCharArray();
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
    char catchLetra(Scanner scanner){
        char letraSelecionada;
        System.out.printf("Insira um novo valor: ");
        letraSelecionada = scanner.nextLine().replace(" ", "").charAt(0);
        return letraSelecionada;
    }
    boolean validarLetra(char letra){ 
        if(Character.isDigit(letra) || this.letrasEscolhidas.contains(letra)){
            System.err.printf("O valor '%c' já foi escolhido ou é um valor numérico.", letra);
            return false;
        }
        return true;
    }
    void atualizarResposta(char letra){
        this.letrasEscolhidas.add(letra);

        for(int i = 0; i < this.palavra.length; i++){
            if(this.palavra[i] == letra){
                this.resposta[i] = letra;
                return;
            }
        }
        this.errosContabilizados++;
        return;
    }
    boolean respostaIsCorreta(char[] palavra, char[] resposta){
        for(int i = 0; i < palavra.length; i++){
            if(palavra[i] != resposta[i]) return false;
        }
        return true;
    }
    char[] sortearNovaPalavra(){
        return this.banco.sortear().toCharArray();
    }
    void 

    void jogar(boolean sortearNovaPalavra){
        if(sortearNovaPalavra) this.palavra = this.sortearNovaPalavra;

        while(true){
            this.exibirResposta();
            this.lastLetraSelecionada = this.catchLetra(this.scanner);
            if(this.validarLetra(this.lastLetraSelecionada)){
                this.atualizarResposta();
            }
        }
    }
}
