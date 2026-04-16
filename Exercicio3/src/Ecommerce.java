import java.util.InputMismatchException;
import java.util.Scanner;

public class Ecommerce {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s;

        Cliente cliente1 = new Cliente("Igor", "035.651.223-48",
                new Status.Endereco("silveira", 508, "Cascatinha", "Petropolis"));

        Pedido pedido = new Pedido();
        pedido.adicionarItem(new ItemPedido("Tv 55 4k", 1, 2000, 5));
        pedido.adicionarItem(new ItemPedido("Sofá", 2, 1200, 7));
        pedido.adicionarItem(new ItemPedido("Mesa", 3, 400, 12));
        pedido.adicionarItem(new ItemPedido("Cadeira Gamer", 4, 600, 14));
        pedido.adicionarItem(new ItemPedido("Fone", 5, 80, 25));
        pedido.adicionarItem(new ItemPedido("Mouse Pad", 6, 30, 20));


        System.out.println("======= Lojas Brasil =======");

        System.out.println("\nBem vindo, " + cliente1.getNome());
        System.out.println("\nQual item deseja?");

        do {
            try {
                for (ItemPedido item : pedido.getItens()) {
                    System.out.println(item);
                }
                System.out.print("\nDigite aqui o numero do produto: ");
                int escolha = sc.nextInt();
                System.out.print("\nQuantidade: ");
                int qtd = sc.nextInt();
                System.out.println();

                boolean produtoEncontrado = false;

                for (ItemPedido item : pedido.getItens()) {
                    if (item.getNumeroPedido() == escolha) {
                        produtoEncontrado = true;
                        if (qtd > 0) {
                            if (item.getQuantidade() >= qtd) {
                                pedido.setItemSelecionado(item);
                                pedido.setItemQuantidade(qtd);
                                pedido.baixaNoEstoque(item, qtd);
                                pedido.fecharPedido();
                            } else {
                                System.out.println("Quantindade indisponível no estoque");
                            }
                            break;
                        } else
                            System.out.println("Quantidade invalida!");
                    }
                }
                if (!produtoEncontrado) {
                    System.out.println("Produto não encontrado");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite apenas números");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }

            System.out.print("Deseja escolher outro produto? (S/N): ");
            s = sc.next();

        } while ("s".equalsIgnoreCase(s));
        sc.close();

        if (!pedido.getCarrinho().isEmpty()) {
            System.out.println(pedido);
        }
        System.out.println("\nTenha um ótimo dia!");
    }
}