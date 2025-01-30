public class Produto {
    private int codigo;
    private String descricao;
    private double preco;
    private int estoque;

    Produto(int codigo, String descricao, double preco, int estoque) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
    }

    Produto(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;

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
        if (quantidade > 0) {
            this.estoque -= quantidade;
        }
    }

    public String tooString() {
        return "Código: " + this.codigo + " Descrição: " + this.descricao + " Preço: " + this.preco + " Estoque: "
                + this.estoque;
    }
}