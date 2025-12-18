package l6q2.repositorio;

import l6q2.entidade.Cliente;
import l6q2.entidade.Conta;
import java.util.ArrayList;

public class RepositorioContasVetor {
    private ArrayList<Conta> contas;

    RepositorioContasVetor() {
        this.contas = new ArrayList<Conta>();
    }

    public boolean adicionar(Conta conta) {
        return this.contas.add(conta);
    }
    public boolean adicionar(Cliente cliente) {
        return this.contas.add(this.consultar(cliente));
    }

    public boolean remover(Conta conta) {
        return this.contas.remove(conta);
    }
    public boolean remover(Cliente cliente) {
        return this.contas.remove(this.consultar(cliente));
    }
    
    public Conta consultar(Cliente cliente) {
        String nome = "";
        for(int i = 0; i < this.contas.size(); i++) {
            nome = this.contas.get(i).getCliente().getNome();
            if(cliente.getNome().equals(nome)) {
                return this.contas.get(i);
            }
        }
        return null;
    }
}
