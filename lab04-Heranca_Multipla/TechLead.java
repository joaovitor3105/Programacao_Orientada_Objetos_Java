public class TechLead extends Funcionario implements Gerenteinterface, Desenvolvedorinterface {

    private int projetos_em_andamento;
    private Gerente gerente;
    private Desenvolvedor desenvolvedor;

    public int getProjetos_em_andamento() {
        return projetos_em_andamento;
    }

    public TechLead(String nome, int salario_base, int numero_de_equipes, String linguagem, int projetos_em_andamento) {
        super(nome, salario_base);
        this.desenvolvedor = new Desenvolvedor(nome, salario_base, linguagem);
        this.gerente = new Gerente(nome, salario_base, numero_de_equipes);
        this.projetos_em_andamento = projetos_em_andamento;

    }

    @Override
    public String descricao() {
        return "\nNome:" + getNome() + "\nSalario:" + getSalario_base() + "\nNumero de equipes:"
                + Integer.toString(getNumero_de_equipes()) + "\nBonus:" + bonus() + projetosrealizados()
                + "Projetos em Andamento:" + Integer.toString(projetos_em_andamento);
    }

    @Override
    public int getNumero_de_equipes() {
        return gerente.getNumero_de_equipes();
    }

    @Override
    public String bonus() {

        return Integer.toString(gerente.getNumero_de_equipes() * 500);
    }

    @Override
    public String getLinguagem() {
        return desenvolvedor.getLinguagem();
    }

    @Override
    public String projetosrealizados() {

        return "\nProjetos Realizados na Linguagem:" + desenvolvedor.getLinguagem();
    }

}
