package lab01;

public class Corrida {

    private String ModelodoCarro;
    private float MotorizacaodoCarro;
    private String FabricantedoVeiculo;
    private String NomedoMotorista;
    private int QuilometragemInicial;
    private int QuilometragemFinal;

    public String getModelodoCarro() {
        return ModelodoCarro;
    }

    public void setModelodoCarro(String modelodoCarro) {
        ModelodoCarro = modelodoCarro;
    }

    public float getMotorizacaodoCarro() {
        return MotorizacaodoCarro;
    }

    public void setMotorizacaodoCarro(float motorizacaodoCarro) {
        MotorizacaodoCarro = motorizacaodoCarro;
    }

    public String getFabricantedoVeiculo() {
        return FabricantedoVeiculo;
    }

    public void setFabricantedoVeiculo(String fabricantedoVeiculo) {
        FabricantedoVeiculo = fabricantedoVeiculo;
    }

    public String getNomedoMotorista() {
        return NomedoMotorista;
    }

    public void setNomedoMotorista(String nomedoMotorista) {
        NomedoMotorista = nomedoMotorista;
    }

    public int getQuilometragemInicial() {
        return QuilometragemInicial;
    }

    public void setQuilometragemInicial(int quilometragemInicial) {
        QuilometragemInicial = quilometragemInicial;
    }

    public int getQuilometragemFinal() {
        return QuilometragemFinal;
    }

    public void setQuilometragemFinal(int quilometragemFinal) {
        QuilometragemFinal = quilometragemFinal;
    }

    public int calcularQuilometragemPercorrida(int Kminicial, int Kmfinal) {

        return Kmfinal - Kminicial;

    }

    public double valorFinal() {

        return 3.75 * calcularQuilometragemPercorrida(QuilometragemInicial, QuilometragemFinal);
    }

    public void imprimir() {
        System.out.println("--------------------------");
        System.out.println("Nome do motorista:" + NomedoMotorista + "\n");
        System.out.println("Fabricante:" + FabricantedoVeiculo + "\n");
        System.out.println("Modelo:" + ModelodoCarro + "\n");
        System.out.println("Motorização:" + MotorizacaodoCarro + "\n");
        System.out.println("Quilometragem Inicial:" + QuilometragemInicial + "\n");
        System.out.println("Quilometragem Final:" + QuilometragemFinal + "\n");
        System.out.println("Quilometragem Percorrida:"
                + calcularQuilometragemPercorrida(QuilometragemInicial, QuilometragemFinal) + "\n");
        System.out.println("Valor Final R$" + valorFinal() + "\n");
        System.out.println("--------------------------");

    }

}
