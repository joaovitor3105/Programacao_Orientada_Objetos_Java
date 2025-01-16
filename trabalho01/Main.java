import java.util.Scanner;

public class Main {
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[96m";
    public static final String BLACK = "\u001B[30m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(WHITE + "Bem-vindo ao Vault-101 ");
        Vault vault = new Vault();
        int op;
        while (true) {
            System.out.println("----------------------------------------------------------------");
            System.out.println("                   MENU do Vault");
            System.out.println("1-Adicionar Sobrevivente");
            System.out.println("2-Adicionar Habilidade a um sobrevivente");
            System.out.println("3-Remover Habilidade de um sobrevivente");
            System.out.println("4-Adicionar Recurso ao Vault");
            System.out.println("5-Consumir Recurso do Vault");
            System.out.println("6-Registrar Missao");
            System.out.println("7-Adicionar Sobrevivente a Missao");
            System.out.println("8-Exibir Sobreviventes do Vault");
            System.out.println("9-Exibir Recursos do Vault");
            System.out.println("10-Exibir Missoes do Vault");
            System.out.println("11-Exibir Sobreviventes cadastrados em uma Missao");
            System.out.println("12-Sair");
            System.out.println("----------------------------------------------------------------");
            System.out.print("Opção:");
            op = scan.nextInt();
            scan.nextLine();
            switch (op) {
                case 1: {
                    System.out.println("Digite o nome do sobrevivente: ");
                    String nome = scan.nextLine();
                    System.out.println("Digite a idade do sobrevivente: ");
                    int idade;
                    while (true) {
                        try {
                            idade = scan.nextInt();
                            if (idade >= 0) {
                                break;
                            } else {
                                System.out.println(RED + "Digite um valor valido" + WHITE);
                            }
                        } catch (Exception e) {
                            System.err.println(RED + "Digite um valor valido" + WHITE);
                            scan.nextLine();
                        }

                    }
                    scan.nextLine();

                    System.out.println("Digite o status do sobrevivente: ");
                    System.out.println("Status disponiveis: ");
                    for (Status status : Status.values()) {
                        System.out.println(status);
                    }
                    Status status;
                    while (true) {

                        try {
                            status = Status.valueOf(scan.nextLine());

                        } catch (IllegalArgumentException e) {
                            System.err.println(RED + "Digite um status valido" + WHITE);
                            continue;
                        }
                        break;
                    }
                    vault.adicionarSobrevivente(new Sobrevivente(nome, idade, status));
                    System.out.println(GREEN + "Sobrevivente adicionado com sucesso" + WHITE);
                    break;
                }

                case 2: {
                    if (vault.getSobreviventes().size() != 0) {
                        System.out.println("Sobreviventes disponiveis: ");
                        vault.imprimirNomeeIDs();

                        System.out.println("Digite o ID do sobrevivente que deseja adicionar a habilidade: ");
                        String IDadicionar = scan.nextLine();
                        if (vault.verificadordeID(IDadicionar) && !vault.verificadorDeMorto(IDadicionar)) {
                            System.out.println("Digite a habilidade a adicionar : ");
                            System.out.println("Habilidades disponiveis: ");
                            for (Habilidade habilidade : Habilidade.values()) {
                                System.out.println(habilidade);
                            }
                            Habilidade habilidade;
                            while (true) {

                                try {
                                    habilidade = Habilidade.valueOf(scan.nextLine());
                                    break;
                                } catch (IllegalArgumentException e) {
                                    System.err.println(RED + "Digite uma habilidade valida" + WHITE);
                                }

                            }
                            if (!vault.verificarHabilidadeRepetida(IDadicionar, habilidade)) {

                                vault.adicionarHabilidade(IDadicionar, habilidade);

                            } else {
                                System.err.println(RED + "Sobrevivente ja possui essa habilidade" + WHITE);
                            }
                        } else
                            System.err.println(RED + "ID inválido ou sobrevivente morto" + WHITE);

                    } else
                        System.err.println(RED + "Não há sobreviventes cadastrados" + WHITE);
                    break;
                }

                case 3: {

                    if (vault.getSobreviventes().size() != 0) {
                        System.out.println("Sobreviventes disponiveis: ");
                        vault.imprimirNomeeIDs();
                        System.out.println("Digite o ID do sobrevivente para remover a habilidade: ");
                        String IDremoverhabilidade = scan.nextLine();
                        if (vault.verificadordeID(IDremoverhabilidade)
                                && !vault.verificadorDeMorto(IDremoverhabilidade)) {
                            Sobrevivente sobrevivente = vault.procurarSobrevivente(IDremoverhabilidade);
                            if (!sobrevivente.getHabilidades().isEmpty()) {
                                vault.removerHabilidade(IDremoverhabilidade);

                                break;
                            } else
                                System.err.println(RED + "Sobrevivente não possui habilidades" + WHITE);
                        } else {
                            System.err.println(RED + "ID invalido ou sobrevivente morto" + WHITE);
                        }

                    } else {
                        System.err.println(RED + "Não há sobreviventes cadastrados" + WHITE);
                    }
                    break;
                }

                case 4: {
                    System.out.println("Recursos Disponiveis: ");
                    for (Nome nome : Nome.values()) {
                        System.err.println(nome);
                    }
                    System.out.println("Digite o nome do recurso a ser adicionado: ");
                    Nome nome_recurso;
                    while (true) {

                        try {
                            nome_recurso = Nome.valueOf(scan.nextLine());

                        } catch (IllegalArgumentException e) {
                            System.err.println(RED + "Digite um recurso valido" + WHITE);
                            continue;
                        }
                        break;
                    }

                    System.out.println("Digite a quantidade do recurso: ");
                    int quantidade;
                    while (true) {
                        try {
                            quantidade = scan.nextInt();
                            if (quantidade > 0) {
                                break;
                            } else
                                System.out.println(RED + "Digite um valor inteiro positivo ou não nulo" + WHITE);
                            continue;
                        } catch (Exception e) {
                            System.err.println(RED + "Digite um valor valido" + WHITE);
                            scan.nextLine();
                        }
                    }
                    scan.nextLine();

                    vault.adicionarRecurso(nome_recurso, quantidade);
                    break;

                }

                case 5: {

                    System.out.println("Recursos Disponiveis: ");
                    vault.imprimirRecursos();
                    System.out.println("Digite o nome do recurso a ser consumido: ");
                    Nome nome_recurso;
                    while (true) {

                        try {
                            nome_recurso = Nome.valueOf(scan.nextLine());

                        } catch (IllegalArgumentException e) {
                            System.err.println(RED + "Digite um recurso valido" + WHITE);
                            continue;
                        }
                        break;
                    }

                    System.out.println("Digite a quantidade do recurso a ser consumido: ");
                    int quantidade;
                    while (true) {
                        try {
                            quantidade = scan.nextInt();
                            if (quantidade > 0) {
                                break;
                            }
                        } catch (Exception e) {
                            System.err.println(RED + "Digite um valor valido" + WHITE);
                            scan.nextLine();
                        }
                    }
                    scan.nextLine();

                    vault.consumirRecurso(nome_recurso, quantidade);

                    break;
                }

                case 6: {
                    System.out.println("Digite o nome da missao: ");
                    String nome = scan.nextLine();
                    System.out.println("Digite o objetivo da missao: ");
                    String objetivo = scan.nextLine();
                    System.out.println("Digite o local da missao: ");
                    String local = scan.nextLine();
                    for (Status_Missao status : Status_Missao.values()) {
                        System.out.println(status);
                    }
                    Status_Missao status_missao;
                    while (true) {

                        try {
                            status_missao = Status_Missao.valueOf(scan.nextLine());

                        } catch (IllegalArgumentException e) {
                            System.err.println(RED + "Digite um status valido" + WHITE);
                            continue;
                        }
                        break;
                    }

                    vault.adicionarMissao(new Missao(nome, objetivo, local, status_missao));
                    System.out.println(GREEN + "Missão registrada com sucesso" + WHITE);

                    if (vault.procurarMissao(nome).getStatus().equals(Status_Missao.Sucesso)) {
                        System.out.println("Esta missão teve recursos obtidos? (S/N)");
                        String x;
                        x = scan.nextLine();
                        if (x.equals("S")) {
                            vault.adicionarRecursoMissao(nome);
                            System.out.println(GREEN + "Recursos adicionados com sucesso" + WHITE);
                        }

                    }
                    break;
                }

                case 7: {
                    if (vault.getMissoes().size() != 0 && vault.getSobreviventes().size() != 0) {
                        vault.imprimirNomeMissoes();
                        System.out.println("Digite o nome da missao para adicionar sobreviventes: ");
                        String nomeMissao = scan.nextLine();
                        if (vault.verificadordemissaopornome(nomeMissao)) {
                            vault.imprimirNomeeIDs();
                            System.out.println("Digite o ID do sobrevivente a ser adicionado a missao: ");
                            String IDsobrevivente = scan.nextLine();
                            if (vault.verificadordeID(IDsobrevivente)
                                    && !vault.verificadorDeSobreviventeRepetido(IDsobrevivente, nomeMissao)) {
                                if (!vault.verificadorDeMorto(IDsobrevivente)
                                        && !vault.verificadorDeDoente(IDsobrevivente)) {
                                    vault.adicionarSobreviventeMissao(IDsobrevivente, nomeMissao);
                                } else {
                                    System.err.println(RED + "Sobrevivente morto ou doente" + WHITE);
                                }

                            } else {
                                System.err.println(RED + "Sobrevivente ja cadastrado na missão ou ID invalido" + WHITE);
                            }
                        } else {
                            System.err.println(RED + "Missao nao encontrada" + WHITE);
                        }
                    } else {
                        System.err.println(RED + "Não há missoes ou sobreviventes cadastrados" + WHITE);
                    }
                    break;

                }

                case 8: {
                    if (vault.getSobreviventes().size() != 0) {
                        vault.imprimirSobreviventes();
                    } else {
                        System.err.println(RED + "Nao ha sobreviventes cadastrados" + WHITE);

                    }
                    break;

                }

                case 9: {
                    vault.imprimirRecursos();
                    break;

                }

                case 10: {
                    if (vault.getMissoes().size() != 0) {
                        vault.imprimirMissoes();
                        break;
                    } else {
                        System.err.println(RED + "Não há missoẽs cadastradas" + WHITE);
                        break;
                    }
                }

                case 11: {
                    if (vault.getMissoes().size() != 0) {
                        vault.imprimirNomeMissoes();
                        System.out.println("Digite o nome da missao para exibir os sobreviventes: ");
                        String nomeMissao = scan.nextLine();
                        Missao missao = vault.procurarMissao(nomeMissao);
                        if (missao != null) {
                            vault.imprimirSobreviventesDaMissao(missao);
                        } else {
                            System.err.println(RED + "Missao não encontrada" + WHITE);
                        }

                    } else {
                        System.err.println(RED + "Não há missoẽs cadastradas" + WHITE);
                    }
                    break;

                }

                case 12: {
                    System.out.println("Desativando o Vault...");
                    scan.close();
                    System.exit(0);
                    break;

                }

                default: {
                    System.out.println(RED + "Digite uma opcao valida" + WHITE);
                    break;
                }
            }
        }
    }
}
