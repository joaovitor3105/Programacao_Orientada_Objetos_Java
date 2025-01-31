public class FilaPedidos<T> {
    private No<T> ini;
    private No<T> fim;

    public FilaPedidos() {
        this.ini = null;
        this.fim = null;
    }

    public boolean vazia() {
        return ini == null;
    }

    public void adicionarPedido(T valor) {
        No<T> novoNo = new No<>(valor);
        if (vazia()) {
            ini = novoNo;
            fim = novoNo;
        } else {
            fim.setProx(novoNo);
            fim = novoNo;
        }
    }

    public T removerPedido() {
        T valor;
        if (vazia()) {
            System.out.println("A fila está vazia!");
            return null;
        } else {
            valor = ini.obterValor();
            ini = ini.obterProx();
            if (ini == null) {
                fim = null;
            }
            return valor;
        }
    }

    public void exibirFila() {
        System.out.println("\nImprimindo todos os elementos...");
        No<T> atual = ini;
        if (vazia()) {
            System.out.println("A fila NÃO possui elementos!!");
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
        No<T> atual = ini;
        while (atual != null) {
            tam++;
            atual = atual.obterProx();
        }
        return tam;
    }
}
