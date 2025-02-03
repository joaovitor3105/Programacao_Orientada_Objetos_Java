public class Produto {
    private int codigo;
    private String descricao;
    private double preco;
    private int estoque;

    public Produto(int codigo, String descricao, double preco, int estoque) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Produto(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = 10;
        this.estoque = 5;

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void reduzirEstoque(int quantidade) {
        if (quantidade > 0 && quantidade <= this.estoque) {
            this.estoque -= quantidade;
        }
    }

    @Override
    public String toString() {
        return "Código: " + this.codigo + " Descrição: " + this.descricao + " Preço: " + this.preco;
    }
}