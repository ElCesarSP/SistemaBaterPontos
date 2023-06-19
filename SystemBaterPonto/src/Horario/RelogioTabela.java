package Horario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class RelogioTabela {

    private final JTable tabela;
    private Timer timer;
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioTermino;
    private LocalDate dataInicio;
    private static final Duration DURACAO_MAXIMA = Duration.ofHours(4).plusMinutes(5);

    public RelogioTabela(JTable tabela) {
        this.tabela = tabela;
    }

    public void iniciarCronometro() {
        // Configure o horário de início para 0:00
        horarioInicio = LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0));
        dataInicio = LocalDate.now();

        // Inicie o timer para atualizar o tempo na tabela
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarTabela();
            }
        });
        timer.start();
    }

    public void pararCronometro() {
        // Pare o timer
        if (timer != null) {
            timer.stop();
        }

        // Defina o horário de término do primeiro turno
        horarioTermino = LocalDateTime.now();
    }

    public LocalDateTime getHorarioInicio() {
        return horarioInicio;
    }

    public LocalDateTime getHorarioTermino() {
        return horarioTermino;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    private void atualizarTabela() {
        // Atualize a tabela com o tempo decorrido desde o horário de início
        LocalDateTime agora = LocalDateTime.now();
        Duration duracao = Duration.between(horarioInicio, agora);

        if (duracao.compareTo(DURACAO_MAXIMA) >= 0) {
            // O tempo excedeu o limite máximo, pare o cronômetro
            pararCronometro();
        }

        long horas = duracao.toHours();
        long minutos = duracao.toMinutes() % 60;
        long segundos = duracao.getSeconds() % 60;

        // Formate a string de tempo no formato HH:MM:SS
        String tempoFormatado = String.format("%02d:%02d:%02d", horas, minutos, segundos);

        // Atualize a linha da tabela com os novos valores
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        int lastRow = model.getRowCount() - 1;
        model.setValueAt(tempoFormatado, lastRow, 2);
    }
}
