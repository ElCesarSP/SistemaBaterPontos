package controller;

import cadastro.Usuario;
import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import views.cadastro;

public class FormCadastroController {

    private cadastro views;

    public FormCadastroController(cadastro views) {
        this.views = views;
    }

    public void salvaUsuario() {

        String nome = views.getTxtNome().getText();
        String usuarios = views.getTxtUsu().getText();
        String senha = views.getPassSenh().getText();
        String cpf = views.getForCpf().getText();
        String rg = views.getForRg().getText();
        String cargo = views.getTxtCargo().getText();
        String dataNasc = views.getForData().getText();
        String id = views.getTxtId().getText();
        String telefone = views.getTxtTele().getText();
        String estado = views.getTxtEsta().getText();
        String cidade = views.getTxtCidade().getText();
        String bairro = views.getTxtBairro().getText();
        String rua = views.getTxtRua().getText();
        String referencia = views.getTxtRefe().getText();
        String complemento = views.getTxtComple().getText();
        String numero = views.getTxtNum().getText();
        String cep = views.getForCep().getText();

        Usuario usuario = new Usuario(nome, usuarios, senha, cpf, rg, cargo, dataNasc, id, telefone, estado, cidade, bairro, rua, referencia, complemento, numero, cep);

        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
            usuarioDAO.insert(usuario);

            // Limpar os campos de texto
            limparCampos(views.getTxtNome(), views.getTxtUsu(), views.getPassSenh(), views.getForCpf(), views.getForRg(),
                    views.getTxtCargo(), views.getForData(), views.getTxtId(), views.getTxtTele(), views.getTxtEsta(),
                    views.getTxtCidade(), views.getTxtBairro(), views.getTxtRua(), views.getTxtRefe(), views.getTxtComple(),
                    views.getTxtNum(), views.getForCep());

            JOptionPane.showMessageDialog(null, "Dados do Usuário Salvo Com Sucesso!", "Salvos...", JOptionPane.PLAIN_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void limparCampos(JTextField txtNome, JTextField txtUsu, JPasswordField passSenh, JFormattedTextField forCpf, JFormattedTextField forRg, JTextField txtCargo, JFormattedTextField forData, JTextField txtId, JTextField txtTele, JTextField txtEsta, JTextField txtCidade, JTextField txtBairro, JTextField txtRua, JTextField txtRefe, JTextField txtComple, JTextField txtNum, JFormattedTextField forCep) {

        txtNome.setText("");
        txtUsu.setText("");
        passSenh.setText("");
        forCpf.setText("");
        forRg.setText("");
        txtCargo.setText("");
        forData.setText("");
        txtId.setText("");
        txtTele.setText("");
        txtEsta.setText("");
        txtCidade.setText("");
        txtBairro.setText("");
        txtRua.setText("");
        txtRefe.setText("");
        txtComple.setText("");
        txtNum.setText("");
        forCep.setText("");

    }
}
