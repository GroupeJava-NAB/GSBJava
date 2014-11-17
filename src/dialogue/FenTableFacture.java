package dialogue;

// import controle.etat.JasperMySQL_Parametres;
import controle.modele.ModeleFacture;
import entite.Facture;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FenTableFacture extends javax.swing.JFrame {
    private ModeleFacture leModeleFacture = new ModeleFacture();
    private String code_facture;

    public FenTableFacture() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable(leModeleFacture);
        jLab_Imprimer = new javax.swing.JLabel();
        jLab_Aperçu = new javax.swing.JLabel();
        jLab_Exporter = new javax.swing.JLabel();
        jLab_Supprimer = new javax.swing.JLabel();
        jLab_Retour = new javax.swing.JLabel();
        jLab_TitreFacture = new javax.swing.JLabel();
        jLab_Recherche = new javax.swing.JLabel();
        jTxT_Recherche = new javax.swing.JTextField();
        jBTN_CalculeTotal = new javax.swing.JButton();
        jTxT_Total = new javax.swing.JTextField();
        jLab_Fond = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 412));

        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 85, 742, 400));

        jLab_Imprimer.setForeground(new java.awt.Color(255, 255, 255));
        jLab_Imprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/imprimer2.png"))); // NOI18N
        jLab_Imprimer.setText("Imprimer");
        jLab_Imprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLab_ImprimerMouseClicked(evt);
            }
        });
        getContentPane().add(jLab_Imprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLab_Aperçu.setForeground(new java.awt.Color(255, 255, 255));
        jLab_Aperçu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/apercu4.png"))); // NOI18N
        jLab_Aperçu.setText("Aperçu");
        jLab_Aperçu.setToolTipText("");
        jLab_Aperçu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLab_AperçuMouseClicked(evt);
            }
        });
        getContentPane().add(jLab_Aperçu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLab_Exporter.setForeground(new java.awt.Color(255, 255, 255));
        jLab_Exporter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/export3.png"))); // NOI18N
        jLab_Exporter.setText("Exporter");
        jLab_Exporter.setToolTipText("");
        jLab_Exporter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLab_ExporterMouseClicked(evt);
            }
        });
        getContentPane().add(jLab_Exporter, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLab_Supprimer.setForeground(new java.awt.Color(255, 255, 255));
        jLab_Supprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/supprimer2.png"))); // NOI18N
        jLab_Supprimer.setText("Supprimer");
        jLab_Supprimer.setToolTipText("");
        jLab_Supprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLab_SupprimerMouseClicked(evt);
            }
        });
        getContentPane().add(jLab_Supprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLab_Retour.setForeground(new java.awt.Color(255, 255, 255));
        jLab_Retour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/retour.png"))); // NOI18N
        jLab_Retour.setText("Retour");
        jLab_Retour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLab_RetourMouseClicked(evt);
            }
        });
        getContentPane().add(jLab_Retour, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLab_TitreFacture.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLab_TitreFacture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/odt.png"))); // NOI18N
        jLab_TitreFacture.setText("Gestion des factures");
        jLab_TitreFacture.setToolTipText("");
        getContentPane().add(jLab_TitreFacture, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jLab_Recherche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/chercheAssiste.png"))); // NOI18N
        jLab_Recherche.setText("Rechercher une facture");
        jLab_Recherche.setToolTipText("");
        getContentPane().add(jLab_Recherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 500, 180, -1));

        jTxT_Recherche.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxT_RechercheKeyReleased(evt);
            }
        });
        getContentPane().add(jTxT_Recherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 500, 140, 30));

        jBTN_CalculeTotal.setText("Total");
        jBTN_CalculeTotal.setToolTipText("");
        jBTN_CalculeTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTN_CalculeTotalActionPerformed(evt);
            }
        });
        getContentPane().add(jBTN_CalculeTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, -1, -1));

        jTxT_Total.setEditable(false);
        jTxT_Total.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTxT_Total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxT_Total.setFocusable(false);
        getContentPane().add(jTxT_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, 120, 30));

        jLab_Fond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fond/fondGeneral.jpg"))); // NOI18N
        getContentPane().add(jLab_Fond, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -100, 1000, 710));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1017)/2, (screenSize.height-591)/2, 1017, 591);
    }// </editor-fold>//GEN-END:initComponents

    private void jLab_RetourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab_RetourMouseClicked
        dispose();
    }//GEN-LAST:event_jLab_RetourMouseClicked

    private void jLab_SupprimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab_SupprimerMouseClicked
        if (jTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null,
                    "Vous devez sélectionner "
                    + "une facture pour la supprimer.");
        } else {
            if (JOptionPane.showConfirmDialog(null,
                    "Souhaitez-vous vraiment "
                    + "supprimer cette facture ?",
                    "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
                int ligne_a_supprimer = jTable.getSelectedRow();
                Facture uneFacture = new Facture("");
                uneFacture.supprimerCRUD(code_facture);
                leModeleFacture.supprimerMOD(ligne_a_supprimer);
            }
        }
    }//GEN-LAST:event_jLab_SupprimerMouseClicked

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        int line = jTable.getSelectedRow();
        code_facture = jTable.getValueAt(line, 0).toString();
    }//GEN-LAST:event_jTableMouseClicked

    private void jTxT_RechercheKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxT_RechercheKeyReleased
        Facture facture = new Facture("");
        ArrayList<Facture> lesFactures =
                facture.chercherCRUD(jTxT_Recherche.getText());
        leModeleFacture.lireRecupMOD(lesFactures);
    }//GEN-LAST:event_jTxT_RechercheKeyReleased

    private void jBTN_CalculeTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTN_CalculeTotalActionPerformed
        double total = 0;
        DecimalFormat leFormat = new DecimalFormat("#,##0.00");
        for (int i = 0; i < jTable.getRowCount(); i++) {
            total += Double.parseDouble(jTable.getValueAt(i, 3).toString());
        }
        jTxT_Total.setText(leFormat.format(total) + " €");
    }//GEN-LAST:event_jBTN_CalculeTotalActionPerformed

    private void jLab_AperçuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab_AperçuMouseClicked
        if (jTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, 
                    "Vous devez sélectionner"
                    + " une facture pour afficher l'aperçu.");
        } else {
            //JasperMySQL_Parametres.setCode_facture(code_facture);
            //JasperMySQL_Parametres.apercu("Facture.jrxml");
        }
    }//GEN-LAST:event_jLab_AperçuMouseClicked

    private void jLab_ImprimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab_ImprimerMouseClicked
        if (jTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, 
                    "Vous devez sélectionner "
                    + "une facture pour l'imprimer");
        } else {
           //JasperMySQL_Parametres.setCode_facture(code_facture);
           //JasperMySQL_Parametres.imprimer("Facture.jrxml");
        }
    }//GEN-LAST:event_jLab_ImprimerMouseClicked

    private void jLab_ExporterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab_ExporterMouseClicked
        if (jTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, 
                    "Vous devez sélectionner "
                    + "une facture pour l'exporter.");
        } else {
            JasperMySQL_Parametres.setCode_facture(code_facture);
            FenExport export = new FenExport("Facture.jrxml");
            export.setLocationRelativeTo(export.getParent());
            export.setModal(true);
            export.setVisible(true);
        }
    }//GEN-LAST:event_jLab_ExporterMouseClicked

    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Minus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;




                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenTableFacture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FenTableFacture().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBTN_CalculeTotal;
    private javax.swing.JLabel jLab_Aperçu;
    private javax.swing.JLabel jLab_Exporter;
    private javax.swing.JLabel jLab_Fond;
    private javax.swing.JLabel jLab_Imprimer;
    private javax.swing.JLabel jLab_Recherche;
    private javax.swing.JLabel jLab_Retour;
    private javax.swing.JLabel jLab_Supprimer;
    private javax.swing.JLabel jLab_TitreFacture;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTxT_Recherche;
    private javax.swing.JTextField jTxT_Total;
    // End of variables declaration//GEN-END:variables
}
