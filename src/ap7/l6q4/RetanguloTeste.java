package l6q4;

public class RetanguloTeste {
    public static void main(String[] args) {
        Retangulo retangulo = new Retangulo();
        retangulo.imprimirMedidas();

        double[] entradas = new double[]{3, 5};
        System.out.printf("Entradas: %.2f e %.2f.%n", entradas[0], entradas[1]);

        retangulo.setAltura(entradas[0]);
        retangulo.setLargura(entradas[1]);
        retangulo.imprimirMedidas();

        entradas[0] = -2; entradas[1] = 26;
        System.out.printf("Entradas: %.2f e %.2f.%n", entradas[0], entradas[1]);
         
        retangulo.setAltura(entradas[0]);
        retangulo.setLargura(entradas[1]);
        retangulo.imprimirMedidas();
    }
}