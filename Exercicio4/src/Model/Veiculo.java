package Model;

import Interfaces.Fretavel;
import Interfaces.Tributavel;

import java.time.LocalDate;

public abstract class Veiculo implements Fretavel, Tributavel {
    protected final String placa;
    protected final String marca;
    protected double valorLocacaoDiaria;
    protected final int anoFabricacao;
    protected double total;
    protected double precoFipe;
    protected double precoIpva;

    public Veiculo(String placa, String marca, double valorLocacaoDiaria,
                   int anoFabricacao, double precoFipe) {
        this.placa = placa;
        this.marca = marca;
        this.valorLocacaoDiaria = valorLocacaoDiaria;
        this.anoFabricacao = anoFabricacao;
        this.precoFipe = precoFipe;

        if (placa == null || placa.isBlank())
            throw new IllegalArgumentException("Placa não pode ser vazia");

        if (marca == null || marca.isBlank())
            throw new IllegalArgumentException("Marca não pode ser vazia");

        if (valorLocacaoDiaria <= 0)
            throw new IllegalArgumentException("O valor de locação diaria deve ser maior que zero");

        if (anoFabricacao > LocalDate.now().getYear())
            throw new IllegalArgumentException("Ano de fabricação inválido: " + anoFabricacao);

        if (precoFipe <= 0)
            throw new IllegalArgumentException("Preço Fipe deve ser maior que zero");
    }

    public String toString(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append("==============================\n");
        sb.append(num).append(" -");
        sb.append("\nMarca: ").append(marca);
        sb.append("\nPlaca: ").append(placa);
        sb.append("\nAno de fabricação: ").append(anoFabricacao);
        sb.append("\nPreço da tablea Fipe: R$ ").append(String.format("%.2f",precoFipe));
        sb.append("\nPreço do IPVA: R$ ").append(String.format("%.2f",precoIpva));
        sb.append("\nValor da locação diaria: R$ ").append(String.format("%.2f",valorLocacaoDiaria));
        return sb.toString();
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public double getPrecoFipe() {
        return precoFipe;
    }
}