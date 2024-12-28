
import java.util.UUID;

public class Pessoa {

    private String nome;
    private int idade;
    private String ID;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.ID = UUID.randomUUID().toString();
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getID() {
        return ID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "\nNome: " + nome + "\nIdade: " + idade + "\nID: " + ID;
    }
}
