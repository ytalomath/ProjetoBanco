/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDAO;

import ConexaoDAO.ConnectionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author ytalo
 */
public class ContaDAOView {

    public ContaDAOView() {

    }

    public static ArrayList<Conta> listarContas() throws SQLException {

        ArrayList<Conta> listaContas = new ArrayList<>();

        Connection c = ConnectionDAO.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = c.prepareStatement("SELECT * FROM banco.conta");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Conta conta = new ContaCorrente();

                conta.setTitular(rs.getString("TITULAR"));
                conta.setNumeroConta(rs.getInt("NUMERO"));
                conta.setTipoConta(rs.getString("TIPO_CONTA"));
                conta.setSaldo(rs.getInt("SALDO"));
                conta.setAgencia(rs.getInt("NUMERO_AGENCIA"));

                listaContas.add(conta);
            }

        } catch (SQLException e) {

        } finally {
            ConnectionDAO.closeConnection(c, stmt);
        }
        return listaContas;
    }

    public static ArrayList<Conta> listarContasPorAgencia(int numeroAgencia) throws SQLException {

        ArrayList<Conta> listaContasPorAgencia = new ArrayList<>();

        Connection c = ConnectionDAO.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = c.prepareStatement("SELECT * FROM banco.conta WHERE NUMERO_AGENCIA=" + numeroAgencia+ " ORDER BY NUMERO ASC");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Conta conta = new ContaCorrente();

                conta.setTitular(rs.getString("TITULAR"));
                conta.setNumeroConta(rs.getInt("NUMERO"));
                conta.setTipoConta(rs.getString("TIPO_CONTA"));
                conta.setSaldo(rs.getInt("SALDO"));
                conta.setAgencia(rs.getInt("NUMERO_AGENCIA"));

                listaContasPorAgencia.add(conta);
            }

        } catch (SQLException e) {

        } finally {
            ConnectionDAO.closeConnection(c, stmt);
        }
        return listaContasPorAgencia;
    }
}
