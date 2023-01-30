/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import modelDAO.AgenciaDAOView;
import modelDAO.ClienteDAOView;
import modelDAO.ContaDAOView;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Agencia;
import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import static view.EditarAgencia.tblTabelaEditarAgencia;
import static view.EditarConta.*;
import static view.EditarCliente.tblTabelaCliente;

/**
 *
 * @author ytalo
 */
import static view.ExcluirAgencia.tblExcluirAgencia;
import static view.ExcluirCliente.tblExcluirCliente;
import view.VisualizarAgencia;
import static view.VisualizarAgenciaView.tblTabelaAgencia;
import static view.VisualizarClienteView.tblTabelaClienteView;
import static view.VisualizarContaPorAgenciaView.tblTabelaContasPorAgencia;
import static view.VisualizarContaView.tblTabelaContas;

public class HelperPreencherTabelas {

    /*
        METODOS PARA PREENCHER A TABELA DAS CLASSES EDITAR INDIVIDUALMENTE
     */
    //METODO DA TABELA EDITAR AGENCIA
    public static void preencherEditarAgencia() throws SQLException {

        DefaultTableModel model = (DefaultTableModel) tblTabelaEditarAgencia.getModel();
        model.setNumRows(0);

        Object colunas[] = new Object[4];
        Agencia agencia = new Agencia();

        ArrayList<Agencia> listaAgencias = new ArrayList<Agencia>();

        listaAgencias = AgenciaDAOView.listarAgencias();

        for (int i = 0; i < listaAgencias.size(); i++) {

            agencia = listaAgencias.get(i);

            colunas[0] = agencia.getNumero();
            colunas[1] = agencia.getGerente();
            colunas[2] = agencia.getLocalizacao();
            colunas[3] = agencia.getTelefone();

            model.addRow(colunas);
        }
    }

    //METODO DA TABELA EDITAR CLIENTE
    public static void preencherEditarCliente() throws SQLException {

        DefaultTableModel model = (DefaultTableModel) tblTabelaCliente.getModel();
        model.setNumRows(0);

        Object colunas[] = new Object[3];
        Cliente cliente = new Cliente();

        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

        listaClientes = ClienteDAOView.listarClientes();

        for (int i = 0; i < listaClientes.size(); i++) {

            cliente = listaClientes.get(i);
            colunas[0] = cliente.getNome();
            colunas[1] = cliente.getCpf();
            colunas[2] = cliente.getContato();

            model.addRow(colunas);
        }
    }

    //METODO DA TABELA CONTA NO EDITAR CONTA
    public static void preencherEditarConta() throws SQLException {

        DefaultTableModel model = (DefaultTableModel) tblTabelaEditarConta.getModel();
        model.setNumRows(0);

        Object colunas[] = new Object[5];
        Conta conta = new ContaCorrente();

        ArrayList<Conta> listaContas = new ArrayList<Conta>();

        listaContas = ContaDAOView.listarContas();

        for (int i = 0; i < listaContas.size(); i++) {

            conta = listaContas.get(i);
            colunas[0] = conta.getTitular();
            colunas[1] = conta.getNumeroConta();
            colunas[2] = conta.getTipoConta();
            colunas[3] = conta.getSaldo();
            colunas[4] = conta.getAgencia();

            model.addRow(colunas);
        }
    }

    /*
        METODOS PARA PREENCHER AS TABELAS DA EDITARCONTA 
     */
    //TABELA AGENCIA NO EDITAR CONTA
    public static void preencherTabelaAgenciaEditarConta() throws SQLException {

        DefaultTableModel model = (DefaultTableModel) tblTabelaAgenciaEditarConta.getModel();
        model.setNumRows(0);

        Object colunas[] = new Object[4];
        Agencia agencia = new Agencia();

        ArrayList<Agencia> listaAgencias = new ArrayList<Agencia>();

        listaAgencias = AgenciaDAOView.listarAgencias();

        for (int i = 0; i < listaAgencias.size(); i++) {

            agencia = listaAgencias.get(i);

            colunas[0] = agencia.getNumero();
            colunas[1] = agencia.getGerente();
            colunas[2] = agencia.getLocalizacao();
            colunas[3] = agencia.getTelefone();

            model.addRow(colunas);
        }
    }

    //TABELA CLIENTE NO EDITAR CONTA
    public static void preencherTabelaClienteEditarConta() throws SQLException {

        DefaultTableModel model = (DefaultTableModel) tblTabelaClienteEditarConta.getModel();
        model.setNumRows(0);

        Object colunas[] = new Object[3];
        Cliente cliente = new Cliente();

        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

        listaClientes = ClienteDAOView.listarClientes();

        for (int i = 0; i < listaClientes.size(); i++) {

            cliente = listaClientes.get(i);
            colunas[0] = cliente.getNome();
            colunas[1] = cliente.getCpf();
            colunas[2] = cliente.getContato();

            model.addRow(colunas);
        }
    }

