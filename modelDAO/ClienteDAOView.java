package modelDAO;

import ConexaoDAO.ConnectionDAO;
import model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDAOView {

    public ClienteDAOView() {

    }

    public static ArrayList<Cliente> listarClientes() throws SQLException {

        ArrayList<Cliente> listaClientes = new ArrayList<>();

        Connection c = ConnectionDAO.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = c.prepareStatement("SELECT * FROM banco.cliente ORDER BY NOME ASC");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setNome(rs.getString("NOME"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setContato(rs.getString("CONTATO"));

                listaClientes.add(cliente);

            }

        } catch (SQLException e) {

        } finally {
            ConnectionDAO.closeConnection(c, stmt);
        }
        return listaClientes;
    }

}
