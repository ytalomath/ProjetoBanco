package controller;

import persistencia.ContaDAO;
import model.*;

public class ControllerConta {

    public static void adicionarConta(Conta conta) throws Exception {
        ContaDAO.inserirConta(conta);

    }

    public static void atualizarConta(int numeroConta, String titular, int saldo, int agencia) {
        ContaDAO.atualizarConta(numeroConta, titular, saldo, agencia);
    }

    public static void buscarConta(int numero) {
        ContaDAO.buscarConta(numero);
    }

    public static void deletarConta(int numero) {
        ContaDAO.deletarConta(numero);
    }

}
