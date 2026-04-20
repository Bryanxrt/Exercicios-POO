import Model.Caminhao;
import Model.CarroPasseio;
import Model.Veiculo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Veiculo> veiculos = new ArrayList<>();

        try {
            veiculos.add(new Caminhao("03G1-MG06", "Volvo", 220.0, 2018, 310000.0, 28));
            veiculos.add(new Caminhao("1Y34-38FV", "Volkswagen", 400.0, 2023, 390000.0, 36));

            veiculos.add(new CarroPasseio("9R25-O3F8", "Fiat", 150.0, 2016, 22000));
            veiculos.add(new CarroPasseio("46O8-36QP", "Honda", 250.0, 2020, 60000));

        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao cadastrar veículo: " + e.getMessage());
            return;
        }

        System.out.println("====== Aluguel De Veiculos ======");
        System.out.println("\nEscolha seu veiculo");

        int escolha;
        do {
            System.out.println("Deseja Caminhão ou Carro de Passeio ?");
            System.out.println("1 - Caminhão");
            System.out.println("2 - Carro");
            System.out.print("Digite aqui: ");
            try {
                escolha = sc.nextInt();
                if (escolha != 1 && escolha != 2)
                    System.out.println("Opção invalida, tente novamente\n");
            } catch (InputMismatchException e) {
                System.err.println("Erro: digite apenas números inteiros");
                return;
            }
        } while (escolha != 1 && escolha != 2);

        if (escolha == 1) {
            System.out.println("\n========= CAMINHÕES ==========");

            for (int i = 0; i < veiculos.size(); i++) {
                if (veiculos.get(i) instanceof Caminhao caminhao) {
                    caminhao.calcularIpva();
                    System.out.println(caminhao.toString(i + 1));
                }
            }
            System.out.print("\nDigite o numero do caminhão: ");
            int esc;
            try {
                esc = sc.nextInt() - 1;
            } catch (InputMismatchException e) {
                System.err.println("Erro: digite apenas números inteiros");
                return;
            }

            if (esc >= 0 && esc < veiculos.size() && veiculos.get(esc) instanceof Caminhao caminhaoEscolido) {
                try {
                    System.out.print("Digite o peso em toneladas que vai carregar: ");
                    double peso = sc.nextDouble();
                    System.out.print("Quantidade de dias: ");
                    int dias = sc.nextInt();
                    caminhaoEscolido.alugarVeiculo(peso, dias);
                    System.out.println(caminhaoEscolido);

                } catch (InputMismatchException e) {
                    System.err.println("Erro: Entrada invalida! Digite números para peso e dias");

                } catch (IllegalArgumentException e) {
                    System.err.println("Erro ao alugar caminhão: " + e.getMessage());
                }
            }

        } else {
            System.out.println("\n========= CARROS ==========");

            for (int i = 0; i < veiculos.size(); i++) {
                if (veiculos.get(i) instanceof CarroPasseio carro) {
                    carro.calcularIpva();
                    System.out.println(carro.toString(i + 1));
                }
            }
            int esc = -1;
            while (esc < 0 || esc >= veiculos.size()) {
                System.out.print("\nDigite o numero do carro: ");
                try {
                    esc = sc.nextInt() - 1;
                    if (esc < 0 || esc >= veiculos.size())
                        System.out.println("Carro não encontrado, tente novamente");
                } catch (InputMismatchException e) {
                    System.err.println("Erro: Digite apenas números inteiros");
                    sc.nextLine();
                }

                try {
                    if (esc >= 0 && esc < veiculos.size() && veiculos.get(esc) instanceof CarroPasseio carro) {
                        System.out.print("Quantidade de dias: ");
                        int dias = sc.nextInt();
                        carro.alugarVeiculo(0, dias);
                        System.out.println(carro);
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Erro: Entrada invalida! Digite um número inteiro para os dias");

                } catch (IllegalArgumentException e) {
                    System.err.println("Erro ao alugar carro: " + e.getMessage());
                }
            }
        }
        sc.close();
    }
}