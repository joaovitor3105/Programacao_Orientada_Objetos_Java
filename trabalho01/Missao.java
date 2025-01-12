
import java.util.ArrayList;
import java.util.List;

public class Missao {

    private String nome;
    private String objetivo;
    private String local;
    private List<Sobrevivente> sobreviventes;
    private List<Recursos> recursos;
    private Status_Missao status;

    public Missao(String nome, String objetivo, String local, Status_Missao status_missao) {
        this.nome = nome;
        this.objetivo = objetivo;
        this.local = local;
        this.sobreviventes = new ArrayList<Sobrevivente>();
        this.recursos = new ArrayList<Recursos>();
        this.status = status_missao;

    }

    public String getNome() {
        return nome;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public String getLocal() {
        return local;
    }

    public List<Sobrevivente> getSobreviventes() {
        return sobreviventes;
    }

    public List<Recursos> getRecursos() {
        return recursos;
    }

    public Status_Missao getStatus() {
        return status;
    }

    public void setStatus(Status_Missao status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\nNome: " + nome + "\nObjetivo: " + objetivo + "\nLocal: " + local + "\nSobreviventes: " + sobreviventes
                + "\nRecursos: " + recursos + "\nStatus: " + status;
    }

    public void adicionarSobrevivente(Sobrevivente sobrevivente) {
        sobreviventes.add(sobrevivente);
    }

    public void adicionarRecurso(Recursos recurso) {
        recursos.add(recurso);
    }

    public void imprimirSobreviventes() {
        for (Sobrevivente sobrevivente : sobreviventes) {
            System.out.println(sobrevivente);
        }
    }

    public void imprimirRecursos() {
        for (Recursos recurso : recursos) {
            System.out.println(recurso);
        }
    }
}
