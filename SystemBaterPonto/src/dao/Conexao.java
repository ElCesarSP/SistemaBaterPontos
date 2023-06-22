package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao{
    // aqui vou implementar a conexão com meu bando de dados 
    public Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetobp?zeroDateTimeBehavior=convertToNull","root","");
        return conexao;
    }
    
}
