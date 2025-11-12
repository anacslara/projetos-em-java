package modelo;

public interface Financiavel {
    public float entradaMinima();
    public int prazoMaximoEmMeses();
    public float simularParcelas(float entrada, int meses, float taxaAnual);
}
