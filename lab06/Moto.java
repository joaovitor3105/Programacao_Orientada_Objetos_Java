public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String placa, String modelo, int cilindradas) {
        super(placa, modelo);
        this.cilindradas = cilindradas;
        this.setHabilitacao(Habilitacao.A);

    }

    @Override
    public String getDetalhes() {
        return "Placa: " + getPlaca() + ", Modelo: " + getModelo() + ",Cilindradas:" + Integer.toString(cilindradas);
    }

    @Override
    public double CalcularCusto(double distancia) {
        return distancia * 0.2;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

}
