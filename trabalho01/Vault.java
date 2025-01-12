
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Vault {

    private List<Recursos> recursos;
    private List<Sobrevivente> sobreviventes;
    private List<Missao> missoes;

    public Vault() {
        this.recursos = new ArrayList<Recursos>();
        this.recursos.add(new Recursos(Nome.Agua, 0));
        this.recursos.add(new Recursos(Nome.Comida, 0));
        this.recursos.add(new Recursos(Nome.Municao, 0));
        this.recursos.add(new Recursos(Nome.Partes_Mecanicas, 0));
        this.recursos.add(new Recursos(Nome.Remedios, 0));
        this.sobreviventes = new ArrayList<Sobrevivente>();
        this.missoes = new ArrayList<Missao>();
    }

    public List<Recursos> getRecursos() {
        return recursos;
    }

    public List<Sobrevivente> getSobreviventes() {
        return sobreviventes;
    }

    public List<Missao> getMissoes() {
        return missoes;
    }

    public void adicionarSobrevivente(Sobrevivente sobrevivente) {
        sobreviventes.add(sobrevivente);
    }

    public void adicionarMissao(Missao missao) {
        missoes.add(missao);
    }

    public Sobrevivente procurarSobrevivente(String ID) {
        for (Sobrevivente sobrevivente : sobreviventes) {
            if (sobrevivente.getID().equals(ID)) {
                return sobrevivente;
            }
        }
        return null;
    }

    public Missao procurarMissao(String nome) {
        for (Missao missao : missoes) {
            if (missao.getNome().equals(nome)) {
                return missao;
            }
        }
        return null;
    }

    public void adicionarHabilidade(String ID, Habilidade habilidade) {
        Sobrevivente sobrevivente = procurarSobrevivente(ID);

        if (sobrevivente == null) {
            System.err.println("Sobrevivente não encontrado");
            return;
        }

        if (sobrevivente.getHabilidades().size() == 3) {
            System.err.println("Sobrevivente ja possui 3 habilidades");
            return;
        }

        else {
            sobrevivente.adicionarHabilidade(habilidade);
            System.err.println("Habilidade adicionada com sucesso");
            return;
        }
    }

    public void removerHabilidade(String ID) {
        Scanner Scan = new Scanner(System.in);
        Sobrevivente sobrevivente = procurarSobrevivente(ID);
        if (sobrevivente != null) {
            sobrevivente.imprimirHabilidades();
            System.err.println("Digite a habilidade a remover: ");
            Habilidade habilidade;
            while (true) {

                try {
                    habilidade = Habilidade.valueOf(Scan.nextLine());

                } catch (IllegalArgumentException e) {
                    System.err.println("Digite uma habilidade valida");
                    continue;
                }
                break;
            }
            sobrevivente.getHabilidades().remove(habilidade);
            System.err.println("Habilidade removida com sucesso");

        } else {
            System.err.println("Sobrevivente nao encontrado");
        }
        Scan.close();

    }

    public void imprimirNomeSobreviventes() {
        for (Sobrevivente sobrevivente : sobreviventes) {
            System.out.println(sobrevivente.getNome());
        }
    }

    public void adicionarRecurso(Nome nome, int quantidade) {
        for (Recursos recurso : recursos) {
            if (recurso.getNome() == nome) {
                recurso.setQuantidade(recurso.getQuantidade() + quantidade);
                System.err.println("Recursos adicionados com sucesso");
            }
        }

    }

    public void consumirRecurso(Nome nome, int quantidade) {
        for (Recursos recurso : recursos) {
            if (recurso.getNome() == nome && recurso.getQuantidade() >= quantidade) {
                recurso.setQuantidade(recurso.getQuantidade() - quantidade);
                System.err.println("Recursos consumidos com sucesso");
                return;
            } else {
                System.err.println("Quantidade insuficiente de recursos");
            }
        }

    }

    public void imprimirRecursos() {
        for (Recursos recurso : recursos) {
            System.out.println(recurso);
        }
    }

    public void imprimirMissoes() {
        for (Missao missao : missoes) {
            System.out.println(missao);
        }
    }

    public void imprimirNomeMissoes() {
        for (Missao missao : missoes) {
            System.out.println(missao.getNome());
        }
    }

    public void adicionarSobreviventeMissao(String ID, String nomeMissao) {
        Sobrevivente sobrevivente = procurarSobrevivente(ID);
        Missao missao = procurarMissao(nomeMissao);
        if (missao != null && sobrevivente != null && missao.getSobreviventes().size() < 5) {
            missao.adicionarSobrevivente(sobrevivente);
            System.err.println("Sobrevivente adicionado com sucesso");
        } else {
            System.err.println("Sobrevivente ou missao não encontrada ou missao com maximo de sobreviventes");

        }

    }

    public void imprimirSobreviventes() {
        for (Sobrevivente sobrevivente : sobreviventes) {
            System.out.println(sobrevivente);
        }

    }
}
