public class Disciplina {
    private String nomedisciplina;
    private int CH;
    private Professor professor;

    public Disciplina(String nomedisciplina, int CH, Professor professor) {
        this.nomedisciplina = nomedisciplina;
        this.CH = CH;
        this.professor = professor;
    }

    public String getNomedisciplina() {
        return nomedisciplina;
    }

    public void setNomedisciplina(String nomedisciplina) {
        this.nomedisciplina = nomedisciplina;
    }

    public int getCH() {
        return CH;
    }

    public void setCH(int cH) {
        CH = cH;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String toString() {

        return "Nome:" + getNomedisciplina() + "\n" + "CH:" + getCH() + "\n" + "Professor:" + getProfessor();

    }
}
