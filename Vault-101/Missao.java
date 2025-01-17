
import java.util.ArrayList;
import java.util.List;

public class Missao {

    private String nome;
    private String objetivo;
    private String local;
    private List<String> sobreviventesID;
    private List<Recursos> recursos;
    private Status_Missao status_missao;
    public static final String WHITE = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";

    public Missao(String nome, String objetivo, String local, Status_Missao status_missao) {
        this.nome = nome;
        this.objetivo = objetivo;
        this.local = local;
        this.sobreviventesID = new ArrayList<String>();
        this.recursos = new ArrayList<Recursos>();
        this.recursos.add(new Recursos(Nome.Agua, 0));
        this.recursos.add(new Recursos(Nome.Comida, 0));
        this.recursos.add(new Recursos(Nome.Municao, 0));
        this.recursos.add(new Recursos(Nome.Partes_Mecanicas, 0));
        this.recursos.add(new Recursos(Nome.Remedios, 0));
        this.status_missao = status_missao;

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

    public List<String> getSobreviventes() {
        return sobreviventesID;
    }

    public List<Recursos> getRecursos() {
        return recursos;
    }

    public Status_Missao getStatus() {
        return status_missao;
    }

    @Override
    public String toString() {
        return YELLOW + "\nNome: " + nome + "\nObjetivo: " + objetivo + "\nLocal: " + local + "\nSobreviventes: "
                + sobreviventesID
                + "\nRecursos: " + recursos + YELLOW + "\nStatus: " + status_missao + WHITE;
    }

    public void adicionarIDSobrevivente(String ID) {
        sobreviventesID.add(ID);
    }

    public void adicionarRecurso(Recursos recurso) {
        recursos.add(recurso);
    }

    public void imprimirRecursos() {
        for (Recursos recurso : recursos) {
            System.out.println(recurso);
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setStatus_missao(Status_Missao status_missao) {
        this.status_missao = status_missao;
    }

    public void adicionarRecurso(Nome nome, int quantidade) {
        for (Recursos recurso : recursos) {
            if (recurso.getNome() == nome) {
                recurso.setQuantidade(recurso.getQuantidade() + quantidade);
                System.err.println(GREEN + "Recursos adicionados com sucesso na missão" + WHITE);
            }
        }

    }

    public String imprimirSemRecursos() {
        return YELLOW + "\nNome: " + nome + "\nObjetivo: " + objetivo + "\nLocal: " + local + "\nSobreviventes: "
                + sobreviventesID
                + "\nStatus: " + status_missao + WHITE;

    }
}
