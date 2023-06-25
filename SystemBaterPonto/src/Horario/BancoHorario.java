package Horario;

public class BancoHorario {

    private int id_hora;
    private String horarioInicio;
    private String horarioTermino;
    private String dataDeAcesso;

    public BancoHorario(int id_hora, String horarioInicio, String horarioTermino, String dataDeAcesso) {
        this.id_hora = id_hora;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
        this.dataDeAcesso = dataDeAcesso;
    }
    
    
    //

    public BancoHorario(String horarioInicio, String horarioTermino, String dataDeAcesso) {
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
        this.dataDeAcesso = dataDeAcesso;
    }
    
    

    public int getId_hora() {
        return id_hora;
    }

    public void setId_hora(int id_hora) {
        this.id_hora = id_hora;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioTermino() {
        return horarioTermino;
    }

    public void setHorarioTermino(String horarioTermino) {
        this.horarioTermino = horarioTermino;
    }

    public String getDataDeAcesso() {
        return dataDeAcesso;
    }

    public void setDataDeAcesso(String dataDeAcesso) {
        this.dataDeAcesso = dataDeAcesso;
    }
    
    
}
