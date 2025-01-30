import java.util.ArrayList;

public class ListaProdutos<T> {
    ArrayList<T> produtos;

    ListaProdutos() {
        produtos = new ArrayList<T>();
    }

    public void adicionarProduto(T produto) {
        produtos.add(produto);
    }

    public T buscarProduto(int codigo) {
        for (T produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
    }
}
