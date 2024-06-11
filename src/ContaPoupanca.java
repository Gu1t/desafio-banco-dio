public class ContaPoupanca extends Conta {
    public ContaPoupanca(String agencia, String numeroConta, double saldo, String nomeCliente) {
        super(agencia, numeroConta, saldo, nomeCliente);
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Valor inválido.");
        }
    }

    @Override
    public void transferir(Conta destino, double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            destino.depositar(valor);
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    @Override
    public void extrato() {
        System.out.println("Conta Poupança - " + nomeCliente);
        System.out.println("Agência: " + agencia);
        System.out.println("Número da Conta: " + numeroConta);
        System.out.println("Saldo: R$ " + saldo);
    }
}