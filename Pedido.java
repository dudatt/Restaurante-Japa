import java.util.ArrayList;

public class Pedido {
    String cliente;
    ArrayList<Cardapio> pedidos;

    public Pedido(String cliente) {
        this.cliente = cliente;
        this.pedidos = new ArrayList<>();
    }

    public void adicionarPedido(Cardapio item) {
        this.pedidos.add(item);
    }

    public float calcularTotal() {
        float total = 0;
        for (Cardapio item : pedidos) {
            total += item.preco;
        }
        return total;
    }

    public float calcularTaxaServico() {
        return calcularTotal() * 0.10f; // 10% de taxa de serviço
    }

    @Override
    public String toString() {
        float total = calcularTotal();
        float taxaServico = calcularTaxaServico();
        float totalFinal = total + taxaServico;

        String resumo = "Pedido de " + cliente + ":\n";
        for (Cardapio item : pedidos) {
            resumo += "- " + item.nome + " | R$ " + String.format("%.2f", item.preco) + "\n";
        }
        resumo += "Subtotal: R$ " + String.format("%.2f", total) + "\n";
        resumo += "Taxa de serviço (10%): R$ " + String.format("%.2f", taxaServico) + "\n";
        resumo += "Total final: R$ " + String.format("%.2f", totalFinal);

        return resumo;
    }
}
