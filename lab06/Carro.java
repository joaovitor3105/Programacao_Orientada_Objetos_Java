public class Carro extends Veiculo {
    private int assentos;

    public Carro(String placa, String modelo, int assentos) {
        super(placa, modelo);
        this.assentos = assentos;
        this.setHabilitacao(Habilitacao.B);

    }

    @Override
    public String getDetalhes() {
        return "Placa: " + getPlaca() + ", Modelo: " + getModelo() + ",Assentos:" + Integer.toString(assentos);
    }

    public double CalcularCusto(double distancia) {
        return distancia * 0.5;
    }

    public int getAssentos() {
        return assentos;
    }

    public void setAssentos(int assentos) {
        this.assentos = assentos;
    }

}
