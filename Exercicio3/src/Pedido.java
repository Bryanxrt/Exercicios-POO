import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private double total;
    private double subTotal;
    private String frete;
    private List<ItemPedido> itens;
    private List<ItemPedido> carrinho;
    private Status status;
    private ItemPedido itemSelecionado;
    private int itemQuantidade;
    private int unidades;

    public Pedido() {
        this.itemSelecionado = null;
        this.itemQuantidade = 0;
        this.itens = new ArrayList<>();
        this.carrinho = new ArrayList<>();
        this.status = Status.PREPARANDO;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public void baixaNoEstoque(ItemPedido item, int itemQuantidade){
        int estoque = item.getQuantidade();
        item.setQuantidade(estoque - itemQuantidade);
    }

    public void fecharPedido() {

        this.subTotal += itemSelecionado.getPreco() * itemQuantidade;
        this.unidades += getItemQuantidade();

        carrinho.add(new ItemPedido(
                itemSelecionado.getNome(),
                itemSelecionado.getNumeroPedido(),
                itemSelecionado.getPreco(),
                itemQuantidade)
        );

        if (subTotal >= 250.0) {
            this.frete = "GRATIS";
            this.total = subTotal;
        } else {
            this.frete = "R$ 25.0";
            this.total = subTotal + 25.0;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=============================");
        sb.append("\nCompra confirmada!");
        sb.append("\n-----------------------------");
        for (ItemPedido item : carrinho) {
            sb.append("\n- ").append(item.getNome())
                    .append(" x").append(item.getQuantidade())
                    .append(" → R$ ").append(item.getPreco() * item.getQuantidade());
        }
        sb.append("\n-----------------------------");
        sb.append("\nSubtotal: R$ ").append(subTotal);
        sb.append("\nFrete: ").append(frete);
        sb.append("\nTotal: R$ ").append(total);
        sb.append("\nStatus: ").append(status);
        sb.append("\n=============================");
        return sb.toString();
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItemSelecionado(ItemPedido itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }

    public int getItemQuantidade() {
        return itemQuantidade;
    }

    public void setItemQuantidade(int itemQuantidade) {
        this.itemQuantidade = itemQuantidade;
    }

    public List<ItemPedido> getCarrinho() {
        return carrinho;
    }
}
