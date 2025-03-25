import java.util.ArrayList;

public class Cardapio {
    int id;
    String nome;
    Float preco;
    
    public Cardapio(int id, String nome, Float preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }
    
    public static ArrayList<Cardapio> gerarCardapio() {
        ArrayList<Cardapio> cardapio = new ArrayList<>();

        cardapio.add(new Cardapio(1, "Temaki Filadelphia", 30.0f));
        cardapio.add(new Cardapio(2, "Uramaki Filadelphia", 25.0f));
        cardapio.add(new Cardapio(3, "Sashimi de Salmão", 20.0f));
        cardapio.add(new Cardapio(4, "Yakisoba", 40.0f));
        cardapio.add(new Cardapio(5, "Coca-cola 350ml", 5.9f));
        cardapio.add(new Cardapio(6, "Coca-cola 0 350ml", 5.9f));

        return cardapio;
    }
   
    @Override
    public String toString() {
        return id + " - " + nome + " | R$ " + String.format("%.2f", preco) + " | ";
    }

}
