package persistencia;

import model.Agencia;

import ConexaoDAO.ConnectionDAO;
import static helper.HelperPreencherTabelas.preencherTabelaContaPorAgencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import view.VisualizarContaPorAgenciaView;

public class AgenciaDAO {

    private static VisualizarContaPorAgenciaView visualizarContaPorAgenciaView;

    //METODO PARA PESQUISAR OS DADOS DO BANCO DE DADOS
    public static void buscarAgencia() {

        //Java DataBase Connection (JDBC)
        //INSTANCIANDO O DRIVER QUE COMUNICA COM O BANCO DE DADOS COM O LAN�AMENTO DE EXCE��ES
        //CRIANDO A CONEX�O COM O BANCO DE DADOS
        Connection c = ConnectionDAO.getConnection();

        //PREPARANDO O ENVIO DO CODIGO SQL PARA EXECU��O NO BANCO DE DADOS
        PreparedStatement stmt = null;

        //PREPARANDO A CONFIRMA��O DO ENVIO DO CODIGO SQL PARA EXUCU��O NO BANCO DE DADOS
        ResultSet rs = null;

        try {
            stmt = c.prepareStatement("SELECT * FROM banco.agencia");
            rs = stmt.executeQuery();

            //System.out.println("---------------AGENCIAS NO BANCO---------------");
            //COLETANDO OS DADOS INDEPENDENTE DO TAMANHO DA TABELA, UTILIZANDO UM WHILE PARA SEMPRE QUE A PROXIMA LINHA N�O FOR VAZIA, 
            //    ELE BUSCAR AS INFORMA��ES. CONDICAO BOOLEANA
            while (rs.next()) {

                int numero = rs.getInt("NUMERO");
                String gerente = rs.getString("GERENTE");
                String local = rs.getString("LOCALIZACAO");
                String telefone = rs.getString("TELEFONE");

                //IMPRIMINDO NA TELA
                JOptionPane.showMessageDialog(null, "\nNumero: " + numero
                        + "\nGerente: " + gerente
                        + "\nLocal da Agencia: " + local
                        + "\nTelefone: " + telefone);

            }

        } catch (SQLException e) {
            //IMPRIME O ERRO NA TELA NO MOMENTO EXATO DA FALHA, SEM INTERROMPER A EXECU��O DO PROGRAMA
            e.printStackTrace();
            //BLOCO FINALLY SEMPRE � EXECUTADO, SEMPRE SER� ENCERRADA A CONEX�O ENTRE O JAVA E O BANCO DADOS FEITO PELO DRIVER   
        } finally {
            ConnectionDAO.closeConnection(c, stmt);
        }
    }

    public static void buscarAgencia(int numeroAgencia) {

        //Java DataBase Connection (JDBC)
        //INSTANCIANDO O DRIVER QUE COMUNICA COM O BANCO DE DADOS COM O LAN�AMENTO DE EXCE��ES
        //CRIANDO A CONEX�O COM O BANCO DE DADOS
        Connection c = ConnectionDAO.getConnection();

        //PREPARANDO O ENVIO DO CODIGO SQL PARA EXECU��O NO BANCO DE DADOS
        PreparedStatement stmt = null;

        //PREPARANDO A CONFIRMA��O DO ENVIO DO CODIGO SQL PARA EXUCU��O NO BANCO DE DADOS
        ResultSet rs = null;

        try {
            stmt = c.prepareStatement("SELECT * FROM banco.agencia WHERE NUMERO=" + numeroAgencia);
            rs = stmt.executeQuery();

            //System.out.println("---------------AGENCIAS NO BANCO---------------");
            //COLETANDO OS DADOS INDEPENDENTE DO TAMANHO DA TABELA, UTILIZANDO UM WHILE PARA SEMPRE QUE A PROXIMA LINHA N�O FOR VAZIA, 
            //    ELE BUSCAR AS INFORMA��ES. CONDICAO BOOLEANA
            if (rs.next()) {

                int numero = rs.getInt("NUMERO");
                String gerente = rs.getString("GERENTE");
                String local = rs.getString("LOCALIZACAO");
                String telefone = rs.getString("TELEFONE");

                //IMPRIMINDO NA TELA
                JOptionPane.showMessageDialog(null, "\nNumero: " + numero
                        + "\nGerente: " + gerente
                        + "\nLocal da Agencia: " + local
                        + "\nTelefone: " + telefone);

            } else {
                JOptionPane.showMessageDialog(null, "Agencia n�o encontrada.");
            }

        } catch (SQLException e) {
            //IMPRIME O ERRO NA TELA NO MOMENTO EXATO DA FALHA, SEM INTERROMPER A EXECU��O DO PROGRAMA
            e.printStackTrace();
            //BLOCO FINALLY SEMPRE � EXECUTADO, SEMPRE SER� ENCERRADA A CONEX�O ENTRE O JAVA E O BANCO DADOS FEITO PELO DRIVER   
        } finally {
            ConnectionDAO.closeConnection(c, stmt);
        }
    }

