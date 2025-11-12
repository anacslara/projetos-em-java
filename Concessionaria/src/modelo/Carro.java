package modelo;

public final class Carro extends Veiculo{
    private int numPortas;
    private String tipoCarroceria;
    private int capacidadeBagagem;

    public Carro(String placa, String marca, String modelo, int ano, int quilometragem, float valorBase, int numPortas, String tipoCarroceria, int capacidadeBagagem) {
        super(placa, marca, modelo, ano, quilometragem, valorBase);
        this.numPortas = numPortas;
        this.tipoCarroceria = tipoCarroceria;
        this.capacidadeBagagem = capacidadeBagagem;
    }
    
    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("número de portas:" + numPortas);
        System.out.println("tipo de carroceria:" + tipoCarroceria);
        System.out.println("capacidade de bagagem:" + capacidadeBagagem);
    }

    @Override
    public int prazoMaximoEmMeses() {
        return 60;
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
        return getValorBase()*0.2f;
    }
}
