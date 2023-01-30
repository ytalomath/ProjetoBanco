package model;

public abstract class Conta {

    //ATRIBUTOS DA CLASSE CONTA COM O RESPECTIVO MODIFICAR DE ACESSO
    protected int agencia;
    protected int numeroConta;
    protected double saldo;
    protected String titular;
    protected String tipoConta;

    // METODO CONSTRUTOR RECEBENDO OS ATRIBUTOS;
    public Conta(String titular, int numeroConta, String tipoConta, int saldo, int agencia) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;

    }

    //METODO CONSTRUTOR VAZIO 
    public Conta() {

    }

    //METODO PARA DEPOSITAR NA CONTA POUPANÇA
    public double depositar(double valor) {
        this.saldo += valor;
        return saldo;
    }

    //METODO PARA SACAR DA CONTA POUPANÇA
    public String sacar(double valor) {
        if (valor < this.saldo) {
            this.saldo -= valor;
            return "Operacao concluida com sucesso! \nNovo saldo: " + saldo;

        }
        return "Saldo insuficiente para sacar!\nSaldo atual: " + saldo;
    }

    //METODO PARA TRANSFERIR DA CONTA CORRENTE
    public boolean transferir(double valor, Conta destino) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public boolean Persistir() {
        return true;
    }

}
