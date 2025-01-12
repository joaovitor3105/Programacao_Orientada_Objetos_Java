
public class Viagem {
    private Motorista motorista;
    private Veiculo veiculo;
    private double distancia;

    public Motorista getMotorista() {
        return motorista;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public double getDistancia() {
        return distancia;
    }

    public Viagem(Motorista motorista, Veiculo veiculo, double distancia) {
        this.motorista = motorista;
        this.veiculo = veiculo;
        this.distancia = distancia;

    }

    public double calcularCusto() {
        return veiculo.CalcularCusto(distancia);
    }

    public String getDetalhes() {
        return "Motorista: " + motorista.getNome() + ", Veiculo: " + veiculo.getDetalhes() + ", Distancia: "
                + Double.toString(distancia) + ", Custo: R$" + Double.toString(calcularCusto());
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

}