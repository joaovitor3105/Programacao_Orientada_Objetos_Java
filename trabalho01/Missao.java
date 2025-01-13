
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Missao {

    private String nome;
    private String objetivo;
    private String local;
    private List<Sobrevivente> sobreviventes;
    private List<Recursos> recursos;
    private Status_Missao status_missao;

    public Missao(String nome, String objetivo, String local, Status_Missao status_missao) {
        this.nome = nome;
        this.objetivo = objetivo;
        this.local = local;
        this.sobreviventes = new ArrayList<Sobrevivente>();
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

    public List<Sobrevivente> getSobreviventes() {
        return sobreviventes;
    }

    public List<Recursos> getRecursos() {
        return recursos;
    }

    public Status_Missao getStatus() {
        return status_missao;
    }

    @Override
    public String toString() {
        return "\nNome: " + nome + "\nObjetivo: " + objetivo + "\nLocal: " + local + "\nSobreviventes: " + sobreviventes
                + "\nRecursos: " + recursos + "\nStatus: " + status_missao;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setSobreviventes(List<Sobrevivente> sobreviventes) {
        this.sobreviventes = sobreviventes;
    }

    public void setRecursos(List<Recursos> recursos) {
        this.recursos = recursos;
    }

    public void setStatus_missao(Status_Missao status_missao) {
        this.status_missao = status_missao;
    }

    public void adicionarRecurso(Nome nome, int quantidade) {
        for (Recursos recurso : recursos) {
            if (recurso.getNome() == nome) {
                recurso.setQuantidade(recurso.getQuantidade() + quantidade);
                System.err.println("Recursos adicionados com sucesso");
            }
        }

    }

    public String imprimirSemRecursos() {
        return "\nNome: " + nome + "\nObjetivo: " + objetivo + "\nLocal: " + local + "\nSobreviventes: " + sobreviventes
                + "\nStatus: " + status_missao;

    }
}
