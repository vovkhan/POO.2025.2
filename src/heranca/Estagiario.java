package heranca;

public class Estagiario extends Funcionario {
    Estagiario(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double calcularBonus() {
        return (this.salario * 0.05);
    }
}
