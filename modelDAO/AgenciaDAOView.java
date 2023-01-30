package modelDAO;

import ConexaoDAO.ConnectionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Agencia;

public class AgenciaDAOView {

    public AgenciaDAOView() {

    }

    public static ArrayList<Agencia> listarAgencias() throws SQLException {

        ArrayList<Agencia> listaAgencias = new ArrayList<>();

        Connection c = ConnectionDAO.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = c.prepareStatement("SELECT * FROM banco.agencia");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Agencia agencia = new Agencia();

                agencia.setNumero(rs.getInt("NUMERO"));
                agencia.setGerente(rs.getString("GERENTE"));
                agencia.setLocalizacao(rs.getString("LOCALIZACAO"));
                agencia.setTelefone(rs.getString("TELEFONE"));

                listaAgencias.add(agencia);

            }

        } catch (SQLException e) {

        } finally {
            ConnectionDAO.closeConnection(c, stmt);
        }
        return listaAgencias;
    }

}
