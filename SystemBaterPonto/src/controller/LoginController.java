package controller;

import cadastro.Usuario;
import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import views.cadastro;
import views.intADM;
import views.intuUsuario;
import views.longin;

public class LoginController {

    private longin views;

    public LoginController(longin views) {
        this.views = views;
    }

    public void autenticar() throws SQLException, CloneNotSupportedException {

        String Usuar = null;
        String Senh = null;

        //Buscar o usuario da views
        String usuarios = views.getTxtUsu().getText();
        String senha = views.getPassSenh().getText();

        Usuario autenticarUsuario = new Usuario(usuarios, senha);
        //Verificar se exisate no banco de dados
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);

        boolean existe = usuarioDAO.autenticarUsuario(autenticarUsuario);
        //Se existir direciona para o menu

        if (existe) {
            Usuar = usuarios;
            Senh = senha;
        }

        /*Aqui estou usando regras de negosio para poder somentes usuario do projeto poder realizar
         Por padrão futuramento vamos modelar no banco de dados como seria somente usuarios
         cadastrado que poder realizar a tela de catro e implementar mais novos cadastro de adm
         */
        if (usuarios.equals("admin") && senha.equals("admin")
                || usuarios.equals("cesar") && senha.equals("cesar")
                || usuarios.equals("rafael") && senha.equals("rafael")
                || usuarios.equals("pedro") && senha.equals("pedro")
                || usuarios.equals("esdras") && senha.equals("esdras")) {

            cadastro telaDeCadastro = new cadastro();
            new intADM().setVisible(true);      
            
        } else if (existe) {
            intuUsuario telaDeUsuarioComun = new intuUsuario();
            new intuUsuario().setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Usuario o senha Invalidos");
        }

        /*
         if (existe) {
         cadastro telaDeCadastro = new cadastro();
         new intADM().setVisible(true);
         JOptionPane.showMessageDialog(null," Sejá Bem-Vindo ");
            
         }else{
         JOptionPane.showMessageDialog(null, "Usuario o senha Invalidos" );
         }*/
    }

}
