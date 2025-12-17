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
        if(this.isValid(saldo)) this.saldo = saldo;
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

    private boolean isValid(double valor) {
        return valor >= 0;
    }

    public void debitar(double valor) {}
    public void creditar(double valor) {}
    public void transferir(Conta destino, double valor) {}
}
