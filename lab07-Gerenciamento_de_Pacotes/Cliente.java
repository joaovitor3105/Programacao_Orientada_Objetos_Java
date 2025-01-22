public class Cliente {
    private String CPF;
    private String nome;

    Cliente(String CPF, String nome) {
        this.CPF = CPF;
        this.nome = nome;
    }

    public String toString() {
        return "Cliente: " + nome + " CPF: " + CPF;

    }

    public String getCPF() {
        return CPF;
    }
}