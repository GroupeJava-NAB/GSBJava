package entite;

import controle.connection.ControleConnexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Client extends Personne{
    private boolean carte_fidele;
    private Date date;
    private String adresse;
    private static Connection laConnexion =
            ControleConnexion.getLaConnectionStatique();
    private final ArrayList<Client> lesEnreg = new ArrayList<>();

    public String getAdresse() {
        return adresse;
    }
    public boolean isCarte_Fidele() {
        return carte_fidele;
    }
    public Date getDate_creation() {
        return date;
    }
    public ArrayList<Client> getlesEnreg() {
        return lesEnreg;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public void setCarte_fidele(boolean carte_fidele) {
        this.carte_fidele = carte_fidele;
    }
    public void setDate_creation(Date date_creation) {
        this.date = date_creation;
    }

    public Client(String vCode, String vNom, String vPrenom,
            boolean vCarteFidele, Date vDateCreation, String vAdresse) {
        super(vCode,vNom,vPrenom);
        carte_fidele = vCarteFidele;
        date = vDateCreation;
        adresse = vAdresse;
    }

    public Client(String vCode) {
        super.code = vCode;
    }
    public Client() {
        lireRecupCRUD();
    }
    public Client(String vNom, String vPrenom) {
        super.nom = vNom;
        super.prenom = vPrenom;
    }
    private void lireRecupCRUD() {
        try {
            Statement state = laConnexion.createStatement();
            ResultSet rs = state.executeQuery("SELECT * "
                    + "FROM clients ORDER BY nom");
            while (rs.next()) {
                String codeJ = rs.getString("code");
                String nomJ = rs.getString("nom");
                String prenomJ = rs.getString("prenom");
                boolean carte_fideleJ =
                        rs.getBoolean("carte_fidele");
                Date date_creation = rs.getDate("date");
                lesEnreg.add(new Client(codeJ, nomJ,
                        prenomJ, carte_fideleJ, date_creation, adresse));
            }
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problème rencontré : " + e.getMessage(),
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }
    } 
    
    public boolean creerCRUD(String vCode, String vNom,
            String vPrenom, int vCarte_fidele, String vDate, String vAdresse) {
        boolean bCreation = false;
        String requete = null;
        try {
            requete = "INSERT INTO "
                    + "clients VALUES (?,?,?,?,?,?)";
            PreparedStatement prepare =
                    laConnexion.prepareStatement(requete);
            prepare.setString(1, vCode);
            prepare.setString(2, vNom);
            prepare.setString(3, vPrenom);
            prepare.setInt(4, vCarte_fidele);
            prepare.setString(6, vDate);
            prepare.setString(5, vAdresse);
            prepare.executeUpdate();
            prepare.close();
            bCreation = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Ajout dans la BD non effectué : "
                    + e.getMessage(), "Problème rencontré",
                    JOptionPane.ERROR_MESSAGE);
        }
        return bCreation;
    }
    
    public boolean modifierCRUD(String vCode, String vNom,
            String vPrenom, int vCarte_fidele, String vDate, String vAdresse) {
        boolean bCreation = false;
        String requete = null;
        try {
            requete = "UPDATE clients SET"
                    + " nom = ?,"
                    + " prenom = ?,"
                    + " carte_fidele = ?, "
                    + " date = ?,"
                    + " adresse = ?"
                    + " WHERE code = ?";
            PreparedStatement prepare =
                    laConnexion.prepareStatement(requete);
            prepare.setString(1, vNom);
            prepare.setString(2, vPrenom);
            prepare.setInt(3, vCarte_fidele);
            prepare.setString(4, vDate);
            prepare.setString(5, vCode);
            prepare.setString(6, vAdresse);
            prepare.executeUpdate();
            prepare.close();
            bCreation = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Ajout dans la BD non effectué : "
                    + e.getMessage(), "Problème rencontré",
                    JOptionPane.ERROR_MESSAGE);
        }
        return bCreation;
    }
    
    public boolean supprimerCRUD(String vCode) {
        boolean bSuppression = true;
        String requete = null;
        try {
            String requeteClient =
                    "SELECT count(*) AS nbLignes FROM factures "
                    + " WHERE code_client LIKE '" + vCode + "'";
            Statement state = laConnexion.createStatement();
            ResultSet jeuEnreg =
                    state.executeQuery(requeteClient);
            int nbLignes = 0;
            jeuEnreg.next();
            nbLignes = jeuEnreg.getInt("nbLignes");
            if (nbLignes > 0) {
                bSuppression = false;
                JOptionPane.showMessageDialog(null,
                        "Il existe des factures pour ce client."
                        + " Suppression interdite.",
                        "Résultat", JOptionPane.ERROR_MESSAGE);
                bSuppression = false;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Aucune facture pour ce client."
                        + " Suppression autorisée.",
                        "Résultat",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            bSuppression = false;
            JOptionPane.showMessageDialog(null,
                    "Aucune suppression effectuée dans la BD : "
                    + e.getMessage(),
                    "Problème rencontré",
                    JOptionPane.ERROR_MESSAGE);
        }
        if (bSuppression == true) {
            try {
                requete = "DELETE FROM clients"
                        + " WHERE Code = '" + vCode + "'";
                Statement state = laConnexion.createStatement();
                int nbEnregSup = state.executeUpdate(requete);

                state.close();

                if (nbEnregSup == 0) {
                    JOptionPane.showMessageDialog(null,
                            "Aucun enregistrement correspondant.",
                            "Résultat", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                bSuppression = false;
                JOptionPane.showMessageDialog(null,
                        "Aucune suppression effectuée dans la BD : "
                        + e.getMessage(),
                        "Problème rencontré", JOptionPane.ERROR_MESSAGE);
            }
        }
        return bSuppression;
    }
    
    public ArrayList<Client> chercherCRUD(String vCode,
            String vNom, String vPrenom) {
        if (vCode.equals("")) {
            vCode = "%";
        }
        if (vNom.equals("")) {
            vNom = "%";
        }
        if (vPrenom.equals("")) {
            vPrenom = "%";
        }

        String requete = "SELECT * FROM clients"
                + " WHERE code LIKE '" + vCode + "'"
                + " AND nom LIKE '" + vNom + "'"
                + " AND prenom LIKE '" + vPrenom + "'";
        try {
            Statement state = laConnexion.createStatement();
            ResultSet rs = state.executeQuery(requete);
            while (rs.next()) {
                String codeJ = rs.getString("code");
                String nomJ = rs.getString("nom");
                String prenomJ = rs.getString("prenom");
                boolean carte_fideleJ =
                        rs.getBoolean("carte_fidele");
                String adresseJ = rs.getString("adresse");
                Date date_creation = rs.getDate("date");
                lesEnreg.add(new Client(codeJ, nomJ,
                        prenomJ, carte_fideleJ, date_creation, adresseJ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problème rencontré : "
                    + e.getMessage(),
                    "Résultat",
                    JOptionPane.ERROR_MESSAGE);
        }
        return lesEnreg;
    }
    
    public ArrayList<Client> chercherCRUD(String recherche) {
        String requete = "SELECT * FROM clients"
                + " WHERE code LIKE '%" + recherche + "%'"
                + " OR nom LIKE '%" + recherche + "%'"
                + " OR prenom LIKE '%" + recherche + "%'";
        try {
            Statement state = laConnexion.createStatement();
            ResultSet rs = state.executeQuery(requete);
            while (rs.next()) {
                String codeJ = rs.getString("code");
                String nomJ = rs.getString("nom");
                String prenomJ = rs.getString("prenom");
                boolean carte_fideleJ =
                        rs.getBoolean("carte_fidele");
                Date date_creation = rs.getDate("date");
                String adresseJ = rs.getString("adresse");
                lesEnreg.add(new Client(codeJ, nomJ, prenomJ,
                        carte_fideleJ, date_creation, adresseJ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problème rencontré : "
                    + e.getMessage(),
                    "Résultat", JOptionPane.ERROR_MESSAGE);
        }
        return lesEnreg;
    }

}
