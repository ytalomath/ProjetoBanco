package model;

public class ContaCorrente extends Conta {

    public ContaCorrente(String titular, int numeroConta, String tipoConta, int saldo, int agencia) {
        super(titular, numeroConta, tipoConta, saldo, agencia);
        this.tipoConta = "CC";
    }

    public ContaCorrente(String titular, int numeroConta, int saldo, int agencia) {
        this.tipoConta = "CC";
    }

    public ContaCorrente() {
        this.tipoConta = "CC";
    }

}
