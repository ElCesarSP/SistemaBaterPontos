/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import cadastro.Usuario;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author César
 */
public class alteraUSU extends javax.swing.JFrame {

    /**
     * Creates new form alteraUSU
     */
    public alteraUSU() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsuar1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNewUsuario = new javax.swing.JTextField();
        txtNovaSenha = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        passNewSen2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem3 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 450));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(380, 260));
        jPanel1.setPreferredSize(new java.awt.Dimension(380, 260));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nome do Usuario :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));
        jPanel1.add(txtUsuar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 225, 31));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Altera a Senha");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 25, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Senha Antiga :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 173, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Senha Nova :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 233, -1, -1));
        jPanel1.add(txtNewUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 225, 36));
        jPanel1.add(txtNovaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 225, 34));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Confirma Usuario :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 113, -1, -1));
        jPanel1.add(passNewSen2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 225, 34));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Sistem Ponto (2).png"))); // NOI18N
        jLabel7.setText("img");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, -20, -1, -1));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(133, 38, 510, 300);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jButton3.setText("Salvar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(540, 350, 100, 30);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(130, 350, 100, 30);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Funcionário");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(140, 20, 90, 15);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Sistem Ponto (1).png"))); // NOI18N
        jLabel6.setText("img");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(-10, -10, 820, 440);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/inco/menu 1.png"))); // NOI18N
        jMenu1.setText("Menu");
        jMenu1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N

        jRadioButtonMenuItem1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("Voltar a página inicial");
        jRadioButtonMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/inco/tela inicial 2.png"))); // NOI18N
        jRadioButtonMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItem1);

        jRadioButtonMenuItem3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jRadioButtonMenuItem3.setSelected(true);
        jRadioButtonMenuItem3.setText("Informações");
        jRadioButtonMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/inco/sobre 2.png"))); // NOI18N
        jRadioButtonMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItem3);

        jRadioButtonMenuItem2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("Suporte ");
        jRadioButtonMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/inco/2.png"))); // NOI18N
        jRadioButtonMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem2ActionPerformed
        // TODO add your handling code here:
        new SUPORTE().setVisible(true);
    }//GEN-LAST:event_jRadioButtonMenuItem2ActionPerformed

    private void jRadioButtonMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jRadioButtonMenuItem1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String usuarioAntigo = txtUsuar1.getText();
        String senhaAnti = passNewSen2.getText();
        //e nova senha aqui n seria o novo usuario
        String usuarioNovo = txtNewUsuario.getText();
        String senhaNova = txtNovaSenha.getText();

        try {
            // TODO add your handling code here:
            Connection conexao = new dao.Conexao().getConnection();
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);

            // Verificar se o usuário e senha antigos existem no banco de dados
            Usuario buscarUsuario = usuarioDAO.buscarUsuario(usuarioAntigo);

            if (buscarUsuario != null) {
                // Atualizar os dados do usuário existente com os novos valores
                buscarUsuario.setUsuario(usuarioNovo);
                buscarUsuario.setSenha(senhaNova);

                // Atualizar o usuário no banco de dados
                usuarioDAO.update(buscarUsuario);

                //Limpar o campo de texto
                txtNewUsuario.setText("");
                txtNovaSenha.setText("");
                txtUsuar1.setText("");
                passNewSen2.setText("");

                // Informar ao usuário que os dados foram atualizados com sucesso
                JOptionPane.showMessageDialog(this, "Dados atualizados com sucesso!");
            } else {
                // Informar ao usuário que o usuário e senha antigos não foram encontrados
                JOptionPane.showMessageDialog(this, "Usuário e senha não encontrados!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(alteraUSU.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        txtNewUsuario.setText("");
        txtNovaSenha.setText("");
        txtUsuar1.setText("");
        passNewSen2.setText("");
        JOptionPane.showMessageDialog(null, "O Cancelamento foi efetuado com Sucessor! ");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButtonMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem3ActionPerformed
        // TODO add your handling code here:
        new Informaçoes().setVisible(true);
    }//GEN-LAST:event_jRadioButtonMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(alteraUSU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(alteraUSU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(alteraUSU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(alteraUSU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new alteraUSU().setVisible(true);
            }
        });
    }

    public JPasswordField getPassNewSen2() {
        return (JPasswordField) passNewSen2;
    }

    public void setPassNewSen2(JPasswordField passNewSen2) {
        this.passNewSen2 = passNewSen2;
    }

    public JTextField getTxtUsuar1() {
        return txtUsuar1;
    }

    public void setTxtUsuar1(JTextField txtUsuar1) {
        this.txtUsuar1 = txtUsuar1;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem3;
    private javax.swing.JTextField passNewSen2;
    private javax.swing.JTextField txtNewUsuario;
    private javax.swing.JTextField txtNovaSenha;
    private javax.swing.JTextField txtUsuar1;
    // End of variables declaration//GEN-END:variables
}
