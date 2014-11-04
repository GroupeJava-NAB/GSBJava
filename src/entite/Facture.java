/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;
import controle.connection.ControleConnexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author Utilisateur
 */
public class Facture {
    private String code;
    private Client code_client;
    private double total_ttc;
    private int codeModeReglement;
    private ModeReglement mode_reglement;
    private Date date;
    
    private static Connection laConnexion = ControleConnexion.getLaConnectionStatique();
    private final ArrayList<Facture> lesEnreg = new ArrayList<>();
    
    //Constructeur 1
    public Facture(String code, Client code_client, double total_ttc,
            ModeReglement mode_reglement, Date date){
        this.code=code;
        this.code_client = code_client;
        this.total_ttc = total_ttc;
        this.mode_reglement = mode_reglement;
        this.date = date;
    }
    // Constructeur 2
    public Facture(){
    // à activer dès création de la méthode
    // lireRecupCRUD();
    }
    
    // Constructeur 3 pour initier la recherche
    public Facture(String code){
    }
    
    //Getters/Setters

    public String getCode() {
        return code;
    }

    public Client getCode_client() {
        return code_client;
    }

    public double getTotal_ttc() {
        return total_ttc;
    }

    public int getCodeModeReglement() {
        return codeModeReglement;
    }

    public ModeReglement getMode_reglement() {
        return mode_reglement;
    }

    public Date getDate() {
        return date;
    }

    public ArrayList<Facture> getLesEnreg() {
        return lesEnreg;
    } 
    
//------------------------------------------------------------------------------
// CRUD
//------------------------------------------------------------------------------

// Lecture de la table entière et récupération des enregistrements
private void lireRecupCRUD() {
try {
    Statement state = laConnexion.createStatement();
    ResultSet rs = state.executeQuery("SELECT com.code,"
        + " com.total_ttc, com.date, cli.nom, "
        + "cli.prenom, mode.type "
        + "FROM factures AS com, clients AS cli, "
        + "mode_reglements AS mode "
        + "WHERE com.code_mode_reglement = mode.code "
        + "AND com.code_client = cli.code");
    while (rs.next()) {
// Informations générales sur la facture
        String codeJ = rs.getString("code");
        double total_ttcJ = rs.getDouble("total_ttc");
        Date dateJ = rs.getDate("date");
// Information client
        String nomJ = rs.getString("nom");
        String prenomJ = rs.getString("prenom");
// Information mode règlement
        String typeJ = rs.getString("type");
        lesEnreg.add(new Facture(codeJ,
            new Client(nomJ, prenomJ),
            total_ttcJ,
            new ModeReglement(typeJ),
            dateJ));
    }
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null,
        "Problème rencontré",
        "ALERTE", JOptionPane.ERROR_MESSAGE);
}
}

//Ajout d'une nouvelle facture
public boolean creerCRUD(String vCode, String vCode_Client,
    double vTotalTTC, int vCode_Mode_Reglement) {
    boolean bCreation = false;
    String requete = null;
try {
    requete = "INSERT INTO "
            + "factures VALUES (?,?,?,?,NOW())"; 
    PreparedStatement prepare = laConnexion.prepareStatement(requete);
    prepare.setString(1, vCode);
    prepare.setString(2, vCode_Client);
    prepare.setDouble(3, vTotalTTC);
    prepare.setInt(4, vCode_Mode_Reglement);
    prepare.executeUpdate();
    bCreation = true;
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null,
        "Ajout dans la BD non effectué : "
        + e.getMessage(), "Problème rencontré",
        JOptionPane.ERROR_MESSAGE);
}
return bCreation;
}

//Suppression d'une facture
public boolean supprimerCRUD(String vCode) {
    boolean bSuppression = true;
    String requete = null;
try {
    requete = "DELETE factures, lignes_factures"
            + " FROM factures, lignes_factures "
            + "WHERE code_facture = code AND code = ?";
    PreparedStatement prepare = laConnexion.prepareStatement(requete);
    prepare.setString(1, vCode);
    int nbEnregSup = prepare.executeUpdate();
    if (nbEnregSup == 0) {
        JOptionPane.showMessageDialog(null,
            "Aucune suppression effectuée dans la BD.",
            "Problème rencontré",
             JOptionPane.ERROR_MESSAGE);
}
} catch (SQLException e) {
    bSuppression = false;
    JOptionPane.showMessageDialog(null,
    "Aucune suppression effectuée dans la BD.",
    "Problème rencontré",
    JOptionPane.ERROR_MESSAGE);
}
return bSuppression;
}

// Recherche
public ArrayList<Facture> chercherCRUD(String recherche) {
    String requete = "";
    requete += "SELECT com.code, com.total_ttc,"
            + " com.date, cli.nom, cli.prenom, mode.type ";
    requete += "FROM factures AS com, clients AS cli,"
            + " mode_reglements AS mode ";
    requete += "WHERE com.code_mode_reglement = mode.code ";
    requete += "AND com.code_client = cli.code AND (";
    requete += "com.code LIKE ’%" + recherche + "%’ ";
    requete += "OR cli.nom LIKE ’%" + recherche + "%’ ";
    requete += "OR cli.prenom LIKE ’%" + recherche + "%’ ";
    requete += "OR com.total_ttc LIKE ’%" + recherche + "%’ ";
    requete += "OR mode.type LIKE ’%" + recherche + "%’)";
try {
    Statement state = laConnexion.createStatement();
    ResultSet rs = state.executeQuery(requete);
    while (rs.next()) {
        String codeJ = rs.getString("code");
        double total_ttcJ = rs.getDouble("total_ttc");
        Date dateJ = rs.getDate("date");
// Informations client
        String nom = rs.getString("nom");
        String prenom = rs.getString("prenom");
// Informations mode reglement
        String type = rs.getString("type");
        lesEnreg.add(new Facture(codeJ,
            new Client(nom, prenom),
            total_ttcJ,
            new ModeReglement(type),
            dateJ));
    }
} catch (SQLException e) {
JOptionPane.showMessageDialog(null,
        "Problème rencontré : " + e.getMessage(),
        "Résultat", JOptionPane.ERROR_MESSAGE);
}
return lesEnreg;
}
}
