package modelo;

public class Item {
    private String nome;
    private int quant;
    private int poder;

    public Item(String nome, int quant, int poder){
        if(nome != null && quant >= 0 && poder >= 1){
            this.nome = nome;
            this.quant = quant;
            this.poder = poder;
        }
    }

    public void reabastecer(int qtd){
        quant += qtd;
    }

    public int serUsado(){
        if(quant >= 1){
            quant--;
            return poder;
        }
        return 0;
    }

    public String getNome(){
        return nome;
    }


    public int getQuant(){
        return quant;
    }

    public int getPoder(){
        return poder;
    }
}
