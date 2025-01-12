
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Bem-vindo ao  Vault ");
        Vault vault = new Vault();
        int op;
        while (true) {
            System.out.println("----------------------------------------------------------------");
            System.out.println("     MENU do Vault");
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
                                System.out.println("Digite um valor valido");
                            }
                        } catch (Exception e) {
                            System.err.println("Digite um valor valido");
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
                            System.err.println("Digite um status valido");
                            continue;
                        }
                        break;
                    }
                    vault.adicionarSobrevivente(new Sobrevivente(nome, idade, status));
                    System.out.println("Sobrevivente adicionado com sucesso");
                    break;
                }

                case 2: {
                    if (vault.getSobreviventes().size() != 0) {
                        System.out.println("Sobreviventes disponiveis: ");
                        vault.imprimirSobreviventes();

                        System.out.println("Digite o ID do sobrevivente que deseja adicionar a habilidade: ");
                        String IDadicionar = scan.nextLine();
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
                                System.err.println("Digite uma habilidade valida");
                            }

                        }
                        vault.adicionarHabilidade(IDadicionar, habilidade);
                    } else {
                        System.err.println("Nao existem sobreviventes cadastrados");
                    }
                    break;
                }

                case 3: {

                    if (vault.getSobreviventes().size() != 0) {
                        System.out.println("Sobreviventes disponiveis: ");
                        vault.imprimirSobreviventes();
                        System.out.println("Digite o ID do sobrevivente para remover a habilidade: ");
                        String IDremoverhabilidade = scan.nextLine();
                        vault.removerHabilidade(IDremoverhabilidade);
                        break;

                    } else {
                        System.err.println("Nao ha sobreviventes cadastrados");
                        break;
                    }
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
                            System.err.println("Digite um recurso valido");
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
                            }
                        } catch (Exception e) {
                            System.err.println("Digite um valor valido");
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
                            System.err.println("Digite um recurso valido");
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
                            System.err.println("Digite um valor valido");
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
                    for (Status status : Status.values()) {
                        System.out.println(status);
                    }
                    Status_Missao status_missao;
                    while (true) {

                        try {
                            status_missao = Status_Missao.valueOf(scan.nextLine());

                        } catch (IllegalArgumentException e) {
                            System.err.println("Digite um status valido");
                            continue;
                        }
                        break;
                    }
                    vault.adicionarMissao(new Missao(nome, objetivo, local, status_missao));
                    break;
                }

                case 7: {
                    if (vault.getMissoes().size() != 0 && vault.getSobreviventes().size() != 0) {
                        vault.imprimirMissoes();
                        System.out.println("Digite o nome da missao para adicionar sobreviventes: ");
                        String nomeMissao = scan.nextLine();
                        vault.imprimirSobreviventes();
                        System.out.println("Digite o ID do sobrevivente a ser adicionado a missao: ");
                        String IDsobrevivente = scan.nextLine();
                        vault.adicionarSobreviventeMissao(IDsobrevivente, nomeMissao);
                    } else {
                        System.err.println("Não há missoes ou sobreviventes cadastrados");
                    }

                }

                case 8: {
                    if (vault.getSobreviventes().size() != 0) {
                        vault.imprimirSobreviventes();
                        break;
                    } else {
                        System.err.println("Nao ha sobreviventes cadastrados");
                        break;
                    }

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
                        System.err.println("Nao ha missoes cadastradas");
                        break;
                    }
                }

                case 11: {
                    if (vault.getMissoes().size() != 0) {
                        vault.imprimirMissoes();
                        System.out.println("Digite o nome da missao para exibir os sobreviventes: ");
                        String nomeMissao = scan.nextLine();
                        Missao missao = vault.procurarMissao(nomeMissao);
                        if (missao != null) {
                            missao.imprimirSobreviventes();
                        } else {
                            System.err.println("Missao não encontrada");
                        }

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
                    System.out.println("Digite uma opcao valida");
                    break;
                }
            }
        }
    }
}
