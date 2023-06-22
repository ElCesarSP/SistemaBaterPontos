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
    private static final Duration DURACAO_MINIMA = Duration.ofHours(4);

    public RelogioTabela(JTable tabela) {
        this.tabela = tabela;
    }

    public void iniciarCronometro() {
        // Configure o horário de início para o horário atual
        horarioInicio = LocalDateTime.now();
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
        // Defina o horário de término do primeiro turno apenas se tiverem se passado no mínimo 4 horas
        LocalDateTime horarioAtual = LocalDateTime.now();
        Duration duracao = Duration.between(horarioInicio, horarioAtual);

        if (duracao.compareTo(DURACAO_MINIMA) >= 0) {
            // Pare o timer
            if (timer != null) {
                timer.stop();
            }

            // Defina o horário de término do primeiro turno
            horarioTermino = horarioAtual;
            atualizarTabela();
        }
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

        if (duracao.compareTo(DURACAO_MINIMA) >= 0) {
            // O tempo mínimo foi atingido, permita parar o cronômetro
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