    public static void preencherExcluirAgencia() throws SQLException {

        DefaultTableModel model = (DefaultTableModel) tblExcluirAgencia.getModel();
        model.setNumRows(0);

        Object colunas[] = new Object[5];
        Agencia agencia = new Agencia();

        ArrayList<Agencia> listaAgencias = new ArrayList<Agencia>();

        listaAgencias = AgenciaDAOView.listarAgencias();

        for (int i = 0; i < listaAgencias.size(); i++) {

            agencia = listaAgencias.get(i);
            colunas[0] = agencia.getId_agencia();
            colunas[1] = agencia.getNumero();
            colunas[2] = agencia.getGerente();
            colunas[3] = agencia.getLocalizacao();
            colunas[4] = agencia.getTelefone();

            model.addRow(colunas);
        }

    }

    public static void preencherExcluirCliente() throws SQLException {

        DefaultTableModel model = (DefaultTableModel) tblExcluirCliente.getModel();
        model.setNumRows(0);

        Object colunas[] = new Object[3];
        Cliente cliente = new Cliente();

        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

        listaClientes = ClienteDAOView.listarClientes();

        for (int i = 0; i < listaClientes.size(); i++) {

            cliente = listaClientes.get(i);
            colunas[0] = cliente.getNome();
            colunas[1] = cliente.getCpf();
            colunas[2] = cliente.getContato();

            model.addRow(colunas);
        }
    }

    public static void preencherTabelaAgencia() throws SQLException {

        DefaultTableModel model = (DefaultTableModel) tblTabelaAgencia.getModel();
        model.setNumRows(0);

        Object colunas[] = new Object[4];
        Agencia agencia = new Agencia();

        ArrayList<Agencia> listaAgencias = new ArrayList<Agencia>();

        listaAgencias = AgenciaDAOView.listarAgencias();

        for (int i = 0; i < listaAgencias.size(); i++) {

            agencia = listaAgencias.get(i);
            colunas[0] = agencia.getNumero();
            colunas[1] = agencia.getGerente();
            colunas[2] = agencia.getLocalizacao();
            colunas[3] = agencia.getTelefone();

            model.addRow(colunas);
        }
    }

    public static void preencherTabelaCliente() throws SQLException {

        DefaultTableModel model = (DefaultTableModel) tblTabelaClienteView.getModel();
        model.setNumRows(0);

        Object colunas[] = new Object[3];
        Cliente cliente = new Cliente();

        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

        listaClientes = ClienteDAOView.listarClientes();

        for (int i = 0; i < listaClientes.size(); i++) {

            cliente = listaClientes.get(i);
            colunas[0] = cliente.getNome();
            colunas[1] = cliente.getCpf();
            colunas[2] = cliente.getContato();

            model.addRow(colunas);
        }
    }

    public static void preencherTabelaConta() throws SQLException {

        DefaultTableModel model = (DefaultTableModel) tblTabelaContas.getModel();
        model.setNumRows(0);

        Object colunas[] = new Object[5];
        Conta conta = new ContaCorrente();

        ArrayList<Conta> listaContas = new ArrayList<Conta>();

        listaContas = ContaDAOView.listarContas();

        for (int i = 0; i < listaContas.size(); i++) {

            conta = listaContas.get(i);
            colunas[0] = conta.getTitular();
            colunas[1] = conta.getNumeroConta();
            colunas[2] = conta.getTipoConta();
            colunas[3] = conta.getSaldo();
            colunas[4] = conta.getAgencia();

            model.addRow(colunas);
        }
    }

    public static  void preencherTabelaContaPorAgencia(int numeroAgencia) throws SQLException {

        DefaultTableModel model = (DefaultTableModel) tblTabelaContasPorAgencia.getModel();
        model.setNumRows(0);

        Object colunas[] = new Object[5];
        Conta conta = new ContaCorrente();

        ArrayList<Conta> listaContasPorAgencia = new ArrayList<Conta>();

        listaContasPorAgencia = ContaDAOView.listarContasPorAgencia(numeroAgencia);

        for (int i = 0; i < listaContasPorAgencia.size(); i++) {

            conta = listaContasPorAgencia.get(i);
            colunas[0] = conta.getTitular();
            colunas[1] = conta.getNumeroConta();
            colunas[2] = conta.getTipoConta();
            colunas[3] = conta.getSaldo();
            colunas[4] = conta.getAgencia();
            
            model.addRow(colunas);
        }

    }
}
