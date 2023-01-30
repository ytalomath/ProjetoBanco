package helper;

import javax.swing.JOptionPane;
import model.*;
import controller.*;

public class AgenciaHelper {

    public static void validarEntrada(String numero, String gerente, String localizacao, String telefone) {
        int numeroConta = 0;
        int cont = 0;

        if (numero.trim().length() == 0) {
            cont = 0;
            JOptionPane.showMessageDialog(null, "Campo Numero vazio! Preencha por favor.");
            return;
        }

        if (gerente.trim().length() == 0) {
            cont = 0;
            JOptionPane.showMessageDialog(null, "Campo Gerente vazio! Preencha por favor.");
            return;
        }

        if (localizacao.trim().length() == 0) {
            cont = 0;
            JOptionPane.showMessageDialog(null, "Campo Localizacao vazio! Preencha por favor.");
            return;
        }

        if (telefone.trim().length() == 0) {
            cont = 0;
            JOptionPane.showMessageDialog(null, "Campo Telefone vazio! Preencha por favor.");
            return;
        }

        try {
            numeroConta = Integer.parseInt(numero);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Numero da Agencia invalido!");

        }

        if (cont > 0) {
            JOptionPane.showMessageDialog(null, "Verifique o campo em branco e tente novamente.");
        } else {

            Agencia a1 = new Agencia(numeroConta, gerente, localizacao, telefone);
            ControllerAgencia.adicionarAgencia(a1);
        }

    }

    public static void validarAtualizacao(String numeroConta, String gerente, String localizacao, String telefone) {
        int idagencia = 0;
        int cont = 0;
        int numeroContaAgencia = 0;

        if (numeroConta.trim().length() == 0) {
            cont = 0;
            JOptionPane.showMessageDialog(null, "Campo Numero vazio! Preencha por favor.");
            return;
        }

        if (gerente.trim().length() == 0) {
            cont = 0;
            JOptionPane.showMessageDialog(null, "Campo Gerente vazio! Preencha por favor.");
            return;
        }

        if (localizacao.trim().length() == 0) {
            cont = 0;
            JOptionPane.showMessageDialog(null, "Campo Localizacao vazio! Preencha por favor.");
            return;
        }

        if (telefone.trim().length() == 0) {
            cont = 0;
            JOptionPane.showMessageDialog(null, "Campo Telefone vazio! Preencha por favor.");
            return;
        }

        try {
            numeroContaAgencia = Integer.parseInt(numeroConta);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Numero da Agencia invalido!");

        }

        if (cont > 0) {
            JOptionPane.showMessageDialog(null, "Verifique o campo em branco e tente novamente.");
        } else {

            ControllerAgencia.atualizarAgencia(numeroContaAgencia, gerente, localizacao, telefone);

        }
    }

}
