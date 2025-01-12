
import java.util.ArrayList;
import java.util.List;

public class Sobrevivente extends Pessoa {

    private List<Habilidade> habilidades;
    private Status status;

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

    @Override
    public String toString() {
        return super.toString() + "\nHabilidades: " + habilidades + "\nStatus: " + status;
    }

    public void imprimirHabilidades() {
        System.out.println("Habilidades: ");
        for (Habilidade habilidade : habilidades) {
            System.out.println(habilidade);
        }
    }

    public void imprimirStatus() {
        System.out.println("Status: " + status);
    }

    public void adicionarHabilidade(Habilidade habilidade) {
        habilidades.add(habilidade);
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
