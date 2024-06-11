public abstract class Conta {
    protected String agencia;
    protected String numeroConta;
    protected double saldo;
    protected String nomeCliente;

    public Conta(String agencia, String numeroConta, double saldo, String nomeCliente) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.nomeCliente = nomeCliente;
    }

    public abstract void sacar(double valor);
    public abstract void depositar(double valor);
    public abstract void transferir(Conta destino, double valor);
    public abstract void extrato();
}