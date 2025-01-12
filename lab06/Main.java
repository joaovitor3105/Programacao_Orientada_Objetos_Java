import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static boolean verificarHabilitacao(Motorista motorista, Veiculo veiculo) {
        Habilitacao habilitacaodoveiculo = veiculo.getHabilitacao();
        Habilitacao habilitacaodomotorista = motorista.getHabilitacao();
        if (habilitacaodomotorista == Habilitacao.AC) {
            return true;
        }

        else if (habilitacaodomotorista == habilitacaodoveiculo) {
            return true;
        }

        else if (habilitacaodomotorista == Habilitacao.AB) {
            if (habilitacaodoveiculo == Habilitacao.A || habilitacaodoveiculo == Habilitacao.B) {
                return true;
            }
        }

        else if (habilitacaodomotorista == Habilitacao.C && habilitacaodoveiculo != Habilitacao.A) {
            return true;

        }

        else
            System.out.println("Motorista não tem habilitação para dirigir este veículo");
        return false;
    }

    public static boolean ProcurarMotorista(ArrayList<Motorista> motoristas, String cpfmotorista) {
        for (Motorista motorista : motoristas) {
            if (motorista.getCpf().equals(cpfmotorista)) {
                return true;
            }
        }
        return false;
    }

    public static Motorista retornaMotorista(ArrayList<Motorista> motoristas, String cpfmotorista) {
        for (Motorista motorista : motoristas) {
            if (motorista.getCpf().equals(cpfmotorista)) {
                return motorista;
            }
        }
        return null;
    }

    public static Veiculo retornaVeiculo(ArrayList<Veiculo> veiculos, String placaveiculo) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placaveiculo)) {
                return veiculo;
            }
        }
        return null;
    }

    public static boolean ProcurarVeiculo(ArrayList<Veiculo> veiculos, String placaveiculo) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placaveiculo)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Motorista> motoristas = new ArrayList<Motorista>();
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
        ArrayList<Viagem> viagens = new ArrayList<Viagem>();
        int opcao = 0;
        System.err.println("Bem vindo ao sistema de viagens!");
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar motorista");
            System.out.println("2 - Cadastrar veículo");
            System.out.println("3 - Cadastrar viagem");
            System.out.println("4 - Exibir Detalhes de uma Viagem");
            System.out.println("5 - Excluir Motorista");
            System.out.println("6 - Excluir Veículo");
            System.out.println("7 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do motorista:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o cpf do motorista:");
                    String cpf = scanner.nextLine();
                    System.out.println("Digite a habilitação do motorista:");
                    for (Habilitacao habilitacao : Habilitacao.values()) {
                        System.out.println(habilitacao);
                    }

                    Habilitacao habilitacao = null;

                    while (true) {

                        try {
                            habilitacao = Habilitacao.valueOf(scanner.nextLine());

                        } catch (IllegalArgumentException e) {
                            System.err.println("Digite uma categoria valida");
                            continue;
                        }
                        break;
                    }
                    Motorista motorista = new Motorista(nome, cpf, habilitacao);
                    motoristas.add(motorista);
                    break;

                case 2:
                    System.out.println("Digite qual o tipo de veículo:");
                    System.out.println("1 - Carro");
                    System.out.println("2 - Moto");
                    System.out.println("3 - Caminhão");
                    int op;

                    while (true) {
                        try {
                            op = scanner.nextInt();
                            scanner.nextLine();
                            if (op > 0 && op < 4) {
                                break;
                            } else {
                                System.err.println("Digite um número válido (1-3)");
                            }
                        } catch (Exception e) {
                            System.err.println("Digite um número válido");
                            scanner.nextLine();
                        }
                    }

                    System.out.println("Digite a placa do veículo:");
                    String placa = scanner.nextLine();
                    System.out.println("Digite o modelo do veículo:");
                    String modelo = scanner.nextLine();
                    if (op == 1) {
                        System.out.println("Digite a quantidade de assentos:");
                        int assentos = scanner.nextInt();
                        scanner.nextLine();
                        Carro carro = new Carro(placa, modelo, assentos);
                        veiculos.add(carro);

                    }
                    if (op == 2) {
                        System.out.println("Digite a quantidade de cilindradas:");
                        int cilindradas = scanner.nextInt();
                        scanner.nextLine();
                        Moto moto = new Moto(placa, modelo, cilindradas);
                        veiculos.add(moto);

                    }
                    if (op == 3) {
                        System.out.println("Digite a capacidade de carga:");
                        double capacidadeCarga = scanner.nextDouble();
                        scanner.nextLine();
                        Caminhao caminhao = new Caminhao(placa, modelo, capacidadeCarga);
                        veiculos.add(caminhao);

                    }
                    System.err.println("Veículo cadastrado com sucesso!");
                    break;

                case 3:
                    System.out.println("Motoristas cadastrados:");
                    for (Motorista m : motoristas) {
                        System.out.println(m.getDetalhes());
                    }
                    System.out.println("Digite o cpf do motorista que vai adicionar a viagem:");
                    String cpfMotorista = scanner.nextLine();

                    if (ProcurarMotorista(motoristas, cpfMotorista)) {
                        System.out.println("Veículos cadastrados:");
                        for (Veiculo v : veiculos) {
                            System.out.println(v.getDetalhes());
                        }
                        System.out.println("Digite a placa do veículo:");
                        String placaVeiculo = scanner.nextLine();

                        if (ProcurarVeiculo(veiculos, placaVeiculo)) {
                            Motorista motoristaviagem = retornaMotorista(motoristas, cpfMotorista);
                            Veiculo veiculo = retornaVeiculo(veiculos, placaVeiculo);
                            if (verificarHabilitacao(motoristaviagem, veiculo)) {
                                System.out.println("Digite a distância da viagem(em Km):");
                                double distancia = scanner.nextDouble();
                                scanner.nextLine();
                                Viagem viagem = new Viagem(motoristaviagem, veiculo, distancia);
                                viagens.add(viagem);
                                System.out.println("Viagem cadastrada com sucesso!");
                            } else {
                                System.out.println("Motorista não tem habilitação para dirigir este veículo");
                            }
                            break;
                        } else {
                            System.out.println("Veículo não encontrado");
                        }
                        break;

                    } else {
                        System.out.println("Motorista não encontrado");
                    }
                    break;
                case 4:
                    System.out.println("Motoristas cadastrados:");
                    for (Motorista m : motoristas) {
                        System.out.println(m.getDetalhes());
                    }
                    System.out.println("Digite o cpf do motorista que deseja ver a viagem:");
                    String cpfMotoristaViagem = scanner.nextLine();
                    for (Viagem viagem : viagens) {
                        if (viagem.getMotorista().getCpf().equals(cpfMotoristaViagem)) {
                            System.out.println(viagem.getDetalhes());
                            break;
                        }
                    }
                    System.out.println("Viagem não encontrada");
                    break;

                case 5:
                    System.out.println("Motoristas cadastrados:");
                    for (Motorista m : motoristas) {
                        System.out.println(m.getDetalhes());
                    }
                    System.out.println("Digite o cpf do motorista que deseja excluir:");
                    String cpfMotoristaExcluir = scanner.nextLine();
                    if (ProcurarMotorista(motoristas, cpfMotoristaExcluir)) {
                        motoristas.removeIf(m -> m.getCpf().equals(cpfMotoristaExcluir));

                        viagens.removeIf(viagem -> viagem.getMotorista().getCpf().equals(cpfMotoristaExcluir));
                        System.out.println("Motorista excluído com sucesso!");
                    } else {
                        System.out.println("Motorista não encontrado");
                    }
                    break;

                case 6:
                    System.out.println("Veículos cadastrados:");
                    for (Veiculo v : veiculos) {
                        System.out.println(v.getDetalhes());
                    }
                    System.out.println("Digite a placa para excluir o veiculo:");
                    String placaExcluir = scanner.nextLine();
                    if (ProcurarVeiculo(veiculos, placaExcluir)) {

                        veiculos.removeIf(veiculo -> veiculo.getPlaca().equals(placaExcluir));

                        viagens.removeIf(viagem -> viagem.getVeiculo().getPlaca().equals(placaExcluir));
                        System.out.println("Veículo excluído com sucesso!");
                    } else {
                        System.out.println("Veículo não encontrado");
                    }
                    break;

                case 7:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Digite uma opção válida");
                    break;

            }
        }

    }
}
