package model;

public class Agencia {

    private int id_agencia;
    private int numero;
    private String gerente;
    private String localizacao;
    private String telefone;

    public Agencia(int numero, String gerente, String localizacao, String telefone) {

        this.numero = numero;
        this.gerente = gerente;
        this.localizacao = localizacao;
        this.telefone = telefone;
    }

    public Agencia(int id_agencia, int numero, String gerente, String localizacao, String telefone) {
        this.id_agencia = id_agencia;
        this.numero = numero;
        this.gerente = gerente;
        this.localizacao = localizacao;
        this.telefone = telefone;
    }

    public Agencia() {

    }

    public int getId_agencia() {
        return id_agencia;
    }

    public void setId_agencia(int id_agencia) {
        this.id_agencia = id_agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
