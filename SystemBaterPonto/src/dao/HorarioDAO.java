package dao;

import java.sql.Connection;

import java.util.ArrayList;
import Horario.Horario;

public class HorarioDAO {

    private Connection connection;

    public HorarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public static  boolean listHorarios() {
        
        return true;
    }
    
}
