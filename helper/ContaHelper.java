package helper;

import javax.swing.JOptionPane;
import model.*;
import controller.ControllerConta;

public class ContaHelper {

    public static void validarEntrada(String titular, String numero, String tipoConta, String saldo, String idagencia) throws Exception {
        int num = 0, saldoConta = 0, agencia = 0;
        int cont = 0;

        if (titular.trim().length() == 0) {
            cont = 0;
            JOptionPane.showMessageDialog(null, "Campo Titular vazio! Preencha por favor.");
            return;

        }

        if (numero.trim().length() == 0) {
            cont = 0;
            JOptionPane.showMessageDialog(null, "Campo Numero vazio! Preencha por favor.");
            return;
        }

        if (saldo.trim().length() == 0) {
            cont = 0;
            JOptionPane.showMessageDialog(null, "Campo Deposito vazio! Preencha por favor.");
            return;
        }

        if (idagencia.trim().length() == 0) {
            cont = 0;
            JOptionPane.showMessageDialog(null, "Campo Agencia vazio! Preencha por favor.");
            return;
        }

        try {
            num = Integer.parseInt(numero);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Numero da Conta invalido!");
        }

        try {
            saldoConta = Integer.parseInt(saldo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Saldo da Conta invalido!");
        }

        try {
            agencia = Integer.parseInt(idagencia);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Agencia incorreta!");
        }

        if (cont > 0) {
            JOptionPane.showMessageDialog(null, "Verifique o campo em branco e tente novamente.");
        } else {
            if (tipoConta.equals("Conta Corrente")) {

                Conta c1 = new ContaCorrente(titular, num, tipoConta, saldoConta, agencia);
                ControllerConta.adicionarConta(c1);

            } else {

                Conta c2 = new ContaPoupanca(titular, num, tipoConta, saldoConta, agencia);
                ControllerConta.adicionarConta(c2);

            }

        }

    }

    public static void validarAtualizacao(String titular, String numero, String tipoConta, String saldo, String idagencia) {
        int num = 0, saldoConta = 0, agencia = 0;
        int cont = 0;

        if (titular.trim().length() == 0) {
            cont = 0;
            JOptionPane.showMessageDialog(null, "Campo Titular vazio! Preencha por favor.");
            return;

        }

        if (numero.trim().length() == 0) {
            cont = 0;
            JOptionPane.showMessageDialog(null, "Campo Numero vazio! Preencha por favor.");
            return;
        }

        if (saldo.trim().length() == 0) {
            cont = 0;
            JOptionPane.showMessageDialog(null, "Campo DepositoSELECT vazio! Preencha por favor.");
            return;
        }

        if (idagencia.trim().length() == 0) {
            cont = 0;
            JOptionPane.showMessageDialog(null, "Campo Agencia vazio! Preencha por favor.");
            return;
        }

        try {
            num = Integer.parseInt(numero);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Numero da Conta invalido!");
        }

        try {
            saldoConta = Integer.parseInt(saldo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Saldo da Conta invalido!");
        }

        try {
            agencia = Integer.parseInt(idagencia);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Agencia incorreta!");
        }

        if (cont > 0) {
            JOptionPane.showMessageDialog(null, "Verifique o campo em branco e tente novamente.");
        } else {
            ControllerConta.atualizarConta(num, titular, saldoConta, agencia);
        }

    }
}
