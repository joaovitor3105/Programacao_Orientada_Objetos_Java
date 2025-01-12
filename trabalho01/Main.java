
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.err.println("Bem-vindo ao  Vault ");
        Vault vault = new Vault();
        int op;

        while (true) {
            System.err.println("----------------------------------------------------------------");
            System.err.println("     MENU do Vault");
            System.err.println("1-Adicionar Sobrevivente");
            System.err.println("2-Adicionar Habilidade a um sobrevivente");
            System.err.println("3-Remover Habilidade de um sobrevivente");
            System.err.println("4-Adicionar Recurso ao Vault");
            System.err.println("5-Consumir Recurso do Vault");
            System.err.println("6-Registrar Missao");
            System.err.println("7-Adicionar Sobrevivente a Missao");
            System.err.println("8-Exibir Sobreviventes do Vault");
            System.err.println("9-Exibir Recursos do Vault");
            System.err.println("10-Exibir Missoes do Vault");
            System.err.println("11-Exibir Sobreviventes cadastrados em uma Missao");
            System.err.println("12-Sair");
            System.err.println("----------------------------------------------------------------");
            op = scan.nextInt();
            scan.nextLine();
            switch (op) {
                case 1: {
                    System.err.println("Digite o nome do sobrevivente: ");
                    String nome = scan.nextLine();
                    System.err.println("Digite a idade do sobrevivente: ");
                    int idade;
                    while (true) {
                        try {
                            idade = scan.nextInt();
                            if (idade >= 0) {
                                break;
                            } else {
                                System.err.println("Digite um valor valido");
                            }
                        } catch (Exception e) {
                            System.err.println("Digite um valor valido");
                            scan.nextLine();
                        }

                    }
                    scan.nextLine();
                    System.err.println("Digite o status do sobrevivente: ");
                    System.err.println("Status disponiveis: ");
                    for (Status status : Status.values()) {
                        System.err.println(status);
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
                    System.err.println("Sobrevivente adicionado com sucesso");
                    break;
                }

                case 2: {
                    if (vault.getSobreviventes().size() != 0) {
                        System.err.println("Sobreviventes disponiveis: ");
                        vault.imprimirNomeSobreviventes();

                        System.err.println("Digite o nome do sobrevivente que deseja adicionar a habilidade: ");
                        String nome = scan.nextLine();
                        System.err.println("Digite a habilidade a adicionar : ");
                        System.err.println("Habilidades disponiveis: ");
                        for (Habilidade habilidade : Habilidade.values()) {
                            System.err.println(habilidade);
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
                        vault.adicionarHabilidade(nome, habilidade);
                    } else {
                        System.err.println("Nao existem sobreviventes cadastrados");
                    }
                    break;
                }

                case 3: {

                    if (vault.getSobreviventes().size() != 0) {
                        System.err.println("Sobreviventes disponiveis: ");
                        vault.imprimirNomeSobreviventes();
                        System.err.println("Digite o nome do sobrevivente para remover a habilidade: ");
                        String nome = scan.nextLine();
                        vault.removerHabilidade(nome);
                        break;

                    } else {
                        System.err.println("Nao ha sobreviventes cadastrados");
                        break;
                    }
                }

                case 4: {
                    System.err.println("Recursos Disponiveis: ");
                    for (Nome nome : Nome.values()) {
                        System.err.println(nome);
                    }
                    System.err.println("Digite o nome do recurso a ser adicionado: ");
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

                    System.err.println("Digite a quantidade do recurso: ");
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

                    System.err.println("Recursos Disponiveis: ");
                    vault.imprimirRecursos();
                    System.err.println("Digite o nome do recurso a ser consumido: ");
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

                    System.err.println("Digite a quantidade do recurso a ser consumido: ");
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
                    System.err.println("Digite o nome da missao: ");
                    String nome = scan.nextLine();
                    System.err.println("Digite o objetivo da missao: ");
                    String objetivo = scan.nextLine();
                    System.err.println("Digite o local da missao: ");
                    String local = scan.nextLine();
                    vault.adicionarMissao(new Missao(nome, objetivo, local));
                    break;
                }
                case 7: {
                    if (vault.getMissoes().size() != 0 && vault.getSobreviventes().size() != 0) {
                        vault.imprimirMissoes();
                        System.err.println("Digite o nome da missao para adicionar sobreviventes: ");
                        String nomeMissao = scan.nextLine();
                        vault.imprimirNomeSobreviventes();
                        System.err.println("Digite o nome do sobrevivente a ser adicionado a missao: ");
                        String nomeSobrevivente = scan.nextLine();
                        vault.adicionarSobreviventeMissao(nomeSobrevivente, nomeMissao);
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
                        System.err.println("Digite o nome da missao para exibir os sobreviventes: ");
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
                    System.err.println("Desativando o Vault...");
                    System.exit(0);
                    break;

                }

                default: {
                    System.err.println("Digite uma opcao valida");
                    break;
                }
            }
        }
    }
}
