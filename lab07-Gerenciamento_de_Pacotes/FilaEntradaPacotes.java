import java.util.Queue;
import java.util.LinkedList;

public class FilaEntradaPacotes {
    private Queue<Pacote> fila = new LinkedList<Pacote>();

    public void adicionarPacote(Pacote pacote) {
        fila.add(pacote);
        System.out.println("Pacote adicionado com sucesso!");
    }

    public Pacote removerPacote() {
        return fila.poll();
    }

    public void exibirFila() {
        for (Pacote pacote : fila) {
            System.out.println(pacote);
        }
    }
}
