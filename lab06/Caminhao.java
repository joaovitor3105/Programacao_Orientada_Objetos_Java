public class Caminhao extends Veiculo {
    private double capacidadeCarga;

    public Caminhao(String placa, String modelo, double capacidadeCarga) {
        super(placa, modelo);
        this.capacidadeCarga = capacidadeCarga;
        this.setHabilitacao(Habilitacao.C);
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    @Override
    public String getDetalhes() {
        return "Placa: " + getPlaca() + ", Modelo: " + getModelo() + ",Capacidade de Carga:"
                + Double.toString(capacidadeCarga);
    }

    @Override
    public double CalcularCusto(double distancia) {
        return distancia * 1.0;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }
}
