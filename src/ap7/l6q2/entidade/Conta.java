package l6q2.entidade;

public class Conta {
    private String numero;
    private double saldo;
    private Cliente cliente;

    Conta(String numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
    }
    Conta(String numero, Cliente cliente, double saldo) {
        this.numero = numero;
        this.cliente = cliente;
        if(saldo >= 0) this.saldo = saldo;
        else this.saldo = 0;
    }

    public String getNumero() {
        return this.numero;
    }
    public double getSaldo() {
        return this.saldo;
    }
    public Cliente getCliente() {
        return this.cliente;
    }

    public boolean debitar(double valor) {
        if(this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } else return false;
    }
    public void creditar(double valor) {
        this.saldo += valor;
    }
    public boolean transferir(Conta destino, double valor) {
        boolean foiDebitado = debitar(valor);
        if(foiDebitado) {
            destino.creditar(valor);
            return true;
        } else return false;
    }
}
