public enum Status {

    PREPARANDO,
    PRONTO,
    ENVIADO;

    public record Endereco(String rua, int numero, String bairro, String cidade){}
}
