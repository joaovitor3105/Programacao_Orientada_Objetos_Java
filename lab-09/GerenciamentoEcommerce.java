import java.util.Scanner;

public class GerenciamentoEcommerce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaProdutos<Produto> listaProdutos = new ListaProdutos<>();
        FilaPedidos<Pedido> filaPedidos = new FilaPedidos<>();
        HistoricoPedidos<Pedido> historicoPedidos = new HistoricoPedidos<>();
        while (true) {
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Registrar pedido");
            System.out.println("3 - Processar pedido");
            System.out.println("4 - Exibir produtos");
            System.out.println("5 - Exibir pedidos pendentes");
            System.out.println("6 - Exibir histórico de pedidos");
            System.out.println("7 - Sair");
            System.out.print("Digite a opção desejada: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição do produto: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Digite o codigo do produto: ");
                    int codigo = scanner.nextInt();
                    System.out.print("Deseja adicionar um preço ao produto? (1 - Sim, 2 - Não): ");
                    int op = scanner.nextInt();
                    scanner.nextLine();

                    if (op == 1) {
                        System.out.print("Digite o preço do produto: ");
                        double preco = scanner.nextDouble();
                        scanner.nextLine();
                        while (true) {
                            System.out.print("Digite a quantidade em estoque: ");
                            int estoque = scanner.nextInt();
                            scanner.nextLine();
                            if (estoque > 0) {
                                Produto produto = new Produto(codigo, descricao, preco, estoque);
                                listaProdutos.adicionarProduto(produto);
                                break;
                            } else {
                                System.out.println("Quantidade inválida, digite novamente");
                            }
                        }
                    } else {
                        Produto produto = new Produto(codigo, descricao);
                        listaProdutos.adicionarProduto(produto);
                    }

                    break;

                case 2:
                    if (listaProdutos.vazia()) {
                        System.out.println("Não há produtos cadastrados");
                        break;
                    } else {
                        System.out.print("Digite o nome do cliente: ");
                        String nomeCliente = scanner.nextLine();
                        Pedido pedido = new Pedido(filaPedidos.size() + 1, nomeCliente);

                        listaProdutos.mostrarTodos();
                        System.out.print("Digite o numero do produto para adicionar: ");
                        while (true) {

                            int numeroProduto = scanner.nextInt();
                            scanner.nextLine();
                            Produto p = listaProdutos.buscarProduto(numeroProduto);
                            if (p == null) {
                                System.out.println("Produto não encontrado");
                                break;
                            }
                            p.reduzirEstoque(1);
                            pedido.adicionarProduto(p);
                            System.out.print("Digite 1 para adicionar mais produtos ou 2 para finalizar: ");
                            int opcaoPedido = scanner.nextInt();
                            scanner.nextLine();
                            if (opcaoPedido == 2) {
                                break;
                            }
                            System.out.print("Digite o numero do produto para adicionar: ");

                        }
                        filaPedidos.adicionarPedido(pedido);
                        break;
                    }
                case 3:
                    Pedido pedidoExcluido = filaPedidos.removerPedido();
                    if (pedidoExcluido != null) {
                        System.out.println(pedidoExcluido.toString());
                        historicoPedidos.adicionarAoHistorico(pedidoExcluido);
                    } else {
                        System.out.println("Não há pedidos pendentes");
                    }
                    break;

                case 4:
                    listaProdutos.mostrarTodos();
                    break;

                case 5:
                    filaPedidos.exibirFila();
                    break;

                case 6:
                    historicoPedidos.mostrarTodos();
                    break;

                case 7:
                    scanner.close();
                    System.exit(0);
                    break;

            }
        }
    }
}