package modelo;

public final class Caminhao extends Veiculo{
    private int numEixos;
    private int capacidadeCarga;

    public Caminhao(String placa, String marca, String modelo, int ano, int quilometragem, float valorBase, int numEixos, int capacidadeCarga) {
        super(placa, marca, modelo, ano, quilometragem, valorBase);
        this.numEixos = numEixos;
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("número de eixos:" + numEixos);
        System.out.println("capacidade de carga:" + capacidadeCarga);
    }

    @Override
    public int prazoMaximoEmMeses() {
        return 120;
    }

    @Override
    public String gerarTituloAnuncio() {
        return null;
    }

    @Override
    public String gerarDescricaoAnuncio() {
        return null;
    }

    @Override
    public float entradaMinima() {
        return getValorBase()*0.3f;
    }
}
