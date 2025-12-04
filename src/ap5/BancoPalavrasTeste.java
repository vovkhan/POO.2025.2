package ap5;

public class BancoPalavrasTeste {
    public static void main(String[] args) {
        BancoPalavras banco = new BancoPalavras();

        String palavraSorteada = banco.sortear();

        System.out.printf("%s%n", palavraSorteada);
    }
}
