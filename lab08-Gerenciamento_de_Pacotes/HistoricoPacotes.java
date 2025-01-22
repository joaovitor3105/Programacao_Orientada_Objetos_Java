
import java.util.ArrayList;

public class HistoricoPacotes {
    private ArrayList<Pacote> historico = new ArrayList<Pacote>();

    public void adicionarAoHistorico(Pacote pacote) {
        historico.add(pacote);

    }

    public void exibirHistorico() {
        for (Pacote pacote : historico) {
            System.out.println(pacote);
        }
    }

}
