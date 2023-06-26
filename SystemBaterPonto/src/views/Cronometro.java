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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Cronometro {

    private DefaultTableModel model;
    private Timer timer;
    private int turno;
    private SimpleDateFormat dateFormat;
    private Date horaInicio;
    private boolean cronometroEmAndamento;
    private long totalHorasPercorridas;
    private long totalMinutosPercorridos;
    private long totalSegundosPercorridos;

    public Cronometro(DefaultTableModel model) {
        this.model = model;
        this.turno = 1;
        this.dateFormat = new SimpleDateFormat("HH:mm:ss");
        this.cronometroEmAndamento = false;
        this.totalHorasPercorridas = 0;
        this.totalMinutosPercorridos = 0;
        this.totalSegundosPercorridos = 0;
    }

    public void iniciarCronometro() {
        if (cronometroEmAndamento || turno > 2) {
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
            long tempoMinimoSegundos = 3 * 60 * 60; // 4 horas em segundos

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

        // Criação dos botões "inicio", "termino", "mostrarSoma" e "salvar"
        JButton inicioButton = new JButton("Início");
        JButton terminoButton = new JButton("Término");
        JButton mostrarSomaButton = new JButton("Fim do Expediente");
        JButton salvarButton = new JButton("Salvar");

        // Configuração do layout do painel
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(tabela), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(inicioButton);
        buttonPanel.add(terminoButton);
        buttonPanel.add(mostrarSomaButton);
        buttonPanel.add(salvarButton);

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
        mostrarSomaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long somaHoras = cronometro.getTotalHorasPercorridas();
                long somaMinutos = cronometro.getTotalMinutosPercorridos();
                long somaSegundos = cronometro.getTotalSegundosPercorridos();
                System.out.println("Soma Horas: " + somaHoras);
                System.out.println("Soma Minutos: " + somaMinutos);
                System.out.println("Soma Segundos: " + somaSegundos);
                JOptionPane.showMessageDialog(null, "Você fez! " + " Horas " + somaHoras + "," + " Minutos " + somaMinutos + "," + " Segundos " + somaSegundos + "  durante o seu expediente ");
            }
        });
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarDadosTabela(model);
            }
        });
    }

    public long getTotalHorasPercorridas() {
        return totalHorasPercorridas;
    }

    public long getTotalMinutosPercorridos() {
        return totalMinutosPercorridos;
    }

    public long getTotalSegundosPercorridos() {
        return totalSegundosPercorridos;
    }

    private static void salvarDadosTabela(DefaultTableModel model) {
        String url = "jdbc:mysql://localhost:3306/projetobp?zeroDateTimeBehavior=convertToNull";
        String user = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String nomeUsuario = JOptionPane.showInputDialog("Digite seu nome completo : ");
            int idUsuario = buscarIdUsuario(nomeUsuario, connection);
            if (idUsuario == -1) {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
                return;
            }

            for (int i = 0; i < model.getRowCount(); i++) {
                String horaTermino = (String) model.getValueAt(i, 1); // Coluna "HORAS PERCORRIDAS"
                String horasPercorridas = (String) model.getValueAt(i, 2); // Coluna "DATA"

                String sql = "INSERT INTO horas (id_usuario, nome, horas, horasPecorrida, datas) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, idUsuario);
                statement.setString(2, nomeUsuario);
                statement.setString(3, horaTermino);
                statement.setString(4, horasPercorridas);
                statement.setDate(5, new java.sql.Date(System.currentTimeMillis()));

                statement.executeUpdate();
                statement.close();
            }

            System.out.println("Dados salvos no banco de dados com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao salvar os dados no banco de dados: " + e.getMessage());
        }
    }

    private static int buscarIdUsuario(String nomeUsuario, Connection connection) {
        int idUsuario = -1;

        try {
            String sql = "SELECT id_usuario FROM usuario WHERE nome = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nomeUsuario);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                idUsuario = resultSet.getInt("id_usuario");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar o id do usuário: " + e.getMessage());
        }

        return idUsuario;
    }
}
