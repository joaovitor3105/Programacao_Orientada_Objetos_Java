
public class Veiculo {
    private String placa;
    private String modelo;
    private Habilitacao habilitacao;

    public Veiculo(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
        this.habilitacao = null;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDetalhes() {
        return "Placa: " + placa + ", Modelo: " + modelo;
    }

    public double CalcularCusto(double distancia) {
        return distancia * 0.0;
    }

    public void setHabilitacao(Habilitacao habilitacao) {
        this.habilitacao = habilitacao;
    }

    public Habilitacao getHabilitacao() {
        return habilitacao;
    }
}