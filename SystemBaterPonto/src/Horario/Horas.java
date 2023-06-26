/**
 *
 * @author César
 */
package Horario;

public class Horas {

    private String nome;
    private String horas;
    private String horasPercorridas;
    private String data;

    /*public Horas(String nome, String horas, String horasPercorridas, String data) {
        this.nome = nome;
        this.horas = horas;
        this.horasPercorridas = horasPercorridas;
        this.data = data;
    }*/

    public Horas(String nome, String horas, String horasPercorrida, String dataHora) {
        this.nome = nome;
        this.horas = horas;
        this.horasPercorridas = horasPercorridas;
        this.data = data;

    }

    // Getters e Setters (métodos de acesso)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getHorasPercorridas() {
        return horasPercorridas;
    }

    public void setHorasPercorridas(String horasPercorridas) {
        this.horasPercorridas = horasPercorridas;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
