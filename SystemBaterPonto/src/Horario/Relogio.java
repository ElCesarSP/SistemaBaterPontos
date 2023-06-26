package Horario;

import java.time.LocalDateTime;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Relogio {

    private boolean iniciado;
    private LocalDateTime inicio;

    public Relogio() {
        iniciado = false;
    }

    public boolean isIniciado() {
        return iniciado;
    }

    public void iniciar() {
        inicio = LocalDateTime.now();
        iniciado = true;
    }

    public void terminar(JTable table, DefaultTableModel model, int selectedRow) {
        LocalDateTime termino = LocalDateTime.now();
        // Calcula a diferença entre o início e o término para obter as horas percorridas
        long horasPercorridas = inicio.until(termino, java.time.temporal.ChronoUnit.HOURS);
        // Atualiza a coluna "Horas Percorridas" com o valor calculado
        model.setValueAt(horasPercorridas, selectedRow, 2);
        // Atualiza a coluna "Data" com o valor do término
        model.setValueAt(termino.toString(), selectedRow, 3);
        iniciado = false;
    }
}
