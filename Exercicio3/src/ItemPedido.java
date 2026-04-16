public class ItemPedido {
    private String nome;
    private int numeroPedido;
    private double preco;
    private int quantidade;


    public ItemPedido(String nome, int numeroPedido, double preco, int quantidade) {
        this.nome = nome;
        this.numeroPedido = numeroPedido;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "=========================" +
                "\nNome: " + nome +
                "\nNumero: " + numeroPedido +
                "\nPreço: R$" + preco +
                "\nQuantidade em estoque: " + quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
