package helper;

public class HelperLimpa {

    public static void limpaTextoCriarAgencia() {

        view.CriarAgencia.txtNumero.setText("");
        view.CriarAgencia.txtGerente.setText("");
        view.CriarAgencia.txtLocalizacao.setText("");
        view.CriarAgencia.txtTelefone.setText("");
    }

    public static void limpaTextoCriarCliente() {

        view.CriarCliente.txtNome.setText("");
        view.CriarCliente.txtCpf.setText("");
        view.CriarCliente.txtContato.setText("");
    }

    public static void limpaTextoCriarConta() {
        view.CriarConta.txtTitular.setText("");
        view.CriarConta.txtNumero.setText("");
        view.CriarConta.txtDeposito.setText("");
        view.CriarConta.txtAgencia.setText("");
    }

    public static void limpaTextoEditarAgencia() {

        //view.CriarAgencia.txtNumero.setText("");
        view.CriarAgencia.txtGerente.setText("");
        view.CriarAgencia.txtLocalizacao.setText("");
        view.CriarAgencia.txtTelefone.setText("");
    }

    public static void limpaTextoExcluirAgencia() {
        view.ExcluirAgencia.txtNumero.setText("");
    }

    public static void limpaTextoExcluirCliente() {
        view.ExcluirCliente.txtCpf.setText("");
    }

    public static void limpaTextoExcluirConta() {
        view.ExcluirConta.txtNumero.setText("");
    }

    public static void visualizarAgenciaView() {
        view.VisualizarAgencia.txtNumeroAgencia.setText("");
    }

    public static void visualizarClienteView() {
        view.VisualizarCliente.txtCpf.setText("");
    }

    public static void visualizarContaView() {
        view.VisualizarConta.txtNumero.setText("");
    }

}
