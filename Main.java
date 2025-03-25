import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int resp = 1;
        Scanner teclado = new Scanner(System.in);
        ArrayList<Cardapio> menu = Cardapio.gerarCardapio();

        while (resp != 0) {
            System.out.println("Bem-vindo ao sistema de pedidos Japa! >:)");
            System.out.println("1 - Fazer pedido.");
            System.out.println("0 - Sair.");
            resp = teclado.nextInt();
            teclado.nextLine();
            if (resp == 0) {
                break;
            }
            System.out.println("Legal! Digite seu nome: ");
            String cliente = teclado.nextLine();

            int respCardapio = 1;
            Pedido pedido = new Pedido(cliente);

            while (respCardapio != 0) {
                System.out.println("Digite o número do item que deseja pedir (0 para sair): ");

                for (Cardapio item : menu) {
                    System.out.println(item.id + " - " + item.nome + " | R$ " + item.preco);
                }

                respCardapio = teclado.nextInt();
                teclado.nextLine();

                if (respCardapio > 0 && respCardapio <= menu.size()) {
                    pedido.adicionarPedido(menu.get(respCardapio - 1)); // Adiciona o item escolhido
                    System.out.println("Pedido adicionado ao carrinho!");
                } else if (respCardapio != 0) {
                    System.out.println("Item não encontrado.");
                } else {
                    break;
                }
            }
            System.out.println(pedido);

            System.out.println("Digite o valor que deseja pagar: ");
            float valorPago = teclado.nextFloat();

            if (valorPago < pedido.calcularTotal()) {
                System.out.println("Valor insuficiente. Pedido cancelado.");
            } else {
                float troco = valorPago - pedido.calcularTotal();
                System.out.println("Troco: R$ " + String.format("%.2f", troco));
            }

        }
        System.out.println("Obrigado e volte sempre! :D");
        teclado.close();
    }
}