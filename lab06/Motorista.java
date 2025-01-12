public class Motorista {
    private String nome;
    private String cpf;
    private Habilitacao habilitacao;

    public Motorista(String nome, String cpf, Habilitacao habilitacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.habilitacao = habilitacao;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Habilitacao getHabilitacao() {
        return habilitacao;
    }

    public String getDetalhes() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Habilitacao: " + habilitacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setHabilitacao(Habilitacao habilitacao) {
        this.habilitacao = habilitacao;
    }

}
