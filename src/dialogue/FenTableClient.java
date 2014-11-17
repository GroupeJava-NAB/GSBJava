package dialogue;

//import controle.etat.JasperMySQL_Parametres;

import controle.modele.ModeleClient;
import controle.modele.RendererBooleen;
import controle.modele.RendererDate;
import controle.modele.RendererGras;
import controle.utilitaires.GestionDates;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class FenTableClient extends javax.swing.JFrame implements TableModelListener {
    private ModeleClient leModeleClients = new ModeleClient();

    @SuppressWarnings("LeakingThisInConstructor")
    public FenTableClient() {
        initComponents();
        table.getColumnModel().getColumn(1).setCellRenderer(new RendererGras());
        table.getColumnModel().getColumn(3).setCellRenderer(new RendererBooleen());
        table.getColumnModel().getColumn(4).setCellRenderer(new RendererDate());
        leModeleClients.addTableModelListener(this);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable(leModeleClients);
        jLab_Ajouter = new javax.swing.JLabel();
        jLab_Rechercher = new javax.swing.JLabel();
        jLab_Modifier = new javax.swing.JLabel();
        jLab_Supprimer = new javax.swing.JLabel();
        jLab_Aperçu = new javax.swing.JLabel();
        jLab_Imprimer = new javax.swing.JLabel();
        jLab_Exporter = new javax.swing.JLabel();
        jLab_Retour = new javax.swing.JLabel();
        jLabTitreClient = new javax.swing.JLabel();
        jLab_SousTitre = new javax.swing.JLabel();
        jLab_Trier = new javax.swing.JLabel();
        jCmBox_Trier = new javax.swing.JComboBox();
        jLab_Code = new javax.swing.JLabel();
        jLab_Nom = new javax.swing.JLabel();
        jLab_Adresse = new javax.swing.JLabel();
        jLab_CP = new javax.swing.JLabel();
        jLab_Telephone = new javax.swing.JLabel();
        jLab_Email = new javax.swing.JLabel();
        jLab_Remarques = new javax.swing.JLabel();
        jTxTCode = new javax.swing.JTextField();
        jTxTNom = new javax.swing.JTextField();
        jTXT_Adresse = new javax.swing.JTextField();
        jTXT_CP = new javax.swing.JTextField();
        jTXT_Telephone = new javax.swing.JTextField();
        jTXT_Email = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTXA_Remarque = new javax.swing.JTextArea();
        jLab_DateCreation = new javax.swing.JLabel();
        jLab_Prenom = new javax.swing.JLabel();
        jLab_Carte = new javax.swing.JLabel();
        jTxT_DateCreation = new javax.swing.JTextField();
        jTxT_Prenom = new javax.swing.JTextField();
        jLab_Ville = new javax.swing.JLabel();
        jLab_Mobilis = new javax.swing.JLabel();
        jTXT_Ville = new javax.swing.JTextField();
        jTXT_Mobilis = new javax.swing.JTextField();
        checkBox_Carte = new java.awt.Checkbox();
        jLab_fond_module = new javax.swing.JLabel();
        jLab_Fond = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 412));

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 742, 135));

        jLab_Ajouter.setForeground(new java.awt.Color(255, 255, 255));
        jLab_Ajouter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/ajouter.png"))); // NOI18N
        jLab_Ajouter.setText("Ajouter");
        jLab_Ajouter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLab_AjouterMouseClicked(evt);
            }
        });
        getContentPane().add(jLab_Ajouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLab_Rechercher.setForeground(new java.awt.Color(255, 255, 255));
        jLab_Rechercher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/chercher.png"))); // NOI18N
        jLab_Rechercher.setText("Rechercher");
        jLab_Rechercher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLab_RechercherMouseClicked(evt);
            }
        });
        getContentPane().add(jLab_Rechercher, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLab_Modifier.setForeground(new java.awt.Color(255, 255, 255));
        jLab_Modifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/modifier.png"))); // NOI18N
        jLab_Modifier.setText("Modifier");
        jLab_Modifier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLab_ModifierMouseClicked(evt);
            }
        });
        getContentPane().add(jLab_Modifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLab_Supprimer.setForeground(new java.awt.Color(255, 255, 255));
        jLab_Supprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/supprimer.png"))); // NOI18N
        jLab_Supprimer.setText("Supprimer");
        jLab_Supprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLab_SupprimerMouseClicked(evt);
            }
        });
        getContentPane().add(jLab_Supprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLab_Aperçu.setForeground(new java.awt.Color(255, 255, 255));
        jLab_Aperçu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/apercu2.png"))); // NOI18N
        jLab_Aperçu.setText("Aperçu");
        jLab_Aperçu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLab_AperçuMouseClicked(evt);
            }
        });
        getContentPane().add(jLab_Aperçu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jLab_Imprimer.setForeground(new java.awt.Color(255, 255, 255));
        jLab_Imprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/imprimer.png"))); // NOI18N
        jLab_Imprimer.setText("Imprimer");
        getContentPane().add(jLab_Imprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        jLab_Exporter.setForeground(new java.awt.Color(255, 255, 255));
        jLab_Exporter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/exporter.png"))); // NOI18N
        jLab_Exporter.setText("Exporter");
        getContentPane().add(jLab_Exporter, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        jLab_Retour.setForeground(new java.awt.Color(255, 255, 255));
        jLab_Retour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/retour.png"))); // NOI18N
        jLab_Retour.setText("Menu principal");
        jLab_Retour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLab_RetourMouseClicked(evt);
            }
        });
        getContentPane().add(jLab_Retour, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

        jLabTitreClient.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabTitreClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/clientTitre.png"))); // NOI18N
        jLabTitreClient.setText("Gestion des clients");
        jLabTitreClient.setToolTipText("");
        getContentPane().add(jLabTitreClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jLab_SousTitre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLab_SousTitre.setText("A j o u t,  m o d i f i c a t i o n,  su p p r e s s i o n,  c o n s u l t a t i o n   e t   i m p r e s s i o n");
        getContentPane().add(jLab_SousTitre, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, -1));

        jLab_Trier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/trier.png"))); // NOI18N
        jLab_Trier.setText("Trier");
        getContentPane().add(jLab_Trier, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 490, 100, -1));

        jCmBox_Trier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Code", "Nom", "Date de création", "Carte" }));
        getContentPane().add(jCmBox_Trier, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 500, 130, -1));

        jLab_Code.setText("Code");
        getContentPane().add(jLab_Code, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 90, -1));

        jLab_Nom.setText("Nom");
        getContentPane().add(jLab_Nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 90, -1));

        jLab_Adresse.setText("Adresse");
        getContentPane().add(jLab_Adresse, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 90, -1));

        jLab_CP.setText("Code postal");
        getContentPane().add(jLab_CP, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 90, -1));

        jLab_Telephone.setText("Tél. fixe");
        getContentPane().add(jLab_Telephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 80, -1));

        jLab_Email.setText("Email");
        getContentPane().add(jLab_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        jLab_Remarques.setText("Remarques");
        getContentPane().add(jLab_Remarques, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 80, -1));

        jTxTCode.setEditable(false);
        getContentPane().add(jTxTCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 240, -1));

        jTxTNom.setEditable(false);
        getContentPane().add(jTxTNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 240, -1));

        jTXT_Adresse.setEditable(false);
        getContentPane().add(jTXT_Adresse, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 600, -1));

        jTXT_CP.setEditable(false);
        getContentPane().add(jTXT_CP, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 240, -1));

        jTXT_Telephone.setEditable(false);
        getContentPane().add(jTXT_Telephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 240, -1));

        jTXT_Email.setEditable(false);
        getContentPane().add(jTXT_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 240, -1));

        jTXA_Remarque.setColumns(20);
        jTXA_Remarque.setEditable(false);
        jTXA_Remarque.setRows(5);
        jScrollPane2.setViewportView(jTXA_Remarque);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 620, 60));

        jLab_DateCreation.setText("Date création");
        getContentPane().add(jLab_DateCreation, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 80, -1));

        jLab_Prenom.setText("Prénom");
        getContentPane().add(jLab_Prenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 80, -1));

        jLab_Carte.setText("Carte fidélité");
        getContentPane().add(jLab_Carte, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 80, -1));

        jTxT_DateCreation.setEditable(false);
        jTxT_DateCreation.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jTxT_DateCreation, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, 120, -1));

        jTxT_Prenom.setEditable(false);
        getContentPane().add(jTxT_Prenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, 250, -1));

        jLab_Ville.setText("Ville");
        getContentPane().add(jLab_Ville, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, -1, -1));

        jLab_Mobilis.setText("Mobilis");
        getContentPane().add(jLab_Mobilis, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, 50, -1));

        jTXT_Ville.setEditable(false);
        getContentPane().add(jTXT_Ville, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 190, 250, -1));

        jTXT_Mobilis.setEditable(false);
        getContentPane().add(jTXT_Mobilis, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, 250, -1));

        checkBox_Carte.setEnabled(false);
        getContentPane().add(checkBox_Carte, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 100, 20, -1));

        jLab_fond_module.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion/fondModule.png"))); // NOI18N
        getContentPane().add(jLab_fond_module, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 750, 290));

        jLab_Fond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fond/fondGeneral.jpg"))); // NOI18N
        getContentPane().add(jLab_Fond, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -100, 1000, 710));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1017)/2, (screenSize.height-591)/2, 1017, 591);
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int NumLigne;
        NumLigne = table.getSelectedRow();
        jTxTCode.setText(String.valueOf(table.getValueAt(NumLigne, 0)));
        jTxTNom.setText(String.valueOf(table.getValueAt(NumLigne, 1)));
        jTxT_Prenom.setText(String.valueOf(table.getValueAt(NumLigne, 2)));
        String stateCarte = String.valueOf(table.getValueAt(NumLigne, 3));
        if (stateCarte.equals("true")) {
            checkBox_Carte.setState(true);
        } else {
            checkBox_Carte.setState(false);
        }
        String strDate = String.valueOf(table.getValueAt(NumLigne, 4));
        jTxT_DateCreation.setText(strDate);
        if (evt.getClickCount() == 2) {
            prepaModification();
        }
    }//GEN-LAST:event_tableMouseClicked

    private void jLab_AjouterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab_AjouterMouseClicked
        FenFicheClient laFenetre =
                new FenFicheClient(leModeleClients,
                "Ajouter");
        laFenetre.getjLabTitreClient().setText("Ajout d'un client");
        laFenetre.getjLab_Action().setIcon(new ImageIcon(FenFicheClient
                .class.getResource("/images/gestion/ajouter.png")));
        laFenetre.getjLab_Action().setText("Sauvegarder");
        laFenetre.getjTxTCode().requestFocus(true);
        Date dtDate = new Date();
        String strDate = GestionDates.dateEnChaineFR(dtDate);
        laFenetre.getjTxT_DateCreation().setText(strDate);
        laFenetre.getjTxT_DateCreation().setEditable(false);
        laFenetre.setVisible(true);
    }//GEN-LAST:event_jLab_AjouterMouseClicked

    private void jLab_ModifierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab_ModifierMouseClicked
        prepaModification();
    }//GEN-LAST:event_jLab_ModifierMouseClicked

    private void jLab_SupprimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab_SupprimerMouseClicked
        int NumLigne = -1;
        NumLigne = table.getSelectedRow();
        if (NumLigne != -1) {
            int choix = JOptionPane.showConfirmDialog(null,
                    "Voulez-vous supprimer "
                    + "la fiche du client ?"
                    + "\ncode : " + table.getValueAt(NumLigne, 0)
                    + "\nnom  : " + table.getValueAt(NumLigne, 1),
                    "SUPPRESSION", JOptionPane.YES_NO_OPTION);
            if (choix == 0) {
                String vCode;
                vCode = String.valueOf(table.getValueAt(NumLigne, 0));
                entite.Client leClient = new entite.Client(vCode);
                boolean bSuppression = leClient.supprimerCRUD(vCode);
                if (bSuppression) {
                    leModeleClients.supprimerMOD(NumLigne);
                }
            }
        }
        if (NumLigne == -1) {
            JOptionPane.showMessageDialog(null,
                    "Sélectionnez une ligne avant.",
                    "Suppression",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jLab_SupprimerMouseClicked

    private void jLab_RechercherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab_RechercherMouseClicked
        FenFicheClient laFenetre =
                new FenFicheClient(leModeleClients, "Rechercher");
        laFenetre.getjLab_Action().setText("Rechercher");
        laFenetre.getjLab_Action().setIcon(new ImageIcon(FenFicheClient.class
                .getResource("/images/gestion/ajouter.png")));
        laFenetre.getjLabTitreClient().setText("Recherche de client(s)");
        laFenetre.setVisible(true);
    }//GEN-LAST:event_jLab_RechercherMouseClicked

    private void jLab_RetourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab_RetourMouseClicked
        dispose();
    }//GEN-LAST:event_jLab_RetourMouseClicked

    private void jLab_AperçuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab_AperçuMouseClicked
         // code commenté
