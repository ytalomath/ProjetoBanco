package controller;

import persistencia.AgenciaDAO;
import model.*;

public class ControllerAgencia {

    public static void adicionarAgencia(Agencia agencia) {
        AgenciaDAO.inserirAgencia(agencia);
    }

    public static void atualizarAgencia(int numero, String gerente, String localizacao, String telefone) {
        AgenciaDAO.atualizarAgencia(numero, gerente, localizacao, telefone);
    }

    public static void deletarAgencia(int numero) {
        AgenciaDAO.deletarAgencia(numero);
    }

    public static void buscarAgencia(int numero) {
        AgenciaDAO.buscarAgencia(numero);     
    }
    
    public static void buscarAgenciaConta(int numero) {
        AgenciaDAO.buscarAgencia(numero);
        

    }

}
