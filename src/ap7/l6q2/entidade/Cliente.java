package l6q2.entidade;

public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private Endereco endereco;

    Cliente(String nome, String cpf, String telefone, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return this.nome;
    }
    public String getCpf() {
        return this.cpf;
    }
    public String getTelefone() {
        return this.telefone;
    }
    public Endereco getEndereco() {
        return this.endereco;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
