package dialogue;

import controle.modele.ModeleLigneFacture;
import entite.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;

public class FenFacture extends javax.swing.JFrame {
    private static String code_article = "";
    private static String code_client = "";
    private static String code_facture = randomfactureNumber();
    private ModeleLigneFacture leModelLigneFacture =
            new ModeleLigneFacture(code_facture);
    private ModeReglement mode = new ModeReglement();
    private double total_ttc;

    public FenFacture() {
        initComponents();
        remplirCmBModeReglement();
    }

    private static String randomfactureNumber() {
        String num = "";
        Random rand = new Random();
        num += "FAC" + rand.nextInt(999999);
        return num;
    }
    private void remplirCmBModeReglement() {
        for (ModeReglement unMode :
                mode.getLesEnreg()) {
            jCmB_ModeReglement.addItem(unMode.getType());
        }
    }
    public static void setCode_article(String code_article) {
        FenFacture.code_article = code_article;
    }
    public static void setCode_client(String code_client) {
        FenFacture.code_client = code_client;
    }
    public static void setjTxT_NomClient(String nom) {
        FenFacture.jTxT_NomClient.setText(nom);
    }
    public static void setjTxT_CodeArticle(String code) {
        FenFacture.jTxT_CodeArticle.setText(code);
    }
    public static void setjTxT_CodeCategorie(String categorie) {
        FenFacture.jTxT_CodeCategorie.setText(categorie);
    }
    public static void setjTxT_Designation(String designation) {
        FenFacture.jTxT_Designation.setText(designation);
    }
    public static void setjCmB_Quantite(int max) {
        JCmB_Quantite.removeAllItems();
        for (int i = 1; i <= max; i++) {
            JCmB_Quantite.addItem(i);
        }
    }
    public static void setjTxT_Montant(String montant) {
        FenFacture.jTxT_Montant.setText(montant);
    }
    private String afficheDateJour() {
        Date date = new Date();
        SimpleDateFormat today = new SimpleDateFormat("dd/MM/yyyy");
        String dateJour = today.format(date);
        return dateJour;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable(leModelLigneFacture );
        jLab_Fichier = new javax.swing.JLabel();
        jLab_SupprimerLigne = new javax.swing.JLabel();
        jLab_SupprimerTout = new javax.swing.JLabel();
        jLab_Retour = new javax.swing.JLabel();
        jLab_ModeReglement = new javax.swing.JLabel();
        jLab_Fond = new javax.swing.JLabel();
        jLab_BandeauFacture = new javax.swing.JLabel();
        jLab_NomClient = new javax.swing.JLabel();
        jTxT_NomClient = new javax.swing.JTextField();
        jLab_NumDocument = new javax.swing.JLabel();
        jLab_DateJour = new javax.swing.JLabel();
        jLab_BandeauHaut = new javax.swing.JLabel();
        jBTN_Articles = new javax.swing.JButton();
        jLab_CodeArticle = new javax.swing.JLabel();
        jTxT_CodeArticle = new javax.swing.JTextField();
        jLab_Quantite = new javax.swing.JLabel();
        JCmB_Quantite = new javax.swing.JComboBox();
        jCB_NumDocument = new javax.swing.JComboBox();
        jLab_Designation = new javax.swing.JLabel();
        jLab_Montant = new javax.swing.JLabel();
        jLab_CodeCategorie = new javax.swing.JLabel();
        jTxT_Designation = new javax.swing.JTextField();
        jTxT_Montant = new javax.swing.JTextField();
        jTxT_CodeCategorie = new javax.swing.JTextField();
        jBTN_Ajouter = new javax.swing.JButton();
        jBTN_Modifier = new javax.swing.JButton();
        jLab_TotalTTC = new javax.swing.JLabel();
        jLab_EtiTotalTTC = new javax.swing.JLabel();
        jBTN_Valider = new javax.swing.JButton();
        jCmB_ModeReglement = new javax.swing.JComboBox();
        jTxT_DateJour = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 412));
        jScrollPane1.setViewportView(jTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 275, 742, 210));

        jLab_Fichier.setForeground(new java.awt.Color(255, 255, 255));
        jLab_Fichier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/ods.png"))); // NOI18N
        jLab_Fichier.setText("Fichier des factures");
        jLab_Fichier.setToolTipText("");
        jLab_Fichier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLab_FichierMouseClicked(evt);
            }
        });
        getContentPane().add(jLab_Fichier, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLab_SupprimerLigne.setForeground(new java.awt.Color(255, 255, 255));
        jLab_SupprimerLigne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/supprimer2.png"))); // NOI18N
        jLab_SupprimerLigne.setText("Supprimer une ligne");
        jLab_SupprimerLigne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLab_SupprimerLigneMouseClicked(evt);
            }
        });
        getContentPane().add(jLab_SupprimerLigne, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLab_SupprimerTout.setForeground(new java.awt.Color(255, 255, 255));
        jLab_SupprimerTout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/supprimer.png"))); // NOI18N
        jLab_SupprimerTout.setText("Supprimer toutes les lignes");
        jLab_SupprimerTout.setToolTipText("");
        jLab_SupprimerTout.setName("");
        jLab_SupprimerTout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLab_SupprimerToutMouseClicked(evt);
            }
        });
        getContentPane().add(jLab_SupprimerTout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLab_Retour.setForeground(new java.awt.Color(255, 255, 255));
        jLab_Retour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/retour.png"))); // NOI18N
        jLab_Retour.setText("Menu principal");
        jLab_Retour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLab_RetourMouseClicked(evt);
            }
        });
        getContentPane().add(jLab_Retour, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

        jLab_ModeReglement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/carte.png"))); // NOI18N
        jLab_ModeReglement.setText("Mode de règlement");
        getContentPane().add(jLab_ModeReglement, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, 140, -1));

        jLab_Fond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fond/fondGeneral.jpg"))); // NOI18N
        getContentPane().add(jLab_Fond, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -100, 240, 710));

        jLab_BandeauFacture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/barre.png"))); // NOI18N
        getContentPane().add(jLab_BandeauFacture, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 730, 40));

        jLab_NomClient.setText("Nom du client");
        getContentPane().add(jLab_NomClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));

        jTxT_NomClient.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTxT_NomClient.setText("[ Cliquez ici pour sélectionner un client ]");
        jTxT_NomClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTxT_NomClientMouseClicked(evt);
            }
        });
        getContentPane().add(jTxT_NomClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 270, -1));

        jLab_NumDocument.setText("Numéro du document");
        jLab_NumDocument.setToolTipText("");
        getContentPane().add(jLab_NumDocument, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, -1, -1));

        jLab_DateJour.setText("Date du jour");
        getContentPane().add(jLab_DateJour, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 60, -1, -1));

        jLab_BandeauHaut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/barre.png"))); // NOI18N
        getContentPane().add(jLab_BandeauHaut, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 730, 40));

        jBTN_Articles.setText("Parcourir les articles");
        jBTN_Articles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTN_ArticlesActionPerformed(evt);
            }
        });
        getContentPane().add(jBTN_Articles, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, -1, -1));

        jLab_CodeArticle.setText("Code");
        jLab_CodeArticle.setToolTipText("");
        getContentPane().add(jLab_CodeArticle, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, -1, -1));
        getContentPane().add(jTxT_CodeArticle, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 80, -1));

        jLab_Quantite.setText("Quantité");
        getContentPane().add(jLab_Quantite, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, -1, -1));

        JCmB_Quantite.setOpaque(false);
        getContentPane().add(JCmB_Quantite, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, -1, -1));

        getContentPane().add(jCB_NumDocument, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, -1, -1));

        jLab_Designation.setText("Désignation");
        jLab_Designation.setToolTipText("");
        getContentPane().add(jLab_Designation, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));

        jLab_Montant.setText("Montant");
        getContentPane().add(jLab_Montant, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, -1, -1));

        jLab_CodeCategorie.setText("Code catégorie");
        getContentPane().add(jLab_CodeCategorie, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 200, -1, -1));
        getContentPane().add(jTxT_Designation, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 290, -1));
        getContentPane().add(jTxT_Montant, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 90, -1));
        getContentPane().add(jTxT_CodeCategorie, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 200, 70, -1));

        jBTN_Ajouter.setText("Ajouter");
        jBTN_Ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTN_AjouterActionPerformed(evt);
            }
        });
        getContentPane().add(jBTN_Ajouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 240, -1, -1));

        jBTN_Modifier.setText("Modifier");
        getContentPane().add(jBTN_Modifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 240, -1, -1));

        jLab_TotalTTC.setText("Total : ");
        getContentPane().add(jLab_TotalTTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 510, 120, -1));

        jLab_EtiTotalTTC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/etiquette.png"))); // NOI18N
        jLab_EtiTotalTTC.setToolTipText("");
        getContentPane().add(jLab_EtiTotalTTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 500, -1, -1));


        jBTN_Valider.setText("Valider la facture");
        jBTN_Valider.setToolTipText("");
        jBTN_Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTN_ValiderActionPerformed(evt);
            }
        });
        getContentPane().add(jBTN_Valider, new org.netbeans.lib.awtextra.AbsoluteConstraints(823, 500, 160, -1));
        getContentPane().add(jCmB_ModeReglement, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 80, -1));

        jTxT_DateJour.setEditable(false);
        jTxT_DateJour.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTxT_DateJour.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTxT_DateJour.setText(afficheDateJour());
        jTxT_DateJour.setFocusable(false);
        getContentPane().add(jTxT_DateJour, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 80, 90, -1));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1017)/2, (screenSize.height-591)/2, 1017, 591);
    }// </editor-fold>//GEN-END:initComponents

    private void jLab_RetourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab_RetourMouseClicked
        if (JOptionPane.showConfirmDialog(null,
                "Abandon de la saisie ? ",
                "Confirmation", 
                           JOptionPane.YES_NO_OPTION) == 0) {
            LignesFacture lesLignes = 
                    new LignesFacture();
            lesLignes.supprimerToutCRUD(code_facture,
                    "code_facture");
            leModelLigneFacture.supprimerTous();
            jTxT_NomClient.setText
               ("[ Cliquez ici pour sélectionner un client ]");
            jLab_TotalTTC.setText("");
            code_facture= randomfactureNumber();
            dispose();
        }
    }//GEN-LAST:event_jLab_RetourMouseClicked

    private void jTxT_NomClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTxT_NomClientMouseClicked
        FenChoixClient choix =
                new FenChoixClient(this, rootPaneCheckingEnabled);
        choix.setModal(true);
        choix.setLocationRelativeTo(choix.getParent());
        choix.setVisible(true);
    }//GEN-LAST:event_jTxT_NomClientMouseClicked

    private void jBTN_ArticlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTN_ArticlesActionPerformed
        FenChoixArticle choix =
                new FenChoixArticle(this, rootPaneCheckingEnabled);
        choix.setModal(true);
        choix.setLocationRelativeTo(choix.getParent());
        choix.setVisible(true);
    }//GEN-LAST:event_jBTN_ArticlesActionPerformed

    private void jBTN_AjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTN_AjouterActionPerformed
        if (jTxT_CodeArticle.getText().isEmpty()
                || (code_client.equals(""))) {
            JOptionPane.showMessageDialog(null,
                    "Vérifiez vos choix !");
        } else {
            int quantite = Integer.parseInt(JCmB_Quantite.getSelectedItem().toString());
            if (quantite > 0) {
                double pu = Double.valueOf(jTxT_Montant.getText());
                LignesFacture uneLigne = new LignesFacture(
                        code_facture,
                        new Article(jTxT_CodeArticle.getText(),
                        jTxT_CodeCategorie.getText(),
                        jTxT_Designation.getText(),
                        quantite,
                        pu,
                        new Date()),
                        quantite,
                        pu,
                        quantite * pu);
                boolean is_created = uneLigne.creerCRUD(code_facture,
                        jTxT_CodeArticle.getText(),
                        quantite, pu, quantite * pu);
                if (is_created) {
                    leModelLigneFacture.creerMOD(uneLigne);
                }
                jLab_TotalTTC.setText(calculeTotal());
                jTxT_CodeArticle.setText("");
                jTxT_Designation.setText("");
                jTxT_Montant.setText("");
                JCmB_Quantite.removeAllItems();
            }
        }
    }//GEN-LAST:event_jBTN_AjouterActionPerformed

    private void jBTN_ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTN_ValiderActionPerformed
        if (jTable.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null,
                    "Une facture doit avoir au moins "
                    + "un article pour être validée.",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (code_client.equals("")) {
                JOptionPane.showMessageDialog(null,
                        "Vous devez sélectionner"
                        + " un client pour continuer.",
                        "Erreur", JOptionPane.WARNING_MESSAGE);
            } else {
                int code_mode_reglement = mode.getLesEnreg().get(jCmB_ModeReglement.getSelectedIndex()).getCode();
                String nom_reglement = mode.getLesEnreg().get(jCmB_ModeReglement.getSelectedIndex()).getType();
                Facture facture = new Facture(code_facture,
                        new Client(code_client), total_ttc,
                        new ModeReglement(code_mode_reglement,
                        nom_reglement), new Date());
                facture.creerCRUD(code_facture, code_client,
                        total_ttc, code_mode_reglement);
                jTxT_NomClient.setText("[ Cliquez ici pour sélectionner un client ]");
                leModelLigneFacture.supprimerTous();
                code_facture = randomfactureNumber();
                jLab_TotalTTC.setText("");
            }
        }
    }//GEN-LAST:event_jBTN_ValiderActionPerformed

    private void jLab_SupprimerLigneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab_SupprimerLigneMouseClicked
        if (jTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null,
                    "Vous devez sélectionner "
                    + "une ligne pour la supprimer.",
                    "Suppression",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (JOptionPane.showConfirmDialog(null,
                    "Souhaitez-vous vraiment supprimer"
                    + " cette ligne de la facture ?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION) == 0) {
                int numLigne = jTable.getSelectedRow();
                String codeArticle = jTable.getValueAt(numLigne, 0).toString();
                LignesFacture uneLigne =
                        new LignesFacture();
                uneLigne.supprimerLigneCRUD(code_facture, codeArticle);
                leModelLigneFacture.supprimerMOD(numLigne);
            }
        }
    }//GEN-LAST:event_jLab_SupprimerLigneMouseClicked

    private void jLab_SupprimerToutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab_SupprimerToutMouseClicked
        if (JOptionPane.showConfirmDialog(null,
                "Souhaitez-vous "
                + "vraiment supprimer "
                + "tous les articles présents"
                + " dans cette facture ?",
                "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
            LignesFacture lesLignes = new LignesFacture();
            lesLignes.supprimerToutCRUD(code_facture,
                    "code_facture");
            leModelLigneFacture.supprimerTous();
            code_facture = randomfactureNumber();
        }
    }//GEN-LAST:event_jLab_SupprimerToutMouseClicked

    private void jLab_FichierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab_FichierMouseClicked
        FenTableFacture laFenetre = new FenTableFacture();
        laFenetre.setVisible(true);
    }//GEN-LAST:event_jLab_FichierMouseClicked

    private String calculeTotal() {
        String total = "";
        try {
            DecimalFormat format = new DecimalFormat("#,##0.00");
            total_ttc = 0.0;
            for (int i = 0; i < jTable.getRowCount(); i++) {
                total_ttc += Double.valueOf(jTable.getValueAt(i, 5).toString());
            }
            total = "Total : " + format.format(total_ttc) + " ";
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Erreur de format de nombre");
        }
        return total;
    }

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
            java.util.logging.Logger.getLogger(FenFacture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FenFacture().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JComboBox JCmB_Quantite;
    private javax.swing.JButton jBTN_Ajouter;
    private javax.swing.JButton jBTN_Articles;
    private javax.swing.JButton jBTN_Modifier;
    private javax.swing.JButton jBTN_Valider;
    private javax.swing.JComboBox jCB_NumDocument;
    private javax.swing.JComboBox jCmB_ModeReglement;
    private javax.swing.JLabel jLab_BandeauFacture;
    private javax.swing.JLabel jLab_BandeauHaut;
    private javax.swing.JLabel jLab_CodeArticle;
    private javax.swing.JLabel jLab_CodeCategorie;
    private javax.swing.JLabel jLab_DateJour;
    private javax.swing.JLabel jLab_Designation;
    private javax.swing.JLabel jLab_EtiTotalTTC;
    private javax.swing.JLabel jLab_Fichier;
    private javax.swing.JLabel jLab_Fond;
    private javax.swing.JLabel jLab_ModeReglement;
    private javax.swing.JLabel jLab_Montant;
    private javax.swing.JLabel jLab_NomClient;
    private javax.swing.JLabel jLab_NumDocument;
    private javax.swing.JLabel jLab_Quantite;
    private javax.swing.JLabel jLab_Retour;
    private javax.swing.JLabel jLab_SupprimerLigne;
    private javax.swing.JLabel jLab_SupprimerTout;
    private javax.swing.JLabel jLab_TotalTTC;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private static javax.swing.JTextField jTxT_CodeArticle;
    private static javax.swing.JTextField jTxT_CodeCategorie;
    private javax.swing.JTextField jTxT_DateJour;
    private static javax.swing.JTextField jTxT_Designation;
    private static javax.swing.JTextField jTxT_Montant;
    private static javax.swing.JTextField jTxT_NomClient;
    // End of variables declaration//GEN-END:variables
}
