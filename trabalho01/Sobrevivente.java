
import java.util.ArrayList;
import java.util.List;

public class Sobrevivente extends Pessoa {

    private List<Habilidade> habilidades;
    private Status status;
    public static final String WHITE = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";

    public Sobrevivente(String nome, int idade, Status status) {
        super(nome, idade);
        this.habilidades = new ArrayList<Habilidade>();
        this.status = status;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public Status getStatus() {
        return status;
    }

    public String imprimirNomeeID() {
        return YELLOW + "Nome:" + getNome() + "\tID:" + getID() + WHITE;
    }

    @Override
    public String toString() {
        return super.toString() + YELLOW + "\nHabilidades: " + habilidades + "\nStatus: " + status + WHITE;
    }

    public void imprimirHabilidades() {
        System.out.println("Habilidades: ");
        for (Habilidade habilidade : habilidades) {
            System.out.println(YELLOW + habilidade + WHITE);
        }
    }

    public void imprimirStatus() {
        System.out.println(YELLOW + "Status: " + status + WHITE);
    }

    public void adicionarHabilidade(Habilidade habilidade) {
        habilidades.add(habilidade);
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
