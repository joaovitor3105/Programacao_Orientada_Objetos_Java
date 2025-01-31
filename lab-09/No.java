public class No<T> {
    private T valor;
    private No<T> prox;

    public No(T valor) {
        this.valor = valor;
        this.prox = null;
    }

    public T obterValor() {
        return valor;
    }

    public No<T> obterProx() {
        return prox;
    }

    public void setProx(No<T> prox) {
        this.prox = prox;
    }
}
