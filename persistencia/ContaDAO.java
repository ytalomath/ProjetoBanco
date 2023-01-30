package persistencia;

import model.*;
import ConexaoDAO.ConnectionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ContaDAO {

    /*public static void main(String[] args) {

        //Conta c1 = new ContaCorrente("Jose Silva",123,"CC",50,201);
        //inserirConta(c1);
        //System.out.println("");
        buscarConta();

    }*/
    //METODO PARA PESQUISAR OS DADOS DO BANCO DE DADOS
    public static void buscarConta() {

        //Java DataBase Connection (JDBC)
        //INSTANCIANDO O DRIVER QUE COMUNICA COM O BANCO DE DADOS COM O LANÇAMENTO DE EXCEÇÕES
        //CRIANDO A CONEXÃO COM O BANCO DE DADOS
        Connection c = ConnectionDAO.getConnection();

        //PREPARANDO O ENVIO DO CODIGO SQL PARA EXECUÇÃO NO BANCO DE DADOS
        PreparedStatement stmt = null;

        //PREPARANDO A CONFIRMAÇÃO DO ENVIO DO CODIGO SQL PARA EXUCUÇÃO NO BANCO DE DADOS
        ResultSet rs = null;

        try {
            stmt = c.prepareStatement("SELECT * FROM banco.conta");
            rs = stmt.executeQuery();

            //JOptionPane.showMessageDialog(null,"---------------CONTAS NO BANCO---------------");
            //COLETANDO OS DADOS INDEPENDENTE DO TAMANHO DA TABELA, UTILIZANDO UM WHILE PARA SEMPRE QUE A PROXIMA LINHA NÃO FOR VAZIA, 
            //    ELE BUSCAR AS INFORMAÇÕES. CONDICAO BOOLEANA
            while (rs.next()) {

                String titular = rs.getString("TITULAR");
                int numero = rs.getInt("NUMERO");
                String tipoConta = rs.getString("TIPO_CONTA");
                int saldo = rs.getInt("SALDO");
                int agencia = rs.getInt("NUMERO_AGENCIA");

                //IMPRIMINDO NA TELA
                JOptionPane.showMessageDialog(null, "Titular: " + titular
                        + " \nNumero da Conta: " + numero
                        + "\nTipo da Conta: " + tipoConta
                        + "\nSaldo: " + saldo
                        + "\nAgencia Vinculada: " + agencia);
                /*
                JOptionPane.showMessageDialog(null,"Titular: " + titular);
                JOptionPane.showMessageDialog("Agencia: " + agencia);
                System.out.println("Numero: " + numero);
                System.out.println("Saldo: " + saldo);
                System.out.println("");
                 */
            }

        } catch (SQLException e) {
            //IMPRIME O ERRO NA TELA NO MOMENTO EXATO DA FALHA, SEM INTERROMPER A EXECUÇÃO DO PROGRAMA
            e.printStackTrace();
            //BLOCO FINALLY SEMPRE É EXECUTADO, SEMPRE SERÁ ENCERRADA A CONEXÃO ENTRE O JAVA E O BANCO DADOS FEITO PELO DRIVER   
        } finally {
            ConnectionDAO.closeConnection(c, stmt);
        }
    }

    public static void buscarConta(int numeroConta) {

        //Java DataBase Connection (JDBC)
        //INSTANCIANDO O DRIVER QUE COMUNICA COM O BANCO DE DADOS COM O LANÇAMENTO DE EXCEÇÕES
        //CRIANDO A CONEXÃO COM O BANCO DE DADOS
        Connection c = ConnectionDAO.getConnection();

        //PREPARANDO O ENVIO DO CODIGO SQL PARA EXECUÇÃO NO BANCO DE DADOS
        PreparedStatement stmt = null;

        //PREPARANDO A CONFIRMAÇÃO DO ENVIO DO CODIGO SQL PARA EXUCUÇÃO NO BANCO DE DADOS
        ResultSet rs = null;

        try {
            stmt = c.prepareStatement("SELECT * FROM banco.conta WHERE NUMERO =" + numeroConta);
            rs = stmt.executeQuery();

            //JOptionPane.showMessageDialog(null,"---------------CONTAS NO BANCO---------------");
            //COLETANDO OS DADOS INDEPENDENTE DO TAMANHO DA TABELA, UTILIZANDO UM WHILE PARA SEMPRE QUE A PROXIMA LINHA NÃO FOR VAZIA, 
            //    ELE BUSCAR AS INFORMAÇÕES. CONDICAO BOOLEANA
            if (rs.next()) {

                int id = rs.getInt("IDCONTA");
                String titular = rs.getString("TITULAR");
                int numero = rs.getInt("NUMERO");
                String tipoConta = rs.getString("TIPO_CONTA");
                int saldo = rs.getInt("SALDO");
                int agencia = rs.getInt("NUMERO_AGENCIA");

                //IMPRIMINDO NA TELA
                JOptionPane.showMessageDialog(null, "ID Conta: " + id
                        + " \nTitular: " + titular
                        + " \nNumero da Conta: " + numero
                        + "\nTipo da Conta: " + tipoConta
                        + "\nSaldo: " + saldo
                        + "\nAgencia Vinculada: " + agencia);
            } else {
                JOptionPane.showMessageDialog(null, " Conta não localizada.");
            }

        } catch (SQLException e) {
            //IMPRIME O ERRO NA TELA NO MOMENTO EXATO DA FALHA, SEM INTERROMPER A EXECUÇÃO DO PROGRAMA
            e.printStackTrace();
            //BLOCO FINALLY SEMPRE É EXECUTADO, SEMPRE SERÁ ENCERRADA A CONEXÃO ENTRE O JAVA E O BANCO DADOS FEITO PELO DRIVER   
        } finally {
            ConnectionDAO.closeConnection(c, stmt);
        }
    }

    public static void inserirConta(Conta conta) throws Exception {

        Connection c = ConnectionDAO.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = c.prepareStatement("INSERT INTO banco.conta (titular,numero,tipo_conta,saldo,numero_agencia)VALUES (?,?,?,?,?)");

            stmt.setString(1, conta.getTitular());
            stmt.setInt(2, conta.getNumeroConta());
            stmt.setString(3, conta.getTipoConta());
            stmt.setDouble(4, conta.getSaldo());
            stmt.setInt(5, conta.getAgencia());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Conta inserida com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao inserir dados!");
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Conta já existente com o numero informado ou Cliente/Agencia não existente. Favor alterar. ");

        }
    }

    public static void atualizarConta(int numeroConta, String titular, int saldo, int numeroAgencia) {

        Connection c = ConnectionDAO.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = c.prepareStatement(" UPDATE banco.conta SET TITULAR ='" + titular + "',SALDO=" + saldo + ", NUMERO_AGENCIA=" + numeroAgencia + " WHERE NUMERO =" + numeroConta);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Conta atualizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar conta. Conta inexistente no banco");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Novo cliente ou agencia inexistentes no banco. ");
        }

    }

    public static void deletarConta(int numero) {

        Connection c = ConnectionDAO.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = c.prepareStatement("DELETE FROM banco.conta WHERE NUMERO = ?");

            stmt.setInt(1, numero);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Conta removida com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Conta não localizada.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
