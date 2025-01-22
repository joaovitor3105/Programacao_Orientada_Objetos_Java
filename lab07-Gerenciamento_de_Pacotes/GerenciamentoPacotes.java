import java.util.Scanner;

public class GerenciamentoPacotes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaClientes listaClientes = new ListaClientes();
        FilaEntradaPacotes filaEntrada = new FilaEntradaPacotes();
        FilaPrioridadePacotes filaPrioridade = new FilaPrioridadePacotes();
        HistoricoPacotes historico = new HistoricoPacotes();

        System.out.println("Gerenciamento de Pacotes");

        while (true) {
            System.out.println("MENU");
            System.out.println("1 -Adicionar um novo cliente à lista de clientes");
            System.out.println("2 - Registrar um novo Pacote");
            System.out.println("3 - Processar o próximo pacote");
            System.out.println("4 -Exibir os pacotes na fila de entrada");
            System.out.println("5 -Exibir os pacotes na fila de prioridade");
            System.out.println("6 -Exibir o histórico de pacotes entregues");
            System.out.println("7 -Exibir a lista de clientes cadastrados");
            System.out.println("8 -Sair");
            System.out.println("Digite a opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o CPF do cliente: ");
                    String CPF = scanner.nextLine();
                    listaClientes.adicionarCliente(CPF, nome);
                    break;
                case 2:
                    listaClientes.exibirClientes();
                    System.out.println("Digite o CPF do cliente: ");
                    CPF = scanner.nextLine();
                    Cliente cliente = listaClientes.buscarCliente(CPF);
                    if (cliente != null) {
                        System.out.println("Digite o codigo do pacote: ");
                        int codigoPacote = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Digite a descrição do pacote: ");
                        String descricao = scanner.nextLine();
                        System.out.println("Digite a prioridade do pacote(1-Prioritario 2-Sem prioridade): ");

                        int prioridade = scanner.nextInt();
                        if (prioridade == 1 && prioridade == 2) {
                            System.out.println("Prioridade inválida!");
                            break;

                        }

                        Pacote pacote = new Pacote(codigoPacote, descricao, prioridade, CPF);
                        if (pacote.getPrioridade() == 1) {
                            filaPrioridade.adicionarPacote(pacote);
                        } else {
                            filaEntrada.adicionarPacote(pacote);
                        }
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                    break;

                case 3:
                    if (filaPrioridade != null) {
                        Pacote pacote2 = filaPrioridade.removerPacote();
                        historico.adicionarAoHistorico(pacote2);
                    } else {
                        Pacote pacote2 = filaEntrada.removerPacote();
                        historico.adicionarAoHistorico(pacote2);
                    }

                    System.out.println("Pacote entregue com sucesso!");
                    break;

                case 4:
                    filaEntrada.exibirFila();
                    break;

                case 5:
                    filaPrioridade.exibirFila();
                    break;

                case 6:
                    historico.exibirHistorico();
                    break;

                case 7:
                    listaClientes.exibirClientes();
                    break;

                case 8:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    break;
            }

        }
    }

}
