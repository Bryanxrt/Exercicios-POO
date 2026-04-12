import java.util.Scanner;

public class CaixaEletronico {
    public static void main(String[] args) {

        int menu;
        double saque = 0;
        int Pordia = 3;

        Scanner sc = new Scanner(System.in);

        ContaBancaria conta = new ContaBancaria(8549735, "Igor", 2000);

        System.out.println("== Caixa_Eletrônico Eletrônico ==");

        System.out.println("\nNumero: " + conta.getNumero());
        System.out.println("Titular: " + conta.getTitular());

        System.out.println("\nBonus de boas vindas R$ 50,00");

        do {
            System.out.println("\n1-Ver Saldo");
            System.out.println("2-Depositar");
            System.out.println("3-Sacar");
            System.out.println("0-Sair");
            System.out.print("\nO que deseja: ");
            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("\nSaldo: R$ " + conta.getSaldo());
                    break;
                case 2:
                    conta.depositar(sc);
                    break;
                case 3:
                    Pordia = conta.sacar(sc, Pordia, saque);
                    break;
            }

        }while (menu != 0) ;
        System.out.println("\nTenha um otimo dia, "+ conta.getTitular() + "!");
    }
}