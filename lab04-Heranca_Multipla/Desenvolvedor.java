public class Desenvolvedor extends Funcionario implements Desenvolvedorinterface {
    private String linguagem;

    public Desenvolvedor(String nome, int salario_base, String linguagem) {
        super(nome, salario_base);
        this.linguagem = linguagem;
    }

    @Override
    public String getLinguagem() {
        return linguagem;
    }

    @Override
    public String projetosrealizados() {

        return "\nProjetos Realizados na Linguagem:" + linguagem;
    }

    @Override
    public String descricao() {

        return "\nNome:" + getNome() + "\nSalario:" + getSalario_base() + projetosrealizados();
    }

}
