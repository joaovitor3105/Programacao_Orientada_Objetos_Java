
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
                System.err.println("Recursos adicionados com sucesso no vault");
            }
        }

    }

    public void consumirRecurso(Nome nome, int quantidade) {
        for (Recursos recurso : recursos) {
            if (recurso.getNome() == nome && recurso.getQuantidade() >= quantidade) {
                recurso.setQuantidade(recurso.getQuantidade() - quantidade);
                System.err.println("Recursos consumidos com sucesso");
                return;
            }

        }
        System.err.println("Quantidade insuficiente de recursos");

    }

    public void imprimirRecursos() {
        for (Recursos recurso : recursos) {
            System.out.println(recurso);
        }
    }

    public void imprimirMissoes() {
        for (Missao missao : missoes) {
            if (missao.getStatus().equals(Status_Missao.Sucesso)) {
                System.out.println(missao);
            }

            else {
                System.out.println(missao.imprimirSemRecursos());

            }
        }
        return;
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
            missao.adicionarIDSobrevivente(sobrevivente.getID());
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

    public boolean verificarHabilidadeRepetida(String ID, Habilidade habilidade) {
        Sobrevivente sobrevivente = procurarSobrevivente(ID);
        if (sobrevivente != null) {
            for (Habilidade habilidadeSobrevivente : sobrevivente.getHabilidades()) {
                if (habilidadeSobrevivente == habilidade) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verificadordeID(String ID) {
        for (Sobrevivente sobrevivente : sobreviventes) {
            if (sobrevivente.getID().equals(ID)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificadorDeSobreviventeRepetido(String ID, String nomemissao) {
        Missao missao = procurarMissao(nomemissao);
        if (missao != null) {
            for (String IDs : missao.getSobreviventes()) {
                if (IDs.equals(ID)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verificadordemissaopornome(String nome) {
        for (Missao missao : missoes) {
            if (missao.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificadorDeMorto(String ID) {
        procurarSobrevivente(ID);
        if (procurarSobrevivente(ID).getStatus() == Status.Morto) {
            return true;
        } else
            return false;
    }

    public boolean verificadorDeDoente(String ID) {
        procurarSobrevivente(ID);
        if (procurarSobrevivente(ID).getStatus() == Status.Doente) {
            return true;
        } else
            return false;
    }

    public void adicionarRecursoMissao(String nome_missao) {
        Missao missao = procurarMissao(nome_missao);
        Scanner scan = new Scanner(System.in);
        Nome nome_recurso;
        int quantidade;
        String op;

        while (true)

        {
            for (Nome recurso : Nome.values()) {
                System.out.println(recurso);

            }
            System.out.println("Digite o recurso encontrado:");

            try {
                nome_recurso = Nome.valueOf(scan.nextLine());

            } catch (IllegalArgumentException e) {
                System.err.println("Digite um recurso válido");
                continue;
            }
            System.out.println("Digite a quantidade do recurso:");

            while (true) {
                try {
                    quantidade = scan.nextInt();
                    if (quantidade > 0) {
                        break;
                    } else
                        System.out.println("Digite um valor inteiro positivo ou não nulo");
                    continue;
                } catch (Exception e) {
                    System.err.println("Digite um valor valido");
                    scan.nextLine();
                }
            }
            scan.nextLine();

            missao.adicionarRecurso(nome_recurso, quantidade);
            adicionarRecurso(nome_recurso, quantidade);

            System.out.println("Tem mais algum recurso?(S/N)");
            op = scan.nextLine();
            if (op.equals("S")) {
                continue;
            } else {
                break;
            }
        }

        return;

    }

    public void imprimirSobreviventesDaMissao(Missao missao) {
        for (String ID : missao.getSobreviventes()) {
            Sobrevivente sobrevivente = procurarSobrevivente(ID);
            System.out.println(sobrevivente);
        }

    }

}
