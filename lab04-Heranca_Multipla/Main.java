import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Gerente> gerentes = new ArrayList<>();
        List<Desenvolvedor> desenvolvedores = new ArrayList<>();
        List<TechLead> techleads = new ArrayList<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Gerente");
            System.out.println("2. Cadastrar Desenvolvedor");
            System.out.println("3. Cadastrar TechLead");
            System.out.println("4. Imprimir Funcionarios");
            System.out.println("5. Sair");

            System.out.print("Selecione uma opção: ");
            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1: {
                    System.out.print("Digite o nome do novo Gerente:");
                    String nome = scan.nextLine();
                    System.out.print("Digite o Salario do novo Gerente:");
                    int Salario = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Informe o Numero de equipes que ele vai trabalhar:");
                    int num_equipes = scan.nextInt();
                    scan.nextLine();
                    gerentes.add(new Gerente(nome, Salario, num_equipes));
                    break;
                }
                case 2: {
                    System.out.print("Digite o nome do novo Desenvolvedor:");
                    String nome = scan.nextLine();
                    System.out.print("Digite o Salario do novo Desenvolvedor:");
                    int Salario = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Digite a linguagem de programacao principal:");
                    String linguagem = scan.nextLine();
                    desenvolvedores.add(new Desenvolvedor(nome, Salario, linguagem));

                    break;
                }
                case 3: {
                    System.out.print("Digite o nome do novo TechLead:");
                    String nome = scan.nextLine();
                    System.out.print("Digite o Salario do novo TechLead:");
                    int Salario = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Informe o Numero de equipes que ele vai trabalhar:");
                    int num_equipes = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Digite a linguagem de programacao principal:");
                    String linguagem = scan.nextLine();

                    System.out.print("Informe o Numero de projetos em andamento:");
                    int num_projetos = scan.nextInt();
                    scan.nextLine();
                    techleads.add(new TechLead(nome, Salario, num_equipes, linguagem, num_projetos));
                    break;
                }
                case 4: {

                    if (!gerentes.isEmpty()) {
                        System.out.println("\nGerentes:");
                        for (Gerente g : gerentes) {
                            System.out.println(g.descricao());
                        }
                    }
                    if (!desenvolvedores.isEmpty()) {
                        System.out.println("\nDesenvolvedores:");
                        for (Desenvolvedor d : desenvolvedores) {
                            System.out.println(d.descricao());
                        }
                    }

                    if (!techleads.isEmpty()) {
                        System.out.println("\nTechLeads:");
                        for (TechLead t : techleads) {
                            System.out.println(t.descricao());
                        }
                    }
                    break;
                }
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}