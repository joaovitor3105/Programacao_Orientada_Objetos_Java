public class HistoricoPedidos<T> {
    private No<T> cabeca;
    private No<T> cauda;

    public HistoricoPedidos() {
        this.cabeca = null;
        this.cauda = null;
    }

    public HistoricoPedidos(T valor) {
        this.cabeca = new No<>(valor);
        this.cauda = this.cabeca;
    }

    public boolean vazia() {
        return cabeca == null;
    }

    public void adicionarAoHistorico(T valor) {
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
        if (vazia()) {
            System.out.println("A lista NÃO possui elementos!!");
        } else {
            while (atual != null) {
                System.out.println(atual.obterValor());
                atual = atual.obterProx();
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

    public boolean existe(T valor) {
        No<T> atual = cabeca;
        while (atual != null) {
            if (atual.obterValor().equals(valor)) {
                return true;
            }
            atual = atual.obterProx();
        }
        return false;
    }

}
