import java.util.Scanner;

public class ContaBancaria {
  
    private final int numero;
    private String titular;
    private double saldo;

    public ContaBancaria(int numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo + 50;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(Scanner sc){
        System.out.println("\nValor a depositar: ");
        System.out.print("R$ ");
        double deposito = sc.nextDouble();
        if (deposito > 0){
            this.saldo += deposito;
            System.out.println("Deposito executado com sucesso!");
            System.out.println("\nSaldo: R$ " + saldo);
        } else
            System.out.println("Valor invalido!");
    }
    public int sacar(Scanner sc, int Pordia, double saque){
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
                this.saldo -= saque;
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
        return Pordia;
    }
}