   /* public static void buscarAgenciaConta(int numeroAgencia) {

        //Java DataBase Connection (JDBC)
        //INSTANCIANDO O DRIVER QUE COMUNICA COM O BANCO DE DADOS COM O LAN�AMENTO DE EXCE��ES
        //CRIANDO A CONEX�O COM O BANCO DE DADOS
        Connection c = ConnectionDAO.getConnection();

        //PREPARANDO O ENVIO DO CODIGO SQL PARA EXECU��O NO BANCO DE DADOS
        PreparedStatement stmt = null;

        //PREPARANDO A CONFIRMA��O DO ENVIO DO CODIGO SQL PARA EXUCU��O NO BANCO DE DADOS
        ResultSet rs = null;

        try {
            stmt = c.prepareStatement("SELECT * FROM banco.agencia WHERE NUMERO=" + numeroAgencia);
            rs = stmt.executeQuery();

            //System.out.println("---------------AGENCIAS NO BANCO---------------");
            //COLETANDO OS DADOS INDEPENDENTE DO TAMANHO DA TABELA, UTILIZANDO UM WHILE PARA SEMPRE QUE A PROXIMA LINHA N�O FOR VAZIA, 
            //    ELE BUSCAR AS INFORMA��ES. CONDICAO BOOLEANA
            if (rs.next()) {

                int numero = rs.getInt("NUMERO");
                String gerente = rs.getString("GERENTE");
                String local = rs.getString("LOCALIZACAO");
                String telefone = rs.getString("TELEFONE");

                try {
                    preencherTabelaContaPorAgencia(numeroAgencia);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "N�o foi poss�vel preencher a tabela");
                }

                if (visualizarContaPorAgenciaView == null) {
                    visualizarContaPorAgenciaView = new VisualizarContaPorAgenciaView();

                }
                visualizarContaPorAgenciaView.setLocationRelativeTo(null);
                visualizarContaPorAgenciaView.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, " Agencia n�o existe ou n�o existe contas vinculadas a ela.");
            }

        } catch (SQLException e) {
            //IMPRIME O ERRO NA TELA NO MOMENTO EXATO DA FALHA, SEM INTERROMPER A EXECU��O DO PROGRAMA
            e.printStackTrace();
            //BLOCO FINALLY SEMPRE � EXECUTADO, SEMPRE SER� ENCERRADA A CONEX�O ENTRE O JAVA E O BANCO DADOS FEITO PELO DRIVER   
        } finally {
            ConnectionDAO.closeConnection(c, stmt);
        }

    }
*/
    public static void inserirAgencia(Agencia agencia) {

        Connection c = ConnectionDAO.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = c.prepareStatement("INSERT INTO banco.agencia (numero,gerente,localizacao,telefone)VALUES (?,?,?,?)");

            stmt.setInt(1, agencia.getNumero());
            stmt.setString(2, agencia.getGerente());
            stmt.setString(3, agencia.getLocalizacao());
            stmt.setString(4, agencia.getTelefone());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Agencia inserida com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao inserir Agencia.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Agencia j� existente com o numero informado.");
        }

    }

    public static void atualizarAgencia(int numero, String gerente, String localizacao, String telefone) {

        Connection c = ConnectionDAO.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = c.prepareStatement(" UPDATE banco.agencia SET GERENTE='" + gerente + "', LOCALIZACAO ='" + localizacao + "', TELEFONE='" + telefone + "' WHERE NUMERO =" + numero);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Agencia atualizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Agencia n�o localizada.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void deletarAgencia(int numeroConta) {

        Connection c = ConnectionDAO.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = c.prepareStatement("DELETE FROM banco.agencia WHERE NUMERO = ?");

            stmt.setInt(1, numeroConta);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Agencia removida com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Agencia n�o localizada.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Agencia n�o excluida. Agencia possui contas vinculadas a ela. Exclua as contas primeiro.");
        }

    }

}
