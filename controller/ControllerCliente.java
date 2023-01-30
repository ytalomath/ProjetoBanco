package controller;

import persistencia.ClienteDAO;
import model.*;

public class ControllerCliente {

    public static void adicionarCliente(Cliente cliente) {
        ClienteDAO.inserirCliente(cliente);
    }

    public static void atualizarCliente(String nome, String cpf, String contato) {
        ClienteDAO.atualizarCliente(nome, cpf, contato);
    }

    public static void buscarCliente(String cpf) {
        ClienteDAO.buscarCliente(cpf);
    }

    public static void deletarCliente(String cpf) {
        ClienteDAO.deletarCliente(cpf);
    }
    /*
    public static void visualizarClientes() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (visualizarCliente2 == null) {
                    visualizarCliente2 = new VisualizarClienteView1(null, true);

                }
                visualizarCliente2.setVisible(true);

                try {
                    preencherTabela();
                } catch (SQLException ex) {
                    Logger.getLogger(VisualizarClienteView1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
     */
}
