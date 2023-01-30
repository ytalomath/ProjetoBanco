package helper;

import controller.ControllerCliente;
import javax.swing.JOptionPane;
import model.Cliente;

public class ClienteHelper {

    public static void validarEntrada(String nome, String cpf, String contato) {

        int cont = 0;
        if (nome.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Nome vazio! Preencha por favor.");
            return;

        }

        if (cpf.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo CPF vazio! Preencha por favor.");
            return;
        }

        if (contato.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Contato vazio! Preencha por favor.");
            return;
        }

        if (cont > 0) {
            JOptionPane.showMessageDialog(null, "Verifique o campo em branco e tente novamente.");
        } else {

            Cliente c1 = new Cliente(nome, cpf, contato);
            ControllerCliente.adicionarCliente(c1);
        }

    }

    public static void validarAtualizacao(String nome, String cpf, String contato) {
        int cont = 0;

        if (cpf.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo CPF vazio! Preencha por favor.");
            return;
        }

        if (nome.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Nome vazio! Preencha por favor.");
            return;

        }

        if (contato.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Contato vazio! Preencha por favor.");
            return;
        }

        if (cont > 0) {
            JOptionPane.showMessageDialog(null, "Verifique o campo em branco e tente novamente.");
        } else {

            ControllerCliente.atualizarCliente(nome, cpf, contato);
        }

    }

}
