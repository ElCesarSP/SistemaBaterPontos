package dao;

import Horario.Horas;
import cadastro.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import views.cadastro;

public class UsuarioDAO {

    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public Usuario insert2(Usuario usuario) throws SQLException {

        String sql = "INSERT INTO usuario(usuarios,senha)   VALUES (? ,?); ";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, usuario.getUsuarios());
        statement.setString(2, usuario.getSenha());
        statement.execute();

        ResultSet resultSet = statement.getGeneratedKeys();

        if (resultSet.next()) {
            int id_usuario = resultSet.getInt("id_usuario");
            usuario.setId(id_usuario);
        }
        return usuario;

    }

    public void insert(Usuario usuario) throws SQLException {

        String sql = "INSERT INTO usuario (nome, usuarios, senha, cpf, rg, cargo, dataNascimento, IndentificadoUnico, telefone, estado, cidade, bairro, rua, referencia, complemento, numero, cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getUsuarios());
        statement.setString(3, usuario.getSenha());
        statement.setString(4, usuario.getCpf());
        statement.setString(5, usuario.getRg());
        statement.setString(6, usuario.getCargo());
        statement.setString(7, usuario.getDataNascimento());
        statement.setString(8, usuario.getIdentificadoUnico());
        statement.setString(9, usuario.getTelefone());
        statement.setString(10, usuario.getEstado());
        statement.setString(11, usuario.getCidade());
        statement.setString(12, usuario.getBairro());
        statement.setString(13, usuario.getRua());
        statement.setString(14, usuario.getReferencia());
        statement.setString(15, usuario.getComplemento());
        statement.setString(16, usuario.getNumero());
        statement.setString(17, usuario.getCep());

        statement.execute();
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
        String sql = "UPDATE usuario SET senha = ? WHERE usuarios = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario.getSenha());
            statement.setString(2, usuario.getUsuarios());
            statement.executeUpdate();
        }
    }

    public void updateUsuarios(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuario SET senha = ?, telefone = ?, cargo = ?, estado = ?, cidade = ?, bairro = ?, rua = ?, numero = ?, complemento = ?, cep = ? WHERE id_usuario = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, usuario.getSenha());
        statement.setString(2, usuario.getTelefone());
        statement.setString(3, usuario.getCargo());
        statement.setString(4, usuario.getEstado());
        statement.setString(5, usuario.getCidade());
        statement.setString(6, usuario.getBairro());
        statement.setString(7, usuario.getRua());
        statement.setString(8, usuario.getNumero());
        statement.setString(9, usuario.getComplemento());
        statement.setString(10, usuario.getCep());
        statement.setInt(11, usuario.getId());

        statement.executeUpdate();
    }

    public void insertOrUpdate(Usuario usuario) throws SQLException {
        if (usuario.getId() > 0) {
            update(usuario);
        } else {
            insert(usuario);
        }
    }

    public void delete(Usuario usuario) throws SQLException {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, usuario.getId());
            statement.execute();
        }
    }

    public void deleteByUsuario(String usuario) throws SQLException {
        String sql = "DELETE FROM usuario WHERE usuarios = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario);
            statement.execute();
        }
    }

    public ArrayList<Usuario> SelecAll() throws SQLException {
        String sql = "SELECT * FROW usuario ";
        PreparedStatement statement = connection.prepareStatement(sql);

        return pesquisa(statement);
    }

    private ArrayList<Usuario> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String usuario = resultSet.getString("usuarios");
            String senha = resultSet.getString("senha");
            String cpf = resultSet.getString("cpf");
            String rg = resultSet.getString("rg");
            String cargo = resultSet.getString("cargo");
            String dataNascimento = resultSet.getString("dataNascimento");
            String identificadoUnico = resultSet.getString("IndentificadoUnico");
            String telefone = resultSet.getString("telefone");
            String estado = resultSet.getString("estado");
            String cidade = resultSet.getString("cidade");
            String bairro = resultSet.getString("bairro");
            String rua = resultSet.getString("rua");
            String referencia = resultSet.getString("referencia");
            String complemento = resultSet.getString("complemento");
            String numero = resultSet.getString("numero");
            String cep = resultSet.getString("cep");

            Usuario usuarioDoBanco = new Usuario(id, nome, usuario, senha, cpf, rg, cargo, dataNascimento, identificadoUnico, telefone, estado, cidade, bairro, rua, referencia, complemento, numero);

            usuarios.add(usuarioDoBanco);
        }

        return usuarios;
    }

    public Usuario selectPorId(Usuario usuario) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, usuario.getId());

        ArrayList<Usuario> usuarios = pesquisa(statement);
        if (!usuarios.isEmpty()) {
            return usuarios.get(0);
        } else {
            return null; // ou qualquer ação apropriada para lidar com o caso em que o usuário não é encontrado
        }
    }

    public Usuario buscarUsuario(String usuario) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE usuarios = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt("id_usuario");
            String nome = resultSet.getString("nome");
            String senha = resultSet.getString("senha");
            String cpf = resultSet.getString("cpf");
            String rg = resultSet.getString("rg");
            String cargo = resultSet.getString("cargo");
            String dataNascimento = resultSet.getString("dataNascimento");
            String IdentificadoUnico = resultSet.getString("IndentificadoUnico");
            String telefone = resultSet.getString("telefone");
            String estado = resultSet.getString("estado");
            String cidade = resultSet.getString("cidade");
            String bairro = resultSet.getString("bairro");
            String rua = resultSet.getString("rua");
            String referencia = resultSet.getString("referencia");
            String complemento = resultSet.getString("complemento");
            String numero = resultSet.getString("numero");
            String cep = resultSet.getString("cep");

            return new Usuario(id, nome, usuario, senha, cpf, rg, cargo, dataNascimento, IdentificadoUnico, telefone, estado, cidade, bairro, rua, referencia, complemento, numero);
        }

        return null;
    }

    public Usuario Consulta(String usuario) throws SQLException {

        String sql = "SELECT * FROM usuario WHERE nomes = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, usuario);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String nome = resultSet.getString("nome");

            return new Usuario(nome);
        }
        return null;
    }

    //Teste
    public List<Horas> buscarHorasPorIdentificadorUnico(String identificadorUnico, String data) {
        List<Horas> horasList = new ArrayList<>();

        try {
            String query = "SELECT u.nome, h.horas, h.horaspecorrida, h.datas "
                    + "FROM usuario u "
                    + "INNER JOIN horas h ON u.id_usuario = h.id_usuario "
                    + "WHERE u.IndentificadorUnico = ? ";

            // Verifica se o campo de texto para o mês não está vazio
            if (data != null && !data.isEmpty()) {
                int mes = Integer.parseInt(data);
                query += "AND MONTH(h.datas) = " + mes + " ";
            }

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, identificadorUnico);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String horas = resultSet.getString("horas");
                String horasPercorrida = resultSet.getString("horaspecorrida");
                String dataHora = resultSet.getString("datas");

                Horas horasObj = new Horas(nome, horas, horasPercorrida, dataHora);
                horasList.add(horasObj);
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException ex) {
            System.out.println("Não foi possível realizar a consulta!");
            ex.printStackTrace();
        }

        return horasList;
    }

    // Outros métodos da classe...
}
