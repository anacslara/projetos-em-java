package modelo;

public final class Moto extends Veiculo{
    private String tipoPartida;

    public Moto(String placa, String marca, String modelo, int ano, int quilometragem, float valorBase, String tipoPartida){
        super(placa, marca, modelo, ano, quilometragem, valorBase);
        this.tipoPartida = tipoPartida;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("tipo de partida:"+tipoPartida);
    }

    @Override
    public int prazoMaximoEmMeses() {
        return 30;
    }

    @Override
    public String gerarTituloAnuncio() {
        return null;
    }

    @Override
    public String gerarDescricaoAnuncio() {
        return null;
    }
}
