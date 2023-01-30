package persistencia;

import model.*;
import ConexaoDAO.ConnectionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ClienteDAO {

    //METODO PARA PESQUISAR OS DADOS DO BANCO DE DADOS
    public static void buscarCliente() {

        //Java DataBase Connection (JDBC)
        //INSTANCIANDO O DRIVER QUE COMUNICA COM O BANCO DE DADOS COM O LANÇAMENTO DE EXCEÇÕES
        //CRIANDO A CONEXÃO COM O BANCO DE DADOS
        Connection c = ConnectionDAO.getConnection();

        //PREPARANDO O ENVIO DO CODIGO SQL PARA EXECUÇÃO NO BANCO DE DADOS
        PreparedStatement stmt = null;

        //PREPARANDO A CONFIRMAÇÃO DO ENVIO DO CODIGO SQL PARA EXUCUÇÃO NO BANCO DE DADOS
        ResultSet rs = null;

        try {
            stmt = c.prepareStatement("SELECT * FROM banco.cliente");
            rs = stmt.executeQuery();

            //JOptionPane.showMessageDialog(null,"---------------CONTAS NO BANCO---------------");
            //COLETANDO OS DADOS INDEPENDENTE DO TAMANHO DA TABELA, UTILIZANDO UM WHILE PARA SEMPRE QUE A PROXIMA LINHA NÃO FOR VAZIA, 
            //    ELE BUSCAR AS INFORMAÇÕES. CONDICAO BOOLEANA
            while (rs.next()) {

                String nome = rs.getString("NOME");
                String cpf = rs.getString("CPF");
                String contato = rs.getString("CONTATO");

                //IMPRIMINDO NA TELA
                JOptionPane.showMessageDialog(null, "Nome: " + nome
                        + " \nCPF: " + cpf
                        + "\nContato: " + contato);

            }

        } catch (SQLException e) {
            //IMPRIME O ERRO NA TELA NO MOMENTO EXATO DA FALHA, SEM INTERROMPER A EXECUÇÃO DO PROGRAMA
            e.printStackTrace();
            //BLOCO FINALLY SEMPRE É EXECUTADO, SEMPRE SERÁ ENCERRADA A CONEXÃO ENTRE O JAVA E O BANCO DADOS FEITO PELO DRIVER   
        } finally {
            ConnectionDAO.closeConnection(c, stmt);
        }
    }

    public static void buscarCliente(String cpf) {

        //Java DataBase Connection (JDBC)
        //INSTANCIANDO O DRIVER QUE COMUNICA COM O BANCO DE DADOS COM O LANÇAMENTO DE EXCEÇÕES
        //CRIANDO A CONEXÃO COM O BANCO DE DADOS
        Connection c = ConnectionDAO.getConnection();

        //PREPARANDO O ENVIO DO CODIGO SQL PARA EXECUÇÃO NO BANCO DE DADOS
        PreparedStatement stmt = null;

        //PREPARANDO A CONFIRMAÇÃO DO ENVIO DO CODIGO SQL PARA EXUCUÇÃO NO BANCO DE DADOS
        ResultSet rs = null;

        try {
            stmt = c.prepareStatement("SELECT * FROM banco.cliente WHERE CPF ='" + cpf + "'");
            rs = stmt.executeQuery();

            //JOptionPane.showMessageDialog(null,"---------------CONTAS NO BANCO---------------");
            //COLETANDO OS DADOS INDEPENDENTE DO TAMANHO DA TABELA, UTILIZANDO UM WHILE PARA SEMPRE QUE A PROXIMA LINHA NÃO FOR VAZIA, 
            //    ELE BUSCAR AS INFORMAÇÕES. CONDICAO BOOLEANA
            if (rs.next()) {

                String nome = rs.getString("NOME");
                String cpfTitular = rs.getString("CPF");
                String contato = rs.getString("CONTATO");

                //IMPRIMINDO NA TELA
                JOptionPane.showMessageDialog(null, "Nome: " + nome
                        + " \nCPF: " + cpfTitular
                        + "\nContato: " + contato);
            } else {
                 JOptionPane.showMessageDialog(null," Cliente não localizado.");
            }

        } catch (SQLException e) {
            //IMPRIME O ERRO NA TELA NO MOMENTO EXATO DA FALHA, SEM INTERROMPER A EXECUÇÃO DO PROGRAMA
            e.printStackTrace();
            //BLOCO FINALLY SEMPRE É EXECUTADO, SEMPRE SERÁ ENCERRADA A CONEXÃO ENTRE O JAVA E O BANCO DADOS FEITO PELO DRIVER   
        } finally {
            ConnectionDAO.closeConnection(c, stmt);
        }
    }

    public static void inserirCliente(Cliente cliente) {

        Connection c = ConnectionDAO.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = c.prepareStatement("INSERT INTO banco.cliente (nome,cpf,contato)VALUES (?,?,?)");

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getContato());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao inserir dados!");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "CPF já existente no banco!");
        }

    }

    public static void atualizarCliente(String nome, String cpf, String contato) {

        Connection c = ConnectionDAO.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = c.prepareStatement(" UPDATE banco.cliente SET NOME ='" + nome + "', CONTATO='" + contato + "'WHERE CPF=" + cpf);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");

            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente. Cliente inexistente no banco ou CPF incorreto.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void deletarCliente(String cpf) {

        Connection c = ConnectionDAO.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = c.prepareStatement("DELETE FROM banco.cliente WHERE CPF = ?");

            stmt.setString(1, cpf);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "CPF não localizado. ");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cliente não removido do banco. Cliente vinculado a uma conta. Exclua a conta primeiro!");
        }

    }

}
