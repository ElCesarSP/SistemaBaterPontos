/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author César
 */
package views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Timer;

public class Cronometro {

    private DefaultTableModel model;
    private Timer timer;
    private int turno;
    private SimpleDateFormat dateFormat;
    private Date horaInicio;
    private boolean cronometroEmAndamento;

    public Cronometro(DefaultTableModel model) {
        this.model = model;
        this.turno = 1;
        this.dateFormat = new SimpleDateFormat("HH:mm:ss");
        this.cronometroEmAndamento = false;
    }

    public void iniciarCronometro() {
        if (cronometroEmAndamento) {
            return;
        }

        horaInicio = new Date();

        // Definir a hora de início na coluna "HORAS"
        String horaInicioStr = dateFormat.format(horaInicio);

        model.addRow(new String[]{"TURNO " + turno, horaInicioStr, "", ""});

        int linha = model.getRowCount() - 1;

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarTempoDecorrido(linha);
            }
        });
        timer.start();

        turno++;
        cronometroEmAndamento = true;
    }

    public void pararCronometro() {
        if (cronometroEmAndamento) {
            long tempoDecorridoSegundos = (new Date().getTime() - horaInicio.getTime()) / 1000;
            long tempoMinimoSegundos = 4 * 60 * 60; // 4 horas em segundos

            if (tempoDecorridoSegundos >= tempoMinimoSegundos) {
                timer.stop();
                timer = null;
                cronometroEmAndamento = false;
            }
        }
    }

    private void atualizarTempoDecorrido(int linha) {
        Date agora = new Date();
        long segundosDecorridos = (agora.getTime() - horaInicio.getTime()) / 1000;

        String tempoDecorrido = formatarTempo(segundosDecorridos);

        model.setValueAt(tempoDecorrido, linha, 2); // Coluna "HORAS PERCORRIDAS"

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataAtual = dateFormat.format(agora);
        model.setValueAt(dataAtual, linha, 3); // Coluna "DATA"
    }

    private String formatarTempo(long segundos) {
        long dias = segundos / (24 * 3600);
        segundos %= (24 * 3600);
        long horas = segundos / 3600;
        segundos %= 3600;
        long minutos = segundos / 60;
        segundos %= 60;

        String tempoFormatado = String.format("%02d:%02d:%02d:%02d:%02d:%02d", dias, horas, minutos, 0, 0, segundos);

        // Remover os 6 primeiros caracteres do tempoFormatado
        if (tempoFormatado.length() > 6) {
            tempoFormatado = tempoFormatado.substring(9);
        } else {
            tempoFormatado = "00:00:00";
        }

        return tempoFormatado;
    }

    public static void main(String[] args) {
        // Criação dos dados vazios
        int numColunas = 4;
        int numLinhas = 0;
        String[] colunas = {"TURNO", "HORAS", "HORAS PERCORRIDAS", "DATA"};
        String[][] dados = new String[numLinhas][numColunas];

        // Criação do modelo da tabela com os nomes das colunas
        DefaultTableModel model = new DefaultTableModel(dados, colunas);

        // Criação da tabela usando o modelo
        JTable tabela = new JTable(model);

        // Criação dos botões "inicio" e "termino"
        JButton inicioButton = new JButton("Início");
        JButton terminoButton = new JButton("Término");

        // Configuração do layout do painel
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(tabela), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(inicioButton);
        buttonPanel.add(terminoButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Criação da janela para exibir a tabela
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        // Criação e inicialização do cronômetro
        Cronometro cronometro = new Cronometro(model);
        inicioButton.addActionListener(e -> cronometro.iniciarCronometro());
        terminoButton.addActionListener(e -> cronometro.pararCronometro());
    }
}
