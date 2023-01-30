package model;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(String titular, int numeroConta, String tipoConta, int saldo, int agencia) {
        super(titular, numeroConta, tipoConta, saldo, agencia);
        this.tipoConta = "CP";
    }

    public ContaPoupanca() {
        this.tipoConta = "CP";
    }

}
