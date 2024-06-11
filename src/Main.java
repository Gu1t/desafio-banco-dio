import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente("1234", "123456", 1000.0, "João da Silva");
        ContaPoupanca cp = new ContaPoupanca("5678", "789012", 500.0, "Maria de Souza");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Selecione a conta:");
                System.out.println("1 - Conta Corrente");
                System.out.println("2 - Conta Poupança");
                int escolhaConta = scanner.nextInt();

                Conta conta;
                if (escolhaConta == 1) {
                    conta = cc;
                } else if (escolhaConta == 2) {
                    conta = cp;
                } else {
                    System.out.println("Opção inválida.");
                    continue;
                }

                System.out.println("Selecione a operação:");
                System.out.println("1 - Saque");
                System.out.println("2 - Depósito");
                System.out.println("3 - Transferência");
                System.out.println("4 - Extrato");
                int escolhaOperacao = scanner.nextInt();

                switch (escolhaOperacao) {
                    case 1:
                        System.out.print("Digite o valor do saque: ");
                        double valorSaque = scanner.nextDouble();
                        conta.sacar(valorSaque);
                        break;
                    case 2:
                        System.out.print("Digite o valor do depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        conta.depositar(valorDeposito);
                        break;
                    case 3:
                        System.out.print("Digite o número da conta de destino: ");
                        String numeroContaDestino = scanner.next();
                        System.out.print("Digite o valor da transferência: ");
                        double valorTransferencia = scanner.nextDouble();
                        Conta destino;
                        if (numeroContaDestino.equals(cc.numeroConta)) {
                            destino = cc;
                        } else if (numeroContaDestino.equals(cp.numeroConta)) {
                            destino = cp;
                        } else {
                            System.out.println("Conta de destino não encontrada.");
                            continue;
                        }
                        conta.transferir(destino, valorTransferencia);
                        break;
                    case 4:
                        conta.extrato();
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        }
    }
}