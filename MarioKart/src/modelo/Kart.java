package modelo;

public class Kart {
    private int velocidadeAtual;
    private int velocidadeMax;
    private float desgastePneus;
    private Piloto piloto;
    
    public Kart(int velocidadeMax, Piloto piloto) {
        if (velocidadeMax > 0){
            this.velocidadeAtual = 0;
            this.velocidadeMax = velocidadeMax;
            this.desgastePneus = 0;
        }
        this.piloto = piloto;
    }

    public int getVelocidadeAtual(){
        return velocidadeAtual;
    }

    public void setVelocidadeAtual(int velocidade) {
        if (velocidade < 0) {
            this.velocidadeAtual = 0;
        } 
        else if (velocidade > velocidadeMax) {
            this.velocidadeAtual = velocidadeMax;
        } 
        else {
            this.velocidadeAtual = velocidade;
        }
    }


    private void desgastarPneus(float desgaste){
        if (desgastePneus + desgaste <= 100){
            desgastePneus += desgaste;
        } else{
            desgastePneus = 100;
        }
    }

    public void acelerar(int seg){
        if (seg < 0) return;

        if (velocidadeAtual + piloto.getHabilidade()*seg <= velocidadeMax){
            velocidadeAtual += piloto.getHabilidade()*seg;
        } else{
            velocidadeAtual = velocidadeMax;
        }

        desgastarPneus(seg/3.0f);
    }

    public void frear(int segundos){
        if (segundos < 0) return;

        if (velocidadeAtual - piloto.getHabilidade()*segundos >= 0){
            velocidadeAtual -= piloto.getHabilidade()*segundos;
        } else{
            velocidadeAtual = 0;
        }
    }

    public void derrapar(){
        frear(5);
        desgastarPneus(12.5f);
    }

    public void efetivarCurva(){
        frear(2);
        acelerar(3);
    }

    public void trocarPneus(){
        desgastePneus = 0;
    }

    @Override
    public String toString() {
        return "Kart{" +
                "velocidadeAtual=" + velocidadeAtual +
                ", velocidadeMax=" + velocidadeMax +
                ", desgastePneus=" + desgastePneus +
                '}';
    }
}
