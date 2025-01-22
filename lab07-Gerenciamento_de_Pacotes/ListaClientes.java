import java.util.ArrayList;

public class ListaClientes {
    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

    public void adicionarCliente(String nome, String CPF) {
        Cliente cliente = new Cliente(nome, CPF);

        listaClientes.add(cliente);
        System.out.println("Cliente adicionado com sucesso!");
    }

    public Cliente buscarCliente(String CPF) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCPF().equals(CPF)) {
                return cliente;
            }
        }
        return null;
    }

    public void exibirClientes() {
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
    }
}
