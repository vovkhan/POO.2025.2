package negocio.entidade;

public class Poupanca extends Conta {

    private double juros;

    public Poupanca() {
        super();
        this.juros = 0.2;
    }

    public Poupanca(Cliente cliente, double saldo) {
        super(cliente, saldo);
        this.juros = 0.2;
    }

    public void renderJuros() {
        this.creditar(saldo * juros);
    }
}
