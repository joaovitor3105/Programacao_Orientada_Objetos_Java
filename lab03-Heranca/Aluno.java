public class Aluno extends Pessoa {
    private int matricula;

    public Aluno(String nome, String endereco, int matricula) {
        super(nome, endereco);
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String toString() {
        return "Nome:" + getNome() + "\n" + "Endereco:" + getEndereco() + "\n" + "Matricula:"
                + getMatricula();
    }

}
