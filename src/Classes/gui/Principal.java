/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.gui;

import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Rocha
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
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

        jDesktopPanePrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        BotaoPrincipalCriarTurma = new javax.swing.JMenuItem();
        BotaoPrincipalAtualizarTurmas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu principal");

        jDesktopPanePrincipal.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jDesktopPanePrincipalAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jDesktopPanePrincipalLayout = new javax.swing.GroupLayout(jDesktopPanePrincipal);
        jDesktopPanePrincipal.setLayout(jDesktopPanePrincipalLayout);
        jDesktopPanePrincipalLayout.setHorizontalGroup(
            jDesktopPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 886, Short.MAX_VALUE)
        );
        jDesktopPanePrincipalLayout.setVerticalGroup(
            jDesktopPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );

        jMenu1.setText("Turmas");

        BotaoPrincipalCriarTurma.setText("Criar turma");
        BotaoPrincipalCriarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoPrincipalCriarTurmaActionPerformed(evt);
            }
        });
        jMenu1.add(BotaoPrincipalCriarTurma);

        BotaoPrincipalAtualizarTurmas.setText("Atualizar turma");
        BotaoPrincipalAtualizarTurmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoPrincipalAtualizarTurmasActionPerformed(evt);
            }
        });
        jMenu1.add(BotaoPrincipalAtualizarTurmas);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPanePrincipal)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPanePrincipal)
                .addContainerGap())
        );

        setBounds(0, 0, 922, 472);
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoPrincipalCriarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoPrincipalCriarTurmaActionPerformed
        // TODO add your handling code here:
        
        CriarTurmaGUI ctg = new CriarTurmaGUI();
        
        jDesktopPanePrincipal.add(ctg);
        
        ctg.setVisible(true);
        
        
        /*
        CriarTurmaGUI ctg = new CriarTurmaGUI();
        Principal pg = new Principal();

        ctg.setVisible(true);
        pg.setVisible(false);*/
    }//GEN-LAST:event_BotaoPrincipalCriarTurmaActionPerformed

    private void BotaoPrincipalAtualizarTurmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoPrincipalAtualizarTurmasActionPerformed
        // TODO add your handling code here:
        AtualizarTurmasGUI atg = new AtualizarTurmasGUI();
        jDesktopPanePrincipal.add(atg);
        
        atg.setVisible(true);
        

        
        
    }//GEN-LAST:event_BotaoPrincipalAtualizarTurmasActionPerformed

    private void jDesktopPanePrincipalAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jDesktopPanePrincipalAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jDesktopPanePrincipalAncestorAdded

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem BotaoPrincipalAtualizarTurmas;
    private javax.swing.JMenuItem BotaoPrincipalCriarTurma;
    private javax.swing.JDesktopPane jDesktopPanePrincipal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
