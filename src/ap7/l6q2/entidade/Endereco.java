package l6q2.entidade;

public class Endereco {
    private String estado;
    private String cidade;
    private String rua;
    private String numero;
    private String cep;

    Endereco(String estado, String cidade, String rua, String numero, String cep) {
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.rua = numero;
        this.cep = cep;
    }

    public String getEstado() {
        return this.estado;
    }
    public String getCidade() {
        return this.cidade;
    }
    public String getRua() {
        return this.rua;
    }
    public String getNumero() {
        return this.numero;
    }
    public String getCep() {
        return this.cep;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
}
