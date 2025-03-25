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

    public float calcularValorTotalPedido() {
        float total = 0;
        for (Cardapio item : pedidos) {
            total += item.preco;
        }
        return total;
    }

    public float calcularTaxaServico() {
        return calcularValorTotalPedido() * 0.10f;
    }

    public float calcularValorFinal() {
        float totalFinal = calcularValorTotalPedido() + calcularTaxaServico();
        return totalFinal;
    }

    @Override
    public String toString() {
        float total = calcularValorTotalPedido();
        float taxaServico = calcularTaxaServico();

        String resumo = "Pedido de " + cliente + ":\n";
        for (Cardapio item : pedidos) {
            resumo += "- " + item.nome + " | R$ " + String.format("%.2f", item.preco) + "\n";
        }
        resumo += "Subtotal: R$ " + String.format("%.2f", total) + "\n";
        resumo += "Taxa de serviço (10%): R$ " + String.format("%.2f", taxaServico) + "\n";
        resumo += "Total final: R$ " + String.format("%.2f", calcularValorFinal()) + "\n";

        return resumo;
    }
}
