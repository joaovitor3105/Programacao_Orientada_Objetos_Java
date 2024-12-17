public class Gerente extends Funcionario implements Gerenteinterface {
    private int numero_de_equipes;

    public Gerente(String nome, int salario_base, int numero_de_equipes) {
        super(nome, salario_base);
        this.numero_de_equipes = numero_de_equipes;
    }

    @Override
    public int getNumero_de_equipes() {
        return numero_de_equipes;
    }

    @Override
    public String bonus() {

        return Integer.toString(numero_de_equipes * 500);
    }

    @Override
    public String descricao() {
        return "\nNome:" + getNome() + "\nSalario:" + getSalario_base() + "\nNumero de equipes:"
                + Integer.toString(numero_de_equipes) + "\nBonus:" + bonus();

    }
}
