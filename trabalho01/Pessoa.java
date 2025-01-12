
import java.util.UUID;

public class Pessoa {

    private String nome;
    private int idade;
    private String ID;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.ID = gerarIDMenor();
    }

    public String gerarIDMenor() {
        ID = UUID.randomUUID().toString();
        return ID.substring(0, 4);
        // reduzindo o tamanho do ID porém em caso de adicionar mais de 100 pessoas
        // recomendado aumentar o tamanho para 8;
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
