package heranca;

public class Teste {
    public static void main(String[] args) {
        Funcionario[] funcionarios = new Funcionario[]{
            new Gerente("Carlos", 3490),
            new Analista("André", 2310),
            new Estagiario("Gustavo", 1240)
        };

        for(Funcionario funcionario : funcionarios) {
            System.out.printf("Funcionário: %s.\nSalário: R$%.2f\nBônus: R$%.2f\n",
            funcionario.getNome(), funcionario.getSalario(), funcionario.calcularBonus());            
        }
    }
}
