package heranca;

public abstract class Funcionario {
    protected String nome;
    protected double salario;

    protected Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public double calcularBonus() {
        return (this.salario * 0);
    }

    public String getNome() {
        return this.nome;
    }
    public double getSalario() {
        return this.salario;
    }
}
