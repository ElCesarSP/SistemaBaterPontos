package dao;

import cadastro.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import views.cadastro;

public class UsuarioDAO {

    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    /*public Usuario insert(Usuario usuario) throws SQLException {

        String sql = "INSERT INTO usuario(usuarios,senha)   VALUES (? ,?); ";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, usuario.getUsuarios());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        
        ResultSet resultSet = statement.getGeneratedKeys();
        
        if (resultSet.next()){
            int id = resultSet.getInt("id");
            usuario.setId(id);
        }
        return usuario;
        
    }*/

    public void insert(Usuario usuario) throws SQLException {
    
    String sql = "INSERT INTO usuario (nome, usuarios, senha, cpf, rg, cargo, dataNascimento, IndentificadoUnico, telefone, estado, cidade, bairro, rua, referencia, complemento, numero, cep) VALUES ('"+usuario.getNome()+"', '"+usuario.getUsuarios()+"','"+usuario.getSenha()+"', '"+usuario.getCpf()+"', '"+usuario.getRg()+"', '"+usuario.getCargo()+"', '"+usuario.getDataNascimento()+"', '"+usuario.getIdentificadoUnico()+"', '"+usuario.getTelefone()+"', '"+usuario.getEstado()+"', '"+usuario.getCidade()+"', '"+usuario.getBairro()+"', '"+usuario.getRua()+"', '"+usuario.getReferencia()+"', '"+usuario.getComplemento()+"', '"+usuario.getNumero()+"', '"+usuario.getCep()+"');" ;
    PreparedStatement statement = connection.prepareStatement(sql);
    
    statement.execute();
    connection.close();
    
    }

    public boolean existeNoBancoEsseUsuarioSenha(Usuario usuario) throws SQLException {

        String sql = "SELECT * FROW usuario WHERE usuarios = ? AND senha = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, usuario.getUsuarios());
        statement.setString(2, usuario.getSenha());

        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        return resultSet.next();
    }

    public boolean autenticarUsuario(Usuario usuario) throws SQLException {

        String sql = "SELECT * FROM usuario WHERE usuarios = ? AND senha = ? ;";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, usuario.getUsuarios());
        statement.setString(2, usuario.getSenha());

        statement.execute();
        ResultSet resultSet = statement.getResultSet();

        return resultSet.next();
    }

    public void update(Usuario usuario) throws SQLException {

        String sql = "UPDATE  usuario SET usuarios = ?, senha = ? WHERE id = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, usuario.getUsuarios());
        statement.setString(2, usuario.getSenha());
        statement.setInt(3, usuario.getId());
        statement.execute();
    }

    public void insertOrUpdate(Usuario usuario) throws SQLException {
        if (usuario.getId() > 0) {
            update(usuario);
        } else {
            insert(usuario);
        }
    }

    public void delete(Usuario usuario) throws SQLException {
        String sql = "DELETE FROM usuario WHERE id = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, usuario.getId());
        statement.execute();
    }

    public ArrayList<Usuario> SelecAll() throws SQLException {
        String sql = "SELECT * FROW usuario ";
        PreparedStatement statement = connection.prepareStatement(sql);

        return pesquisa(statement);
    }

    private ArrayList<Usuario> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Usuario> usuarios = pesquisa(statement);

        statement.execute();
        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String usuario = resultSet.getString("usuarios");
            String senha = resultSet.getString("senha");
            String cpf = resultSet.getString("cpf");
            String rg = resultSet.getString("rg");
            String cargo = resultSet.getString("cargo");
            String dataNascimento = resultSet.getString("dataNascimento");
            String IdentificadoUnico = resultSet.getString("IdentificadoUnico");
            String telefone = resultSet.getString("telefone");
            String estado = resultSet.getString("estado");
            String cidade = resultSet.getString("cidade");
            String bairro = resultSet.getString("bairro");
            String rua = resultSet.getString("rua");
            String referencia = resultSet.getString("referencia");
            String complemento = resultSet.getString("complemento");
            String numero = resultSet.getString("numeros");
            String cep = resultSet.getString("cep");

            Usuario usuariosComDadosBanco = new Usuario(nome, usuario, senha, cpf, rg, cargo, dataNascimento, IdentificadoUnico, telefone, estado, cidade, bairro, rua, referencia, complemento, numero, cep);
            //esse metod usado aqui em baixo e so um teste
            Usuario usuariosNoBancoDeDados = new Usuario(id);

            usuarios.add(usuariosComDadosBanco);
            usuarios.add(usuariosNoBancoDeDados);
        }
        return usuarios;
    }

    public Usuario selectPorId(Usuario usuario) throws SQLException {
        String sql = "SELECT * FROM usuario  WHERE id = ? ;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, usuario.getId());

        return pesquisa(statement).get(0);
    }

}
