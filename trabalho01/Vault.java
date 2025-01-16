import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Vault {

    private List<Recursos> recursos;
    private List<Sobrevivente> sobreviventes;
    private List<Missao> missoes;
    Scanner Scan = new Scanner(System.in);

    public static final String WHITE = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";

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
            System.err.println(RED + "Sobrevivente não encontrado" + WHITE);
            return;
        }

        if (sobrevivente.getHabilidades().size() == 3) {
            System.err.println(RED + "Sobrevivente ja possui 3 habilidades" + WHITE);
            return;
        }

        else {
            sobrevivente.adicionarHabilidade(habilidade);
            System.err.println(GREEN + "Habilidade adicionada com sucesso" + WHITE);
            return;
        }
    }

    public void removerHabilidade(String ID) {
        Sobrevivente sobrevivente = procurarSobrevivente(ID);
        if (sobrevivente != null) {
            sobrevivente.imprimirHabilidades();
            System.err.println("Digite a habilidade a remover: ");
            Habilidade habilidade;
            while (true) {
                try {
                    habilidade = Habilidade.valueOf(Scan.nextLine());
                } catch (IllegalArgumentException e) {
                    System.err.println(RED + "Digite uma habilidade valida" + WHITE);
                    continue;
                }
                break;
            }
            if (!sobrevivente.getHabilidades().contains(habilidade)) {
                System.err.println(RED + "Habilidade não encontrada no sobrevivente" + WHITE);
                return;
            }
            sobrevivente.getHabilidades().remove(habilidade);
            System.err.println(GREEN + "Habilidade removida com sucesso" + WHITE);
        } else {
            System.err.println(RED + "Sobrevivente nao encontrado" + WHITE);
        }
    }

    public void imprimirNomeSobreviventes() {
        for (Sobrevivente sobrevivente : sobreviventes) {
            System.out.println(YELLOW + sobrevivente.getNome() + WHITE);
        }
    }

    public void adicionarRecurso(Nome nome, int quantidade) {
        for (Recursos recurso : recursos) {
            if (recurso.getNome() == nome) {
                recurso.setQuantidade(recurso.getQuantidade() + quantidade);
                System.err.println(GREEN + "Recursos adicionados com sucesso no vault" + WHITE);
            }
        }

    }

    public void consumirRecurso(Nome nome, int quantidade) {
        for (Recursos recurso : recursos) {
            if (recurso.getNome() == nome && recurso.getQuantidade() >= quantidade) {
                recurso.setQuantidade(recurso.getQuantidade() - quantidade);
                System.err.println(GREEN + "Recursos consumidos com sucesso" + WHITE);
                return;
            }

        }
        System.err.println(RED + "Quantidade insuficiente de recursos" + WHITE);

    }

    public void imprimirRecursos() {
        for (Recursos recurso : recursos) {
            System.out.println(YELLOW + recurso + WHITE);
        }
    }

    public void imprimirMissoes() {
        for (Missao missao : missoes) {
            if (missao.getStatus().equals(Status_Missao.Sucesso)) {
                System.out.println(YELLOW + missao + WHITE);
            }

            else {
                System.out.println(YELLOW + missao.imprimirSemRecursos() + WHITE);

            }
        }
        return;
    }

    public void imprimirNomeMissoes() {
        System.out.println("Missoes: ");
        for (Missao missao : missoes) {
            System.out.println(YELLOW + missao.getNome() + WHITE);
        }
    }

    public void adicionarSobreviventeMissao(String ID, String nomeMissao) {
        Sobrevivente sobrevivente = procurarSobrevivente(ID);
        Missao missao = procurarMissao(nomeMissao);
        if (missao != null && sobrevivente != null && missao.getSobreviventes().size() < 5) {
            missao.adicionarIDSobrevivente(sobrevivente.getID());
            System.err.println(GREEN + "Sobrevivente adicionado com sucesso" + WHITE);
        } else {
            System.err.println(
                    RED + "Sobrevivente ou missao não encontrada ou missao com maximo de sobreviventes" + WHITE);

        }

    }

    public void imprimirSobreviventes() {
        for (Sobrevivente sobrevivente : sobreviventes) {
            System.out.println(YELLOW + sobrevivente + WHITE);
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
                nome_recurso = Nome.valueOf(Scan.nextLine());

            } catch (IllegalArgumentException e) {
                System.err.println(RED + "Digite um recurso válido" + WHITE);
                continue;
            }
            System.out.println("Digite a quantidade do recurso:");

            while (true) {
                try {
                    quantidade = Scan.nextInt();
                    if (quantidade > 0) {
                        break;
                    } else
                        System.out.println(RED + "Digite um valor inteiro positivo ou não nulo" + WHITE);
                    continue;
                } catch (Exception e) {
                    System.err.println(RED + "Digite um valor valido" + WHITE);
                    Scan.nextLine();
                }
            }
            Scan.nextLine();

            missao.adicionarRecurso(nome_recurso, quantidade);
            adicionarRecurso(nome_recurso, quantidade);

            System.out.println("Tem mais algum recurso?(S/N)");
            op = Scan.nextLine();
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
            System.out.println(YELLOW + sobrevivente + WHITE);
        }

    }

    public void imprimirNomeeIDs() {
        for (Sobrevivente sobrevivente : sobreviventes) {
            System.out.println(YELLOW + sobrevivente.imprimirNomeeID() + WHITE);
        }
    }

}
