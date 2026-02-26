package heranca;

public class Analista extends Funcionario {
    Analista(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double calcularBonus() {
        return (this.salario * 0.15);
    }
}
