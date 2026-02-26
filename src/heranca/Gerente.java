package heranca;

public class Gerente extends Funcionario {
    Gerente(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double calcularBonus() {
        return (this.salario * 0.2);
    }
}
