package l6q4;

public class Retangulo {
    private double altura;
    private double largura;

    Retangulo(double altura, double largura) {
        this.setAltura(altura);
        this.setLargura(largura);
    }
    Retangulo() {
        this.altura = 1;
        this.largura = 1;
    }

    public double getAltura() {
        return this.altura;
    }
    public void setAltura(double altura) {
        if(altura >= 0 && altura <= 20) this.altura = altura;
        else this.altura = 1;
    }
    public double getLargura() {
        return this.largura;
    }
    public void setLargura(double largura) {
        if(largura >= 0 && largura <= 20) this.largura = largura;
        else this.largura = 1;
    }

    public double calcularPerimetro() {
        return 2*(this.altura+this.largura);
    }
    public double calcularArea() {
        return this.altura*this.largura;
    }

    public void imprimirMedidas() {
        System.out.println("Medidas do retângulo:");
        System.out.printf("Altura: %.2f, Largura: %.2f.%n", this.altura, this.largura);
        System.out.printf("Área: %.2f, Perímetro: %.2f.%n", this.calcularArea(), this.calcularPerimetro());
    }
}