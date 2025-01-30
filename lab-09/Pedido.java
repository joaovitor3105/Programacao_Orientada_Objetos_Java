import java.util.ArrayList;

public class Pedido {
    private int codigoPedido;
    private String clienteNome;
    private ArrayList<Produto> itens;
    private double total;

    Pedido(int codigoPedido, String clienteNome) {
        this.codigoPedido = codigoPedido;
        this.clienteNome = clienteNome;
        this.itens = new ArrayList<Produto>();
        this.total = 0;
    }

    public void adicionarProduto(Produto produto) {
        this.itens.add(produto);
        this.total += produto.getPreco();
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public ArrayList<Produto> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Produto> itens) {
        this.itens = itens;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String toString() {
        String str = "Pedido: " + this.codigoPedido + " Cliente: " + this.clienteNome + "\n";
        for (Produto produto : this.itens) {
            str += produto.toString() + "\n";
        }
        str += "Total: " + this.total;
        return str;
    }

}
