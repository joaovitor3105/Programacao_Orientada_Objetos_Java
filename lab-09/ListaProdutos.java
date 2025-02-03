public class ListaProdutos<T> {
    private No<T> cabeca;
    private No<T> cauda;

    public ListaProdutos() {
        this.cabeca = null;
        this.cauda = null;
    }

    public ListaProdutos(T valor) {
        this.cabeca = new No<>(valor);
        this.cauda = this.cabeca;
    }

    public boolean vazia() {
        return cabeca == null;
    }

    public void adicionarProduto(T valor) {
        No<T> novoNo = new No<>(valor);
        if (vazia()) {
            cabeca = novoNo;
            cauda = novoNo;
        } else {
            cauda.setProx(novoNo);
            cauda = novoNo;
        }
    }

    public void mostrarTodos() {
        System.out.println("\nImprimindo todos os elementos...");
        No<T> atual = cabeca;
        int i = 0;
        if (vazia()) {
            System.out.println("A lista NÃO possui elementos!!");
        } else {
            while (atual != null) {
                System.out.println(i + " - " + atual.obterValor());
                atual = atual.obterProx();
                i++;
            }
            System.out.println();
        }
    }

    public int size() {
        int tam = 0;
        No<T> atual = cabeca;
        while (atual != null) {
            tam++;
            atual = atual.obterProx();
        }
        return tam;
    }

    public T buscarProduto(int numero) {
        No<T> atual = cabeca;

        for (int i = 0; atual != null; i++) {
            if (i == numero) {
                return atual.obterValor();
            }
            atual = atual.obterProx();
        }
        return null;
    }
}