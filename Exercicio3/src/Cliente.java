public class Cliente  {
    private String nome;
    private final String cpf;
    private Status.Endereco endereco;


    public Cliente(String nome, String cpf, Status.Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "\nCliente: " + nome +
                "\nEndereço: " + endereco;
    }

    public String getNome() {
        return nome;
    }
}
