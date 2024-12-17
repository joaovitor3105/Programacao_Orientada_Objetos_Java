public class Professor extends Pessoa {
    private String titulacao;
    private String curso;

    public Professor(String nome, String endereco, String titulacao, String curso) {
        super(nome, endereco);
        this.titulacao = titulacao;
        this.curso = curso;

    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String toString() {
        return "Nome:" + getNome() + "\n" + "Endereco:" + getEndereco() + "\n" + "Titulacao:" + getTitulacao() + "\n"
                + "Curso:"
                + getTitulacao();
    }

}
