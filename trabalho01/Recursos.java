
public class Recursos {

    private Nome nome;
    private int quantidade;
    public static final String WHITE = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";

    public Recursos(Nome nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public Nome getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return YELLOW + "\nNome: " + nome + "\nQuantidade: " + quantidade + WHITE;
    }

    public void setNome(Nome nome) {
        this.nome = nome;
    }

}
