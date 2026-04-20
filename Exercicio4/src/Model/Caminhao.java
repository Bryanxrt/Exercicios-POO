package Model;

import java.time.LocalDate;

public class Caminhao extends Veiculo {
    private final double capacidadeCargaToneladas;

    public Caminhao(String placa, String marca, double valorLocacaoDiaria, int anoFabricacao, double precoFipe, double capacidadeCargaToneladas) {
        super(placa, marca, valorLocacaoDiaria, anoFabricacao, precoFipe);

        if (capacidadeCargaToneladas <= 0)
            throw new IllegalArgumentException("Capacidade de carga deve ser maior que zero");
        this.capacidadeCargaToneladas = capacidadeCargaToneladas;
    }

    @Override
    public void alugarVeiculo(double pesoCarga, int dias) {

        if (pesoCarga < 0)
            throw new IllegalArgumentException("O peso da carga não pode ser negativo");

        if (dias <= 0)
            throw new IllegalArgumentException("A quantidade de dias deve ser maior que zero");

        if (pesoCarga > capacidadeCargaToneladas) {
            this.total = valorLocacaoDiaria * dias;
            this.total += total * 0.10;
        } else
            this.total = valorLocacaoDiaria * dias;
    }

    @Override
    public void calcularIpva() {
        int idadeDoCarro = LocalDate.now().getYear() - getAnoFabricacao();
        if (idadeDoCarro > 20) {
            this.precoIpva = 0.0;
        } else
            this.precoIpva = getPrecoFipe() * 0.015;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("==============================\n");
        sb.append("\nMarca: ").append(marca);
        sb.append("\nPlaca: ").append(placa);
        sb.append("\nAno de fabricação: ").append(anoFabricacao);
        sb.append("\nPreço da tablea Fipe: R$ ").append(String.format("%.2f",precoFipe));
        sb.append("\nPreço do IPVA: R$ ").append(String.format("%.2f",precoIpva));
        sb.append("\nValor da locação diaria: R$ ").append(String.format("%.2f",valorLocacaoDiaria));
        sb.append("\nTotal: R$ ").append(total);
        return sb.toString();
    }
}