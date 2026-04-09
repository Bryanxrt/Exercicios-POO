import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int menu;
        int Pordia = 3;
        double saque;
        double deposito;
        double saldo = 1200;
        char sn;

        System.out.println("== Caixa Eletrônico ==");
        do {
            System.out.println("\n1-Ver Saldo");
            System.out.println("2-Depositar");
            System.out.println("3-Sacar");
            System.out.println("0-Sair");
            System.out.print("\nO que deseja: ");
            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("\nSaldo: R$ " + saldo);
                    break;
                case 2:
                    System.out.println("\nValor a depositar: ");
                    System.out.print("R$ ");
                    deposito = sc.nextDouble();
                    saldo += deposito;
                    if (deposito > 1){
                        System.out.println("Deposito executado com sucesso!");
                        System.out.println("\nSaldo: R$ " + saldo);
                    }
                    break;
                case 3:
                    if (Pordia == 0) {
                        System.out.println("\nNão há mais saques disponiveis hoje");
                    } else do {
                        System.out.println("\nQuantide de Saques diarios: "+ Pordia);
                        System.out.println("\nSaldo: R$ " + saldo);
                        System.out.println("\nvalor de saque: ");
                        System.out.print("R$ ");
                        saque = sc.nextDouble();

                        if (saque > saldo) {
                            System.out.println("Saldo insuficiente");
                        } else if (saque > 1000) {
                            System.out.println("Saques acima de R$ 1000,00 não estão permitidos");
                        } else {
                            saldo -= saque;
                            Pordia--;
                        }

                        if (Pordia > 0) {
                            System.out.print("Deseja sacar novamente? (S/N): ");
                            String s = sc.next();
                            if (s.equalsIgnoreCase("n")) {
                                break;
                            }
                        }
                    } while (Pordia > 0);
            }

        } while (menu != 0);
        System.out.println("\nTenha um otimo dia!");
        sc.close();
    }
}