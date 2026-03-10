package modelo;

public class Piloto {
    private String nome;
    private int habilidade;
    private int moedas;
    private Kart kart;
    private Item[] itensCol;

    public Piloto(String nome, int habilidade) {
        if (nome != null && habilidade >=0 && habilidade <= 100){
            this.nome = nome;
            this.habilidade = habilidade;
            this.moedas = 0;
            this.itensCol = new Item[4];
        }
    }

    public void setKart(Kart kart) {
        this.kart = kart;
    }

    public Kart getKart() {
        return kart;
    }

    public void coletarItem(Item item){
        int igual=0;
        for(int i=0; i<4; i++){
            if(itensCol[i] != null && itensCol[i].getNome().equals(item.getNome())){
                itensCol[i].reabastecer(item.getQuant());;
                igual++;
                break;
            }
        }
        if(igual == 0){
            for (int i = 0; i < 4; i++) {
                if (itensCol[i] == null) {
                    itensCol[i] = item;
                    break;
                }
            }    
        }
    } 

    public int gastarItem(String nome){
        for(int i=0; i<4; i++){
            if(itensCol[i] != null && itensCol[i].getNome().equals(nome)){
                int usado = itensCol[i].serUsado();
                if(itensCol[i].getQuant() == 0){
                    for (int j = i; j < 3; j++) {
                        itensCol[j] = itensCol[j + 1];
                    }
                    itensCol[3] = null;
                }
                return usado;
            }
        }
        return 0;
    }

    public void usarItem(String nome){
        for(int i=0; i<4; i++){
            if(itensCol[i] != null && itensCol[i].getNome().equals(nome)){
                int poder = itensCol[i].getPoder();
                gastarItem(nome);

                if(nome.equalsIgnoreCase("Cogumelo")){
                    kart.setVelocidadeAtual(kart.getVelocidadeAtual() + poder*habilidade);
                }

                if(nome.equalsIgnoreCase("Estrela")){
                    habilidade += poder;
                }

                if(nome.equalsIgnoreCase("Casco")){
                    perderMoedas(poder);
                    habilidade = 1;
                }

                if(nome.equalsIgnoreCase("Banana")){
                    kart.derrapar();
                }

                break;
            }
        }
    }

    public void usarItem(String nome, Piloto adversario){
        for(int i=0; i<4; i++){
            if(itensCol[i] != null && itensCol[i].getNome().equals(nome)){
                int poder = itensCol[i].getPoder();
                gastarItem(nome);

                if(nome.equalsIgnoreCase("Cogumelo")){
                    adversario.getKart().setVelocidadeAtual(adversario.getKart().getVelocidadeAtual() + poder*adversario.getHabilidade());
                }

                if(nome.equalsIgnoreCase("Estrela")){
                    adversario.setHabilidade(adversario.getHabilidade() + poder);
                } 

                if(nome.equalsIgnoreCase("Casco")){
                    adversario.perderMoedas(poder);
                    adversario.setHabilidade(1);
                }

                if(nome.equalsIgnoreCase("Banana")){
                    adversario.getKart().derrapar();
                }

                break;
            }
        }
    }

    public int getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(int num){
        if(num<0){
            habilidade = 0;
        }
        else if(num >=0 && num <= 100){
            habilidade = num; 
        }
        else{
            habilidade = 100;
        }
    }

    public void coletarMoedas(int quant){
        if (quant > 0){
            moedas += quant;
        }
    }

    public void perderMoedas(int qtd){
        if (qtd > 0 && (moedas - qtd >= 0)){
            moedas -= qtd;
        } else{
	        moedas = 0;
	    }
    }

    public void fazerCurva(int grauCurva){
        if (grauCurva > habilidade){
            kart.derrapar();
            perderMoedas(grauCurva - habilidade);
        } else{
            kart.efetivarCurva();
        }
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "nome='" + nome + '\'' +
                ", habilidade=" + habilidade +
                ", moedas=" + moedas +
                '}';
    }
}