//JasperMySQL_Parametres.apercu("EtatClients.jrxml");
    }//GEN-LAST:event_jLab_AperçuMouseClicked

    private void prepaModification() {
        int NumLigne = -1;
        NumLigne = table.getSelectedRow();
        if (NumLigne == -1) {
            JOptionPane.showMessageDialog(null,
                    "Sélectionnez auparavant"
                    + " la ligne à modifier"
                    + '\n'
                    + "ou effectuez "
                    + "un double-clic sur la ligne.",
                    "MODIFICATION", JOptionPane.INFORMATION_MESSAGE);
        }
        if (NumLigne != -1) {
            String vCode = String.valueOf(table.getValueAt(NumLigne, 0));
            String vNom = String.valueOf(table.getValueAt(NumLigne, 1));
            String vPrenom = String.valueOf(table.getValueAt(NumLigne, 2));
            String vCarte = String.valueOf(table.getValueAt(NumLigne, 3));
            String vDate = String.valueOf(table.getValueAt(NumLigne, 4));
            boolean bCarte = false;
            if (vCarte.equals("true")) {
                bCarte = true;
            } else {
                bCarte = false;
            }
            vDate = GestionDates.chaineDateENversFR(vDate);
            FenFicheClient laFenetre =
                    new FenFicheClient(leModeleClients,
                    "Modifier");
            laFenetre.setjTxTCode(vCode);
            laFenetre.setjTxTNom(vNom);
            laFenetre.setjTxT_Prenom(vPrenom);
            laFenetre.setCheckBox_Carte(bCarte);
            laFenetre.setjTxT_DateCreation(vDate);
            laFenetre.getjTxTCode().setEditable(false);           
            laFenetre.getjLabTitreClient().setText("Modification d'un client");
            laFenetre.getjLab_Action().setText("Sauvegarder");
            laFenetre.getjLab_Action().setIcon(new ImageIcon(FenFicheClient
                    .class.getResource("/images/gestion/modifier.png")));
            laFenetre.setVisible(
                    true);
        }
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
            java.util.logging.Logger.getLogger(FenTableClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FenTableClient().setVisible(true);
            }
        });
    }

    public void tableChanged(TableModelEvent unEvenement) {
        String suiteMessage = "\nFaisons d'autres actions"
                + " suite à cet événement.";
        switch (unEvenement.getType()) {
            case TableModelEvent.INSERT:
                System.out.println("La table a été mise à jour, "
                        + "il y a eu une insertion !!!"
                        + suiteMessage);
                break;
            case TableModelEvent.DELETE:
                System.out.println("La table a été mise à jour, "
                        + " il y a eu une suppression !!!"
                        + suiteMessage);
                break;
            case TableModelEvent.UPDATE:
                System.out.println("La table a été mise à jour, "
                        + "il y a eu une modification !!!"
                        + suiteMessage);
                break;
            default:
                break;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Checkbox checkBox_Carte;
    private javax.swing.JComboBox jCmBox_Trier;
    private javax.swing.JLabel jLabTitreClient;
    private javax.swing.JLabel jLab_Adresse;
    private javax.swing.JLabel jLab_Ajouter;
    private javax.swing.JLabel jLab_Aperçu;
    private javax.swing.JLabel jLab_CP;
    private javax.swing.JLabel jLab_Carte;
    private javax.swing.JLabel jLab_Code;
    private javax.swing.JLabel jLab_DateCreation;
    private javax.swing.JLabel jLab_Email;
    private javax.swing.JLabel jLab_Exporter;
    private javax.swing.JLabel jLab_Fond;
    private javax.swing.JLabel jLab_Imprimer;
    private javax.swing.JLabel jLab_Mobilis;
    private javax.swing.JLabel jLab_Modifier;
    private javax.swing.JLabel jLab_Nom;
    private javax.swing.JLabel jLab_Prenom;
    private javax.swing.JLabel jLab_Rechercher;
    private javax.swing.JLabel jLab_Remarques;
    private javax.swing.JLabel jLab_Retour;
    private javax.swing.JLabel jLab_SousTitre;
    private javax.swing.JLabel jLab_Supprimer;
    private javax.swing.JLabel jLab_Telephone;
    private javax.swing.JLabel jLab_Trier;
    private javax.swing.JLabel jLab_Ville;
    private javax.swing.JLabel jLab_fond_module;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTXA_Remarque;
    private javax.swing.JTextField jTXT_Adresse;
    private javax.swing.JTextField jTXT_CP;
    private javax.swing.JTextField jTXT_Email;
    private javax.swing.JTextField jTXT_Mobilis;
    private javax.swing.JTextField jTXT_Telephone;
    private javax.swing.JTextField jTXT_Ville;
    private javax.swing.JTextField jTxTCode;
    private javax.swing.JTextField jTxTNom;
    private javax.swing.JTextField jTxT_DateCreation;
    private javax.swing.JTextField jTxT_Prenom;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
