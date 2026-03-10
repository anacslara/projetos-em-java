import modelo.Item;
import modelo.Kart;
import modelo.Piloto;

public class Main {
    public static void main(String[] args) {

        Piloto mario = new Piloto("Mario", 43);
        Piloto luigi = new Piloto("Luigi", 50);

        Kart carro1 = new Kart(180, mario);
        Kart carro2 = new Kart(170, luigi);

        mario.setKart(carro1);
        luigi.setKart(carro2);

        System.out.println(mario);
        System.out.println(carro1);
        System.out.println(luigi);
        System.out.println(carro2);

        mario.coletarMoedas(50);
        carro1.acelerar(4);
        mario.fazerCurva(90);
        System.out.println(mario);
        System.out.println(carro1);

        Item cogumelo = new Item("Cogumelo", 2, 10);
        Item estrela = new Item("Estrela", 1, 5);
        Item casco = new Item("Casco", 1, 20);
        Item banana = new Item("Banana", 1, 0);

        mario.coletarItem(cogumelo);
        mario.coletarItem(estrela);
        mario.coletarItem(casco);
        mario.coletarItem(banana);

        mario.usarItem("Cogumelo");
        System.out.println(mario);
        System.out.println(carro1);

        mario.usarItem("Casco", luigi);
        System.out.println(luigi);
        System.out.println(carro2);

    }
}
