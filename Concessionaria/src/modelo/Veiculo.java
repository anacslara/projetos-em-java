package modelo;

public abstract class Veiculo implements Financiavel, Anunciavel {
    protected String placa;
    protected String marca;
    protected String modelo;
    protected int ano;
    protected int quilometragem;
    protected float valorBase;

    public Veiculo(String placa, String marca, String modelo, int ano, int quilometragem, float valorBase) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.valorBase = valorBase;
    }

    public float getValorBase(){
        return valorBase;
    }

    @Override
    public float entradaMinima() {
        return valorBase * 0.1f;
    }

    @Override
    public float simularParcelas(float entrada, int meses, float taxaAnual) {
        float valorFinanciado = calcularValorFinal() - entrada;

        if (valorFinanciado <= 0 || meses <= 0) {
            return 0; 
        }

        float i = taxaAnual / 12 / 100; 
        float parcela = (valorFinanciado * i) / (1 - (float) Math.pow(1 + i, -meses));
        return parcela;
    }

    @Override
    public float gerarPrecoParaAnuncio() {
        float valorComDesconto = calcularValorFinal() - (calcularValorFinal()*0.1f);
        return valorComDesconto;
    }

    public void exibirInformacoes() {
        System.out.println("placa:" + placa);
        System.out.println("marca:" + marca);
        System.out.println("modelo:" + modelo);
        System.out.println("ano:" + ano);
        System.out.println("quilometragem:" + quilometragem);
        System.out.println("valor base:" + valorBase);
    }

    public final void realizarRevisao(int novoKM) {
        if (novoKM > quilometragem) {
            this.quilometragem = novoKM;
        }
    }

    public float calcularValorFinal() {
        int anoAtual = java.time.Year.now().getValue();
        int idade = anoAtual - this.ano;

        if (idade <= 0) {
            return valorBase;
        }

        int kmPorAno = quilometragem / idade;
        float descontoPorAno;

        if (kmPorAno < 15) {
            descontoPorAno = 0.005f;
        } else {
            descontoPorAno = 0.01f;
        }

        float valorFinal = valorBase * (1 - (descontoPorAno * idade));
        return valorFinal;
    }
}