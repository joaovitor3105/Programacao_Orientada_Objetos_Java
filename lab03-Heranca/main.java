import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Curso curso = new Curso();
        while (true) {

            System.err.print("--------------------------------------------------------------------");
            System.err.print("\n\t\tMENU");
            System.err.print("\n1-Cadastrar Professor");
            System.err.print("\n2-Cadastrar Aluno");
            System.err.print("\n3-Cadastrar Disciplina");
            System.err.print("\n4-Imprimir Professores");
            System.err.print("\n5-Imprimir Alunos");
            System.err.print("\n6-Imprimir Disciplinas");
            System.err.print("\n7-Sair");
            System.err.print("\n--------------------------------------------------------------------");
            int num = scan.nextInt();
            scan.nextLine();
            switch (num) {
                case 1:
                    String nome, endereco, titulacao, nomecurso;
                    System.err.print("Digite o nome do professor:");
                    nome = scan.nextLine();
                    System.err.print("Digite o endereco:");
                    endereco = scan.nextLine();
                    System.err.print("Digite o titulacao:");
                    titulacao = scan.nextLine();
                    System.err.print("Digite o curso:");
                    nomecurso = scan.nextLine();
                    curso.cadastrarProfessor(nome, endereco, titulacao, nomecurso);

                    break;

                case 2:
                    int matricula;
                    System.err.print("Digite o nome do aluno:");
                    nome = scan.nextLine();
                    System.err.print("Digite o endereco:");
                    endereco = scan.nextLine();
                    System.err.print("Digite o numero da matricula:");
                    matricula = scan.nextInt();
                    scan.nextLine();
                    curso.cadastrarAluno(nome, endereco, matricula);

                    break;
                case 3:
                    String nomedisciplina;
                    int CH;
                    String novoprofessor;
                    System.err.print("Digite o nome da disciplina:");
                    nomedisciplina = scan.nextLine();
                    System.err.print("Digite o CH:");
                    CH = scan.nextInt();
                    scan.nextLine();
                    System.err.print("Agora adicione o professor que vai aplicar a disciplina:\n\n");
                    curso.imprimirListaDeProfessores();
                    System.err.print("Qual professor vai lecionar:\n\n");
                    novoprofessor = scan.nextLine();

                    Professor professordisciplina = curso.procurarProfessor(novoprofessor);
                    if (professordisciplina == null) {
                        System.err.print("Nome Incorreto");
                        break;
                    } else

                        curso.cadastrarDisciplina(nomedisciplina, CH, professordisciplina);

                    break;
                case 4:
                    curso.imprimirListaDeProfessores();
                    break;

                case 5:
                    curso.imprimirListaDeAlunos();
                    break;
                case 6:
                    curso.imprimirListaDeDisciplinas();
                    break;
                case 7:
                    System.err.println("Saindo...");
                    scan.close();
                    return;
                default:
                    System.err.println("Opção inválida! Tente novamente.");

                    break;
            }

        }

    }
}
