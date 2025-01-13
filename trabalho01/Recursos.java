
public class Recursos {

    private Nome nome;
    private int quantidade;

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
        return "\nNome: " + nome + "\nQuantidade: " + quantidade;
    }

    public void setNome(Nome nome) {
        this.nome = nome;
    }

}
