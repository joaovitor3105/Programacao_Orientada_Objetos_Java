import java.util.List;
import java.util.ArrayList;;

public class Curso {
    private String nomecurso;
    private List<Professor> professor;
    private List<Aluno> aluno;
    private List<Disciplina> disciplina;

    public Curso() {

        this.professor = new ArrayList<>();
        this.disciplina = new ArrayList<>();
        this.aluno = new ArrayList<>();
    }

    public String getNomecurso() {
        return nomecurso;
    }

    public void setNomecurso(String nomecurso) {
        this.nomecurso = nomecurso;
    }

    public void cadastrarProfessor(String nome, String endereco, String titulacao, String curso) {
        professor.add(new Professor(nome, endereco, titulacao, curso));

    }

    public void cadastrarAluno(String nome, String endereco, int matricula) {
        aluno.add(new Aluno(nome, endereco, matricula));

    }

    public void cadastrarDisciplina(String nomedisciplina, int CH, Professor professor) {
        disciplina.add(new Disciplina(nomedisciplina, CH, professor));

    }

    public void imprimirListaDeProfessores() {
        if (professor.isEmpty()) {
            System.err.println("Nenhum professor cadastrado.");
        } else {
            for (Professor prof : professor) {
                System.out.println(prof);
            }
        }
    }

    public void imprimirListaDeDisciplinas() {
        if (professor.isEmpty()) {
            System.err.println("Nenhuma Disciplina cadastrada.");
        } else {
            for (Disciplina disc : disciplina) {
                System.out.println(disc);
            }
        }
    }

    public void imprimirListaDeAlunos() {
        if (professor.isEmpty()) {
            System.err.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno al : aluno) {
                System.out.println(al);
            }
        }
    }

    public Professor procurarProfessor(String novoprofessor) {

        for (Professor professores : professor) {
            if (professores.getNome().equals(novoprofessor)) {
                return professores;
            }

        }
        return null;
    }
